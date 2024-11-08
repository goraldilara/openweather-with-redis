package dg.littleweather.domain.dto.detailed;

import java.util.ArrayList;

import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Daily {
    public int dt;
    public int sunrise;
    public int sunset;
    public int moonrise;
    public int moonset;
    public double moon_phase;
    public Temp temp;
    public FeelsLike feels_like;
    public int pressure;
    public int humidity;
    public double dew_point;
    public double wind_speed;
    public int wind_deg;
    public double wind_gust;
    public ArrayList<Weather> weather;
    public int clouds;
    public int pop;
    public double uvi;
    public double rain;
    public double snow;
}
