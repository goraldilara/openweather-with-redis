package dg.littleweather.domain.dto.detailed;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Snow {
    @JsonProperty("1h")
    public double _1h;
    @JsonProperty("3h")
    public double _3h;
}
