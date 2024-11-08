package dg.littleweather.domain.dto;

import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class HourlyDataDTO {

    private String dateAndHour;
    private double max_temp;
    private double feels_like_temp;
    private int humidity_rate;

}
