package cmms.MasterData.util;

import cmms.MasterData.Dto.CarModuleRequestDto;
import cmms.MasterData.Dto.CarModuleResponseDto;
import cmms.MasterData.entity.CarModule;

public class CarModuleMapper {

    public static CarModule CarModuleRequesttoCarModule(CarModuleRequestDto carModuleRequestDto){

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

    public static CarModuleResponseDto CustomerToCustomerResponseDto(CarModule carModule){

        if (carModule == null) return null;

        return CarModuleResponseDto.builder()
                .id(carModule.getId())
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
