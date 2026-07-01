package cmms.masterdata.controller;

import cmms.masterdata.dto.*;
import cmms.masterdata.entity.Plants;
import cmms.masterdata.entity.Suppliers;
import cmms.masterdata.service.CarModuleService;
import cmms.masterdata.entity.CarModule;
import cmms.masterdata.service.PlantsService;
import cmms.masterdata.service.SuppilerService;
import cmms.masterdata.usercontext.RequireRole;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/MasterData")
public class MasterDataController {

    private final CarModuleService carModuleService;

    private final PlantsService plantsservice;

    private final SuppilerService supplierService;

    @GetMapping("/Checking")
    public ResponseEntity<String> checkStatus() {
        return ResponseEntity.ok("Checking From the MasterData");
    }


    @PostMapping("/AddCustomer")
    public CarModuleResponseDto addCustomer(@RequestBody CarModuleRequestDto carModuleRequestDtoRequestDto){
        return carModuleService.createCarModule(carModuleRequestDtoRequestDto);
    }


    @GetMapping("/GetAllCarModule")
    public ResponseEntity<List<CarModule>> getAllCarModules() {
        return ResponseEntity.ok(carModuleService.getAllCarModule());
    }

    @GetMapping("/GetAllPlants")
    @RequireRole({"ADMIN", "PLANT_MANAGER"})
    public ResponseEntity<List<Plants>> getAllPlants() {
        return ResponseEntity.ok(plantsservice.getPlants());
    }

    @PostMapping("/AddPlants")
    public PlantsResponseDto addCustomer(@RequestBody PlantsRequestDto plantsRequestDto){
        return plantsservice.createPlants(plantsRequestDto);
    }

    @GetMapping("/GetAllSuppliers")
    @RequireRole({"ADMIN", "PLANT_MANAGER"})
    public ResponseEntity<List<Suppliers>> getAllSuppliers() {
        return ResponseEntity.ok(supplierService.getAllSuppliers());
    }

    @PostMapping("/AddSuppliers")
    public ResponseEntity<String> addSupplier(@Valid @RequestBody SupplierRequestDto supplierRequestDto) {
        supplierService.createSuppliers(supplierRequestDto);
        return new ResponseEntity<>("Successfully Supplier Added", HttpStatus.CREATED);
    }

    @GetMapping("/GetsupplierById/{id}")
    public ResponseEntity<Suppliers> getSupplierById(@PathVariable Long id) {
        return ResponseEntity.ok(supplierService.getBySuppliersId(id));
    }


}
