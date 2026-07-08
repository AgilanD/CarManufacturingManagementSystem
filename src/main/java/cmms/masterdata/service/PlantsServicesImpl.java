package cmms.masterdata.service;

import cmms.masterdata.dto.PlantsRequestDto;
import cmms.masterdata.dto.PlantsResponseDto;
import cmms.masterdata.entity.Plants;
import cmms.masterdata.repository.PlantRepository;
import cmms.masterdata.util.PlantsMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PlantsServicesImpl implements PlantsService {

   private final PlantRepository plantRepository;
   private final PlantsMapper plantsMapper;

   public List<Plants> getPlants(){
      return plantRepository.findAll();
   }

   public Plants saveAll(Plants plants){
      return plantRepository.save(plants);
   }

   public PlantsResponseDto createPlants (PlantsRequestDto plantsRequestDto){
      Plants plants = saveAll(plantsMapper.plantsRequestDtoToPlants(plantsRequestDto));
      return plantsMapper.plantsToPlantsResponseDto(plants);
   }

   public PlantsResponseDto updatePlant(Long id, PlantsRequestDto plantsRequestDto) {
      return plantRepository.findById(id)
              .map(existingPlant -> {
                 existingPlant.setName(plantsRequestDto.getName());
                 existingPlant.setCapacityPerDay(plantsRequestDto.getCapacityPerDay());
                 existingPlant.setCode(plantsRequestDto.getCode());
                 existingPlant.setLocation(plantsRequestDto.getLocation());
                 return plantRepository.save(existingPlant);
              })
              .map(plantsMapper::plantsToPlantsResponseDto)
              .orElseThrow(() -> new RuntimeException("Plant not found with id: " + id));
   }

   public PlantsResponseDto softDeletePlant(Long id) {
      return plantRepository.findById(id)
              .map(existingPlant -> {
                 existingPlant.setIsActive(false);
                 return plantRepository.save(existingPlant);
              })
              .map(plantsMapper::plantsToPlantsResponseDto)
              .orElseThrow(() -> new RuntimeException("Plant not found with id: " + id));
   }
}