package cmms.MasterData.Dto;

import cmms.MasterData.entity.CarModule.FuelType;
import cmms.MasterData.entity.CarModule.Transmission;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

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
