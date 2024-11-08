package dg.littleweather.repository;

import dg.littleweather.domain.entity.CityWeather;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityWeatherRepository extends JpaRepository<CityWeather, Integer> {

    CityWeather findCityWeatherByCityName(String cityName);
    void deleteCityWeatherByCityName(String cityName);

}
