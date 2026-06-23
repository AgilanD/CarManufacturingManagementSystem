package cmms.MasterData.service;

import cmms.MasterData.repository.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CarModuleServicesImpl implements CarModuleService{

    private final CarRepository carRepository;



}
