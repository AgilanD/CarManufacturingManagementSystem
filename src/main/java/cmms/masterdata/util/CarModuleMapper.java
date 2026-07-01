package cmms.masterdata.util;

import cmms.masterdata.dto.CarModuleRequestDto;
import cmms.masterdata.dto.CarModuleResponseDto;
import cmms.masterdata.entity.CarModule;
import org.springframework.stereotype.Component;

@Component
public class CarModuleMapper {

    public  CarModule carModuleRequesttoCarModule(CarModuleRequestDto carModuleRequestDto){

        if(carModuleRequestDto == null ) return null;

        return CarModule.builder()
                .basePrice(carModuleRequestDto.getBasePrice())
                .colorOptions(carModuleRequestDto.getColorOptions())
                .fuelType(carModuleRequestDto.getFuelType())
                .launchDate(carModuleRequestDto.getLaunchDate())
                .modelName(carModuleRequestDto.getModelName())
                .transmission(carModuleRequestDto.getTransmission())
                .build();

    }

    public  CarModuleResponseDto customerToCustomerResponseDto(CarModule carModule){

        if (carModule == null) return null;

        return CarModuleResponseDto.builder()
                .id(carModule.getId())

                .createdBy(carModule.getCreatedBy())
                .createdAt(carModule.getCreatedAt())
                .lastModifiedAt(carModule.getLastModifiedAt())
                .lastModifiedBy(carModule.getLastModifiedBy())

                .basePrice(carModule.getBasePrice())
                .colorOptions(carModule.getColorOptions())
                .fuelType(carModule.getFuelType())
                .modelName(carModule.getModelName())
                .launchDate(carModule.getLaunchDate())
                .transmission(carModule.getTransmission())
                .isActive(carModule.getIsActive())
                .build();
    }


}
