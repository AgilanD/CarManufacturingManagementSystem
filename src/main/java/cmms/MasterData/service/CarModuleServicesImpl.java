package cmms.MasterData.service;

import cmms.MasterData.Dto.CarModuleRequestDto;
import cmms.MasterData.Dto.CarModuleResponseDto;
import cmms.MasterData.entity.CarModule;
import cmms.MasterData.repository.CarRepository;
import cmms.MasterData.util.CarModuleMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CarModuleServicesImpl implements CarModuleService{

    private final CarRepository carRepository;

    private final CarModuleMapper carModuleMapper;

    public List<CarModule> GetAllCarModule(){
        return carRepository.findAll();
    }

    public CarModule AddCar (CarModule carModule){
        return carRepository.save(carModule);
    }


    public CarModuleResponseDto CreateCarModule (CarModuleRequestDto carModuleRequestDto){


        CarModule car = AddCar(carModuleMapper.CarModuleRequesttoCarModule(carModuleRequestDto));

        return carModuleMapper.CustomerToCustomerResponseDto(car);

    }




}
