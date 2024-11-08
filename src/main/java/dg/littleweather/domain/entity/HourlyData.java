package dg.littleweather.domain.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "hourly_data")
@Getter
@Setter
public class HourlyData {

    @Id
    @NotNull
    @Column(name= "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "city_weather_id")
    private CityWeather cityWeather;

    @Size(min = 1, max = 45)
    @Column(name = "date_and_hour")
    private String dateAndHour;

    @Column(name = "max_temp")
    private double max_temp;

    @Column(name = "feels_like_temp")
    private double feels_like_temp;

    @Column(name = "humidity_rate")
    private int humidity_rate;

    public HourlyData(){

    }

    public HourlyData(String dateAndHour, double max_temp, double feels_like_temp, int humidity_rate) {
        this.dateAndHour = dateAndHour;
        this.max_temp = max_temp;
        this.feels_like_temp = feels_like_temp;
        this.humidity_rate = humidity_rate;
    }

    @NotNull
    public int getId() {
        return id;
    }

    public void setId(@NotNull int id) {
        this.id = id;
    }

    public CityWeather getCityWeather() {
        return cityWeather;
    }

    public void setCityWeather(CityWeather cityWeather) {
        this.cityWeather = cityWeather;
    }

    public @Size(min = 1, max = 45) String getDateAndHour() {
        return dateAndHour;
    }

    public void setDateAndHour(@Size(min = 1, max = 45) String dateAndHour) {
        this.dateAndHour = dateAndHour;
    }

    public double getMax_temp() {
        return max_temp;
    }

    public void setMax_temp(double max_temp) {
        this.max_temp = max_temp;
    }

    public double getFeels_like_temp() {
        return feels_like_temp;
    }

    public void setFeels_like_temp(double feels_like_temp) {
        this.feels_like_temp = feels_like_temp;
    }

    public int getHumidity_rate() {
        return humidity_rate;
    }

    public void setHumidity_rate(int humidity_rate) {
        this.humidity_rate = humidity_rate;
    }
}
