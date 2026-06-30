package cmms.MasterData.controller;


import cmms.MasterData.Dto.*;
import cmms.MasterData.entity.Plants;
import cmms.MasterData.entity.Suppliers;
import cmms.MasterData.service.CarModuleService;
import cmms.MasterData.entity.CarModule;
import cmms.MasterData.service.PlantsService;
import cmms.MasterData.service.SuppilerService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.function.Supplier;

@RestController
@RequiredArgsConstructor
@RequestMapping("/MasterData")
public class MasterDataController {

    private final CarModuleService carModuleService;

    private final PlantsService plantsservice;

    private final SuppilerService supplierService;

    @GetMapping("/Checking")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public String Checkings(){
        return "Checking From the MasterData";
    }


    @PostMapping("/AddCustomer")
    @PreAuthorize("hasRole('ADMIN')")
    public CarModuleResponseDto addCustomer(@RequestBody CarModuleRequestDto carModuleRequestDtoRequestDto){
        return carModuleService.CreateCarModule(carModuleRequestDtoRequestDto);
    }


    @GetMapping("/GetAllCarModule")
    @PreAuthorize("hasRole('ADMIN')")
    public List<CarModule> GetAllCarModule (){
        return carModuleService.GetAllCarModule();
    }


    @GetMapping("/GetAllPlants")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public List<Plants> GetAllPlants(){
        return plantsservice.GetPlants();
    }

    @PostMapping("/AddPlants")
    @PreAuthorize("hasAnyRole('ADMIN','PLANT_MANAGER')")
    public PlantsResponseDto addCustomer(@RequestBody PlantsRequestDto plantsRequestDto){
        return plantsservice.CreatePlants(plantsRequestDto);
    }

    @GetMapping("/GetAllSuppliers")
    @PreAuthorize("hasRole('ADMIN')")
    public List<Suppliers> GetAllSuppliers(){
        return supplierService.GetAllSuppliers();
    }

    @PostMapping("/AddSuppliers")
    @PreAuthorize("hasRole('ADMIN')")
    public String AddSuppliers(@RequestBody SupplierRequestDto suppilerRequestDto){
        supplierService.CreateSuppliers(suppilerRequestDto);
        return "SuccessFully SuppliersAdded";
    }

    @GetMapping("/GetById/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public Suppliers GetSupplierById(@RequestParam Long id){
        return supplierService.GetBySuppliersId(id);
    }




}
