package cmms.MasterData.util;

import cmms.MasterData.Dto.CarModuleRequestDto;
import cmms.MasterData.Dto.CarModuleResponseDto;
import cmms.MasterData.Dto.PlantsRequestDto;
import cmms.MasterData.Dto.PlantsResponseDto;
import cmms.MasterData.entity.CarModule;
import cmms.MasterData.entity.Plants;

public class PlantsMapper {

    public static Plants PlantsRequestDtoToPlants(PlantsRequestDto PlantsRequestDto){

        if(PlantsRequestDto == null ) return null;

        return Plants.builder()
                .name(PlantsRequestDto.getName())
                .capacityPerDay(PlantsRequestDto.getCapacityPerDay())
                .code(PlantsRequestDto.getCode())
                .location(PlantsRequestDto.getLocation())
                .build();
    }

    public static PlantsResponseDto PlantsToPlantsResponseDto(Plants plants){

        if (plants == null) return null;

        return PlantsResponseDto.builder()
                .id(plants.getId())
                .isActive(plants.getIsActive())
                .name(plants.getName())
                .capacityPerDay(plants.getCapacityPerDay())
                .code(plants.getCode())
                .location(plants.getLocation())
                .build();
    }

}
