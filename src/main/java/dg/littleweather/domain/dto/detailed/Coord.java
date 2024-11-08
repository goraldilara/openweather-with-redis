package dg.littleweather.domain.dto.detailed;

import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Coord {
    public double lat;
    public double lon;
}
