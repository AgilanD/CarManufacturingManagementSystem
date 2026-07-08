package cmms.masterdata.service;

import cmms.masterdata.dto.PlantsRequestDto;
import cmms.masterdata.dto.PlantsResponseDto;
import cmms.masterdata.entity.Plants;

import java.util.List;

public interface PlantsService {

    public List<Plants> getPlants();

    public Plants saveAll(Plants plants);

    public PlantsResponseDto createPlants (PlantsRequestDto plantsRequestDto);

    PlantsResponseDto updatePlant(Long id, PlantsRequestDto plantsRequestDto);

    PlantsResponseDto softDeletePlant(Long id);
}
