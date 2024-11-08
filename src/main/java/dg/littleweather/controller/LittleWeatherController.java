package dg.littleweather.controller;
import dg.littleweather.domain.dto.CityInfo;
import dg.littleweather.domain.dto.CityWeatherDTO;
import dg.littleweather.service.LittleWeatherService;
import jakarta.transaction.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/weather")
public class LittleWeatherController {

    //service object
    private LittleWeatherService littleWeatherService;

    //constructor injection
    public LittleWeatherController(LittleWeatherService theWeatherService){littleWeatherService = theWeatherService;}

    /*
    @PostMapping("/cityInfo")
    public CityInfo getCityInfo(){
        return littleWeatherService.getCityInfo("Ankara"); //ankara ile bilgi getir
    }
    */

    //get a single weather for the given city name
    //CREATE
    @PostMapping("/hourly")
    public CityWeatherDTO getHourlyWeatherByCity(@RequestBody String cityName){
        return littleWeatherService.getHourlyWeatherByCity(cityName);
    }

    //READ
    @PostMapping("/readCity")
    public CityWeatherDTO getCityByCityName(@RequestBody String cityName){
        return littleWeatherService.getCityByCityName(cityName);
    }

    //UPDATE
    @PostMapping("/updateCity")
    public String updateCity(@RequestBody String cityName){
        String newCityName = littleWeatherService.updateCity(cityName);
        return "New city name is " + newCityName;
    }

    //DELETE
    @Transactional
    @PostMapping("/deleteCity")
    public String deleteCityByCityName(@RequestBody String cityName){
        littleWeatherService.deleteCityWeatherByCityName(cityName);
        return "All city data deleted";
    }

    @PostMapping("/cityDeleteAll")
    public String deleteAllCityData(){
        littleWeatherService.deleteAllCityData();
        return "All city data deleted";
    }

    @PostMapping("/hourlyDeleteAll")
    public String deleteAllHourlyData(){
        littleWeatherService.deleteAllHourlyData();
        return "All hourly data deleted";
    }
}
