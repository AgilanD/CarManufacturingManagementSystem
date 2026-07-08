package cmms.masterdata.service;

import cmms.masterdata.dto.CarModuleRequestDto;
import cmms.masterdata.dto.CarModuleResponseDto;
import cmms.masterdata.entity.CarModule;
import cmms.masterdata.repository.CarRepository;
import cmms.masterdata.util.CarModuleMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CarModuleServicesImpl implements CarModuleService{

    private final CarRepository carRepository;

    private final CarModuleMapper carModuleMapper;

    public List<CarModuleResponseDto> getAllCarModule() {
        List<CarModule> carModules = carRepository.findAll();
        return carModules.stream()
                .map(carModuleMapper::customerToCustomerResponseDto).toList();
    }

    public CarModule addCar (CarModule carModule){
        return carRepository.save(carModule);
    }


    public CarModuleResponseDto createCarModule (CarModuleRequestDto carModuleRequestDto){


        CarModule car = addCar(carModuleMapper.carModuleRequesttoCarModule(carModuleRequestDto));

        return carModuleMapper.customerToCustomerResponseDto(car);

    }




}
