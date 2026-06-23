package cmms.MasterData.Dto;

import cmms.MasterData.entity.CarModule.FuelType;
import cmms.MasterData.entity.CarModule.Transmission;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

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
}
