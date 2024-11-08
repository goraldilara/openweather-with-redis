package dg.littleweather.domain.dto;

import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OperationDTO{
    private String operationType;
    private String operationDetail;
}
