package dg.littleweather.domain.dto;

import dg.littleweather.domain.dto.detailed.Hourly;
import dg.littleweather.domain.dto.detailed.Daily;

import java.util.ArrayList;
import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class HourlyForecast {
    public double lat;
    public double lon;
    public String timezone;
    public int timezone_offset;
    public ArrayList<Hourly> hourly;
    public ArrayList<Daily> daily;
}
