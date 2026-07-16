package cmms.masterdata.service;

import cmms.masterdata.dto.CarModuleRequestDto;
import cmms.masterdata.dto.CarModuleResponseDto;
import cmms.masterdata.entity.CarModule;

import java.util.List;

public interface CarModuleService {

    CarModule addCar (CarModule carModule);

    CarModuleResponseDto createCarModule (CarModuleRequestDto carModuleRequestDto);

    List<CarModuleResponseDto> getAllCarModule();

    CarModuleResponseDto getCarModuleById(Long id);

    CarModuleResponseDto updateCarModule(Long id, CarModuleRequestDto carModuleRequestDto);

    void deleteCarModule(Long id);
}

