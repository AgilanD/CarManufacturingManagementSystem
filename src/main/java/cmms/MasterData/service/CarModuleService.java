package cmms.MasterData.service;

import cmms.MasterData.Dto.CarModuleRequestDto;
import cmms.MasterData.Dto.CarModuleResponseDto;
import cmms.MasterData.entity.CarModule;

import java.util.List;

public interface CarModuleService {

    public CarModule AddCar (CarModule carModule);

    public CarModuleResponseDto CreateCarModule (CarModuleRequestDto carModuleRequestDto);

    public List<CarModule> GetAllCarModule();

}
