package cmms.masterdata.service;

import cmms.masterdata.dto.CarModuleRequestDto;
import cmms.masterdata.dto.CarModuleResponseDto;
import cmms.masterdata.entity.CarModule;

import java.util.List;

public interface CarModuleService {

    public CarModule addCar (CarModule carModule);

    public CarModuleResponseDto createCarModule (CarModuleRequestDto carModuleRequestDto);

    public List<CarModule> getAllCarModule();

}
