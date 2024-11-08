package dg.littleweather.domain.dto.detailed;

import java.util.ArrayList;
import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Hourly {
    public int dt;
    public double temp;
    public double feels_like;
    public int pressure;
    public int humidity;
    public double dew_point;
    public double uvi;
    public int clouds;
    public int visibility;
    public double wind_speed;
    public int wind_deg;
    public double wind_gust;
    public Rain rain;
    public Snow snow;
    public ArrayList<Weather> weather;
    public int pop;
}
