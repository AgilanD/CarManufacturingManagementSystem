package cmms.MasterData.util;

import cmms.MasterData.Dto.CarModuleRequestDto;
import cmms.MasterData.Dto.CarModuleResponseDto;
import cmms.MasterData.Dto.PlantsRequestDto;
import cmms.MasterData.Dto.PlantsResponseDto;
import cmms.MasterData.entity.CarModule;
import cmms.MasterData.entity.Plants;
import org.springframework.stereotype.Component;

@Component
public class PlantsMapper {

    public Plants PlantsRequestDtoToPlants(PlantsRequestDto PlantsRequestDto){

        if(PlantsRequestDto == null ) return null;

        return Plants.builder()
                .name(PlantsRequestDto.getName())
                .capacityPerDay(PlantsRequestDto.getCapacityPerDay())
                .code(PlantsRequestDto.getCode())
                .location(PlantsRequestDto.getLocation())
                .build();
    }

    public PlantsResponseDto PlantsToPlantsResponseDto(Plants plants){

        if (plants == null) return null;

        return PlantsResponseDto.builder()
                .id(plants.getId())

                .createdBy(plants.getCreatedBy())
                .createdAt(plants.getCreatedAt())
                .lastModifiedBy(plants.getLastModifiedBy())
                .lastModifiedAt(plants.getLastModifiedAt())

                .isActive(plants.getIsActive())
                .name(plants.getName())
                .capacityPerDay(plants.getCapacityPerDay())
                .code(plants.getCode())
                .location(plants.getLocation())
                .build();
    }

}
