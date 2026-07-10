package cmms.masterdata.controller;

import cmms.masterdata.dto.*;
import cmms.masterdata.entity.Plants;
import cmms.masterdata.entity.Suppliers;
import cmms.masterdata.service.CarModuleService;
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

    @PostMapping("/AddCarModule")
    @RequireRole({"ADMIN"})
    public CarModuleResponseDto addCustomer(@RequestBody CarModuleRequestDto carModuleRequestDtoRequestDto){
        return carModuleService.createCarModule(carModuleRequestDtoRequestDto);
    }

    @GetMapping("/GetAllCarModule")
    @RequireRole({"ADMIN"})
    public ResponseEntity<List<CarModuleResponseDto>> getAllCarModules() {
        return ResponseEntity.ok(carModuleService.getAllCarModule());
    }

    @GetMapping("/GetCarModuleById/{id}")
    @RequireRole({"ADMIN"})
    public ResponseEntity<CarModuleResponseDto> getCarModuleById(@PathVariable Long id) {
        return ResponseEntity.ok(carModuleService.getCarModuleById(id));
    }

    @PutMapping("/UpdateCarModule/{id}")
    @RequireRole({"ADMIN"})
    public ResponseEntity<CarModuleResponseDto> updateCarModule(
            @PathVariable Long id,
            @RequestBody CarModuleRequestDto carModuleRequestDto) {
        return ResponseEntity.ok(carModuleService.updateCarModule(id, carModuleRequestDto));
    }

    @DeleteMapping("/DeleteCarModule/{id}")
    @RequireRole({"ADMIN"})
    public ResponseEntity<String> deleteCarModule(@PathVariable Long id) {
        carModuleService.deleteCarModule(id);
        return ResponseEntity.ok("Car module deleted successfully with ID: " + id);
    }

    @GetMapping("/GetAllPlants")
    @RequireRole({"ADMIN", "PLANT_MANAGER"})
    public ResponseEntity<List<Plants>> getAllPlants() {
        return ResponseEntity.ok(plantsservice.getPlants());
    }

    @GetMapping("/GetPlantById/{id}")
    @RequireRole({"ADMIN", "PLANT_MANAGER"})
    public ResponseEntity<PlantsResponseDto> getPlantById(@PathVariable Long id) {
        return ResponseEntity.ok(plantsservice.getPlantById(id));
    }

    @PostMapping("/AddPlants")
    @RequireRole({"ADMIN"})
    public PlantsResponseDto addCustomer(@RequestBody PlantsRequestDto plantsRequestDto){
        return plantsservice.createPlants(plantsRequestDto);
    }

    @PutMapping("/UpdatePlants/{id}")
    @RequireRole({"ADMIN"})
    public ResponseEntity<PlantsResponseDto> updatePlant(
            @PathVariable Long id,
            @RequestBody PlantsRequestDto plantsRequestDto) {
        PlantsResponseDto updatedPlant = plantsservice.updatePlant(id, plantsRequestDto);
        return ResponseEntity.ok(updatedPlant);
    }

    @DeleteMapping("DeletePlants/{id}")
    @RequireRole({"ADMIN"})
    public ResponseEntity<PlantsResponseDto> softDeletePlant(@PathVariable Long id) {
        PlantsResponseDto deletedPlant = plantsservice.softDeletePlant(id);
        return ResponseEntity.ok(deletedPlant);
    }

    @GetMapping("/GetAllSuppliers")
    @RequireRole({"ADMIN", "PLANT_MANAGER"})
    public ResponseEntity<List<Suppliers>> getAllSuppliers() {
        return ResponseEntity.ok(supplierService.getAllSuppliers());
    }

    @PostMapping("/AddSuppliers")
    @RequireRole({"ADMIN"})
    public ResponseEntity<String> addSupplier(@Valid @RequestBody SupplierRequestDto supplierRequestDto) {
        supplierService.createSuppliers(supplierRequestDto);
        return new ResponseEntity<>("Successfully Supplier Added", HttpStatus.CREATED);
    }

    @GetMapping("/GetsupplierById/{id}")
    @RequireRole({"ADMIN","PLANT_MANAGER"})
    public ResponseEntity<Suppliers> getSupplierById(@PathVariable Long id) {
        return ResponseEntity.ok(supplierService.getBySuppliersId(id));
    }

    @PutMapping("/UpdateSuppliers/{id}")
    @RequireRole({"ADMIN"})
    public ResponseEntity<SupplierResponseDto> updateSupplier(
            @PathVariable Long id,
            @Valid @RequestBody SupplierRequestDto supplierRequestDto) {
        return ResponseEntity.ok(supplierService.updateSupplier(id, supplierRequestDto));
    }

    @DeleteMapping("/DeleteSuppliers/{id}")
    @RequireRole({"ADMIN"})
    public ResponseEntity<String> deleteSupplier(@PathVariable Long id) {
        supplierService.deleteSupplier(id);
        return ResponseEntity.ok("Supplier deleted successfully with ID: " + id);
    }
}