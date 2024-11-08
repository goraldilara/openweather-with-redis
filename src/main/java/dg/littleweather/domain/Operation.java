package dg.littleweather.domain;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

@Data
@EqualsAndHashCode
@RedisHash("operations")
public class Operation implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String operationType;
    private String operationDetail;

    public Operation(){

    }

    public Operation(String operationType, String operationDetail) {
        this.operationType = operationType;
        this.operationDetail = operationDetail;
    }

    public Operation(int id, String operationType, String operationDetail) {
        this.id = id;
        this.operationType = operationType;
        this.operationDetail = operationDetail;
    }
}
