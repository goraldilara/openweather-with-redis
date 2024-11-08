package dg.littleweather.service;

import dg.littleweather.domain.Operation;
import dg.littleweather.domain.dto.CityInfo;
import dg.littleweather.domain.dto.CityWeatherDTO;
import dg.littleweather.domain.dto.HourlyDataDTO;
import dg.littleweather.domain.entity.CityWeather;
import dg.littleweather.domain.entity.HourlyData;
import dg.littleweather.repository.CityWeatherRepository;
import dg.littleweather.repository.HourlyDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LittleWeatherService {

    OpenWeatherService openWeatherService;
    CityWeatherRepository cityWeatherRepository;
    HourlyDataRepository hourlyDataRepository;
    OperationService operationService;

    @Autowired
    public LittleWeatherService(OpenWeatherService openWeatherService, CityWeatherRepository cityWeatherRepository, HourlyDataRepository hourlyDataRepository, OperationService operationService) {
        this.openWeatherService = openWeatherService;
        this.cityWeatherRepository = cityWeatherRepository;
        this.hourlyDataRepository = hourlyDataRepository;
        this.operationService = operationService;
    }

    public CityInfo getCityInfo(String cityName) {

        return openWeatherService.getCityInfo(cityName);
    }

    public CityWeatherDTO getHourlyWeatherByCity(String cityName) {

        CityInfo cityInfo = openWeatherService.getCityInfo(cityName);
        CityWeatherDTO cityWeatherDTO = openWeatherService.getHourlyWeatherByCity(cityInfo, cityName);

        //save info to the db
        saveHourWeatherOfCity(cityWeatherDTO);
        //SAVE OP

        return cityWeatherDTO;
    }

    public CityWeatherDTO saveHourWeatherOfCity(CityWeatherDTO cityWeatherDTO){

        List<HourlyData> hourlyDataList = new ArrayList<>();
        CityWeather cityWeather = new CityWeather(cityWeatherDTO.getCity_name());
        cityWeatherDTO.getHourlyData().stream().forEach(k-> {
            HourlyData hourlyData = new HourlyData(k.getDateAndHour(),k.getMax_temp(),k.getFeels_like_temp(),k.getHumidity_rate());
            hourlyDataList.add(hourlyData);
            cityWeather.add(hourlyData);
        }
        );

        cityWeatherRepository.save(cityWeather);

        return cityWeatherDTO;
    }

    public void deleteAllHourlyData() {
        hourlyDataRepository.deleteAll();
    }

    public void deleteAllCityData() {
        cityWeatherRepository.deleteAll();
    }

    public void deleteCityWeatherByCityName(String cityName) {
        cityWeatherRepository.deleteCityWeatherByCityName(cityName);
    }

    public CityWeatherDTO getCityByCityName(String cityName) {
        CityWeather cityWeather = cityWeatherRepository.findCityWeatherByCityName(cityName);
        List<HourlyData> hourlyData = hourlyDataRepository.findHourlyDataByCityWeatherId(cityWeather.getId());

        List<HourlyDataDTO> hourlyDataDTOS = new ArrayList<>();
        hourlyData.stream().forEach(k -> hourlyDataDTOS.add(new HourlyDataDTO(k.getDateAndHour(),k.getMax_temp(),k.getFeels_like_temp(),k.getHumidity_rate())));

        CityWeatherDTO cityWeatherDTO = new CityWeatherDTO(cityName, hourlyDataDTOS);
        return cityWeatherDTO;
    }

    public String updateCity(String cityName) {
        String[] cityParts = cityName.split(",");
        CityWeather cityWeather = cityWeatherRepository.findCityWeatherByCityName(cityParts[0]);
        cityWeather.setCityName(cityParts[1]);
        cityWeatherRepository.save(cityWeather);
        return cityParts[1];
    }
}
