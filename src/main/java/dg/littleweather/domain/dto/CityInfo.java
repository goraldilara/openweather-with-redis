package dg.littleweather.domain.dto;

import dg.littleweather.domain.dto.detailed.*;

import java.util.ArrayList;
import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CityInfo {
    public Coord coord;
    public ArrayList<Weather> weather;
    public String base;
    public Main main;
    public int visibility;
    public Wind wind;
    public Rain rain;
    public Snow snow;
    public Clouds clouds;
    public int dt;
    public Sys sys;
    public int timezone;
    public int id;
    public String name;
    public int cod;
}
