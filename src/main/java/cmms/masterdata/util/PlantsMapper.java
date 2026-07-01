package cmms.masterdata.util;

import cmms.masterdata.dto.PlantsRequestDto;
import cmms.masterdata.dto.PlantsResponseDto;
import cmms.masterdata.entity.Plants;
import org.springframework.stereotype.Component;

@Component
public class PlantsMapper {

    public Plants plantsRequestDtoToPlants(PlantsRequestDto plantsRequestDto){

        if(plantsRequestDto == null ) return null;

        return Plants.builder()
                .name(plantsRequestDto.getName())
                .capacityPerDay(plantsRequestDto.getCapacityPerDay())
                .code(plantsRequestDto.getCode())
                .location(plantsRequestDto.getLocation())
                .build();
    }

    public PlantsResponseDto plantsToPlantsResponseDto(Plants plants){

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
