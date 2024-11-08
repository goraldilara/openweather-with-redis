package dg.littleweather.repository;

import dg.littleweather.domain.Operation;
import org.springframework.data.repository.CrudRepository;

public interface OperationRedisRepository extends CrudRepository<Operation, Integer> {
}
