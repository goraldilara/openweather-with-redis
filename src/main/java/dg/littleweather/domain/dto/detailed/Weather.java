package dg.littleweather.domain.dto.detailed;
import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Weather {
    public int id;
    public String main;
    public String description;
    public String icon;
}
