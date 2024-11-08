package dg.littleweather.domain.dto.detailed;

import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class FeelsLike {
    public double day;
    public double night;
    public double eve;
    public double morn;
}
