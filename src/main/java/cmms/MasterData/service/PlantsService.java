package cmms.MasterData.service;

import cmms.MasterData.Dto.PlantsRequestDto;
import cmms.MasterData.Dto.PlantsResponseDto;
import cmms.MasterData.entity.Plants;

import java.util.List;

public interface PlantsService {

    public List<Plants> GetPlants();

    public Plants SaveAll(Plants plants);

    public PlantsResponseDto CreatePlants (PlantsRequestDto PlantsRequestDto);


}
