package dg.littleweather.domain.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name= "city_weather")
public class CityWeather {

    @Id
    @NotNull
    @Column(name= "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Size(min = 1, max = 45)
    @Column(name = "city_name")
    private String cityName;

    @OneToMany(mappedBy = "cityWeather",
                cascade = {CascadeType.PERSIST, CascadeType.MERGE,
                            CascadeType.DETACH, CascadeType.REFRESH})
    private List<HourlyData> hourlyData;

    public CityWeather() {}

    public CityWeather(String cityName) {
        this.cityName = cityName;
    }

    public CityWeather(String cityName, List<HourlyData> hourlyData) {
        this.cityName = cityName;
        this.hourlyData = hourlyData;
    }

    @NotNull
    public int getId() {
        return id;
    }

    public void setId(@NotNull int id) {
        this.id = id;
    }

    public @Size(min = 1, max = 45) String getCityName() {
        return cityName;
    }

    public void setCityName(@Size(min = 1, max = 45) String cityName) {
        this.cityName = cityName;
    }

    public List<HourlyData> getHourlyData() {
        return hourlyData;
    }

    public void setHourlyData(List<HourlyData> hourlyData) {
        this.hourlyData = hourlyData;
    }

    public void add(HourlyData tempHourlyData){
        if(hourlyData == null){
            hourlyData = new ArrayList<>();
        }

        hourlyData.add(tempHourlyData);
        tempHourlyData.setCityWeather(this);
    }
}
