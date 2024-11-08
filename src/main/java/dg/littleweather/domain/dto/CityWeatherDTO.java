package dg.littleweather.domain.dto;

import java.util.ArrayList;
import java.util.List;

import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CityWeatherDTO {

    private String city_name;
    private List<HourlyDataDTO> hourlyData;

}
