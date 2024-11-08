package dg.littleweather.repository;

import dg.littleweather.domain.entity.HourlyData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HourlyDataRepository extends JpaRepository<HourlyData, Integer> {
    List<HourlyData> findHourlyDataByCityWeatherId(int cityId);
}
