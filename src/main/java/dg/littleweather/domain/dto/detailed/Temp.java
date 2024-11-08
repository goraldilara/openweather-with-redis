package dg.littleweather.domain.dto.detailed;
import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Temp {
    public double day;
    public double min;
    public double max;
    public double night;
    public double eve;
    public double morn;
}
