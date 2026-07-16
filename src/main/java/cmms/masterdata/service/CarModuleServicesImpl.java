package cmms.masterdata.service;

import cmms.masterdata.dto.CarModuleRequestDto;
import cmms.masterdata.dto.CarModuleResponseDto;
import cmms.masterdata.entity.CarModule;
import cmms.masterdata.repository.CarRepository;
import cmms.masterdata.util.CarModuleMapper;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CarModuleServicesImpl implements CarModuleService {

    private final CarRepository carRepository;
    private final CarModuleMapper carModuleMapper;

    @Override
    public List<CarModuleResponseDto> getAllCarModule() {
        List<CarModule> carModules = carRepository.findAll();
        return carModules.stream()
                .map(carModuleMapper::customerToCustomerResponseDto).toList();
    }

    @Override
    public CarModule addCar(CarModule carModule) {
        return carRepository.save(carModule);
    }

    @Override
    public CarModuleResponseDto createCarModule(CarModuleRequestDto carModuleRequestDto) {
        CarModule car = addCar(carModuleMapper.carModuleRequesttoCarModule(carModuleRequestDto));
        return carModuleMapper.customerToCustomerResponseDto(car);
    }

    @Override
    public CarModuleResponseDto getCarModuleById(Long id) {
        CarModule car = carRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Car module not found with id: " + id));
        return carModuleMapper.customerToCustomerResponseDto(car);
    }

    @Override
    @Transactional
    public CarModuleResponseDto updateCarModule(Long id, CarModuleRequestDto dto) {
        CarModule existingCar = carRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Car module not found with id: " + id));

        existingCar.setModelName(dto.getModelName());
        existingCar.setFuelType(dto.getFuelType());
        existingCar.setTransmission(dto.getTransmission());
        existingCar.setBasePrice(dto.getBasePrice());
        existingCar.setColorOptions(dto.getColorOptions());
        existingCar.setLaunchDate(dto.getLaunchDate());
        existingCar.setIsActive(dto.getIsActive());

        CarModule updatedCar = carRepository.save(existingCar);
        return carModuleMapper.customerToCustomerResponseDto(updatedCar);
    }
    @Override
    @Transactional
    public void deleteCarModule(Long id) {
        if (!carRepository.existsById(id)) {
            throw new EntityNotFoundException("Car module not found with id: " + id);
        }
        carRepository.deleteById(id);
    }
}