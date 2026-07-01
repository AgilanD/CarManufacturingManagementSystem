package cmms.masterdata.dto;

import cmms.masterdata.entity.CarModule.FuelType;
import cmms.masterdata.entity.CarModule.Transmission;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CarModuleResponseDto {

    private Long id;
    private String modelName;
    private FuelType fuelType;
    private Transmission transmission;
    private BigDecimal basePrice;
    private String colorOptions;
    private LocalDate launchDate;
    private Boolean isActive;





    private LocalDateTime createdAt;

    private Long createdBy;

    private LocalDateTime lastModifiedAt;

    private Long lastModifiedBy;






}
