package dg.littleweather.domain.dto.detailed;
import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Wind {
    public double speed;
    public int deg;
    public double gust;
}
