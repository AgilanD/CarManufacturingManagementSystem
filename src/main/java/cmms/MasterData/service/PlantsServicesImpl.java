package cmms.MasterData.service;

import cmms.MasterData.Dto.CarModuleRequestDto;
import cmms.MasterData.Dto.CarModuleResponseDto;
import cmms.MasterData.Dto.PlantsRequestDto;
import cmms.MasterData.Dto.PlantsResponseDto;
import cmms.MasterData.entity.CarModule;
import cmms.MasterData.entity.Plants;
import cmms.MasterData.repository.PlantRepository;
import cmms.MasterData.util.CarModuleMapper;
import cmms.MasterData.util.PlantsMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PlantsServicesImpl implements PlantsService{

   private final PlantRepository plantRepository;
   private final PlantsMapper plantsMapper;

   public List<Plants> GetPlants(){
      return plantRepository.findAll();
   }

   public Plants SaveAll(Plants plants){
      return plantRepository.save(plants);
   }

   public PlantsResponseDto CreatePlants (PlantsRequestDto PlantsRequestDto){


      Plants plants = SaveAll(plantsMapper.PlantsRequestDtoToPlants(PlantsRequestDto));

      return plantsMapper.PlantsToPlantsResponseDto(plants);

   }

}
