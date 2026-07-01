package cmms.masterdata.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PlantsResponseDto {

    private Long id;
    private String name;
    private String code;
    private String location;
    private Integer capacityPerDay;
    private Boolean isActive;




    private LocalDateTime createdAt;
    private Long createdBy ;
    private LocalDateTime lastModifiedAt;
    private Long lastModifiedBy ;


}
