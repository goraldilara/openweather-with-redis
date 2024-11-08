package dg.littleweather.service;

import dg.littleweather.domain.dto.CityInfo;
import dg.littleweather.domain.dto.CityWeatherDTO;
import dg.littleweather.domain.dto.HourlyDataDTO;
import dg.littleweather.domain.dto.HourlyForecast;
import dg.littleweather.exceptions.OpenWeatherServiceException;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashMap;

import static dg.littleweather.domain.constants.LittleWeatherConstants.*;
import static dg.littleweather.util.WeatherOperations.unixToDate;

@Service
public class OpenWeatherService {

    RestTemplate restTemplate;

    public OpenWeatherService() { restTemplate = new RestTemplate();}

    public CityInfo getCityInfo(String cityName){

        RestTemplate restTemplate = new RestTemplate();

        CityInfo cityInfo = restTemplate.getForObject(CITY_INFO_URL + "?q=" + cityName + "&appid=" + OPEN_WEATHER_API_KEY , CityInfo.class);

        if(cityInfo == null) {
            throw new OpenWeatherServiceException("The weather information for the city called " + cityName + " not found");
        }
        return cityInfo;
    }

    public CityWeatherDTO getHourlyWeatherByCity(CityInfo cityInfo, String cityName) {

        //set exclude parameter of the url
        String exclude = "current,minutely,alerts";
        HashMap<String,Double> max_temp_of_the_day = new HashMap<String, Double>();
        ArrayList<HourlyDataDTO> hourlyData = new ArrayList<HourlyDataDTO>();

        //hourlydata fields
        String dateAndHour = "";
        double max_temp = 0.0;
        double feels_like_temp = 0.0;
        int humidity_rate = 0;

        HourlyForecast hourlyForecast = restTemplate.getForObject(HOURLY_WEATHER_URL + "?lat=" + cityInfo.coord.getLat() + "&lon=" + cityInfo.coord.getLon() + "&exclude=" + exclude + "&appid=" + OPEN_WEATHER_API_KEY, HourlyForecast.class);

        if(hourlyForecast == null) {
            throw new OpenWeatherServiceException("The weather information for the city not found");
        }

        //fill the map with the maximum temp by daily maximum temp data
        for(int i = 0; i < 3;i++){
            max_temp_of_the_day.put(unixToDate(hourlyForecast.getDaily().get(i).dt), hourlyForecast.getDaily().get(i).getTemp().getMax());
        }

        //create HourlyData objects and fill the arraylist with objects
        for(int i = 0; i < 48; i++){
            //set dataAndHour field by unix (dt) of the hourly object in wanted order
            dateAndHour = unixToDate(hourlyForecast.getHourly().get(i).getDt(), cityName, hourlyForecast.getTimezone_offset());
            //set the max temps for the hours
            if(max_temp_of_the_day.containsKey(unixToDate(hourlyForecast.getHourly().get(i).dt))){
                max_temp = max_temp_of_the_day.get(unixToDate(hourlyForecast.getHourly().get(i).dt));
            }
            //set other fields
            feels_like_temp = hourlyForecast.getHourly().get(i).getFeels_like();
            humidity_rate = hourlyForecast.getHourly().get(i).getHumidity();
            //fill the arraylist by the HourlyData object
            hourlyData.add(new HourlyDataDTO(dateAndHour,max_temp,feels_like_temp,humidity_rate));
        }

        return new CityWeatherDTO(cityName, hourlyData);

    }

}
