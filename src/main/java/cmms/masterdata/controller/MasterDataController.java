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
    public CarModuleResponseDto addCustomer(@RequestBody CarModuleRequestDto carModuleRequestDtoRequestDto){
        return carModuleService.createCarModule(carModuleRequestDtoRequestDto);
    }

    @GetMapping("/GetAllCarModule")
    public ResponseEntity<List<CarModuleResponseDto>> getAllCarModules() {
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

    @PutMapping("/UpdatePlants/{id}")
    public ResponseEntity<PlantsResponseDto> updatePlant(
            @PathVariable Long id,
            @RequestBody PlantsRequestDto plantsRequestDto) {

        PlantsResponseDto updatedPlant = plantsservice.updatePlant(id, plantsRequestDto);
        return ResponseEntity.ok(updatedPlant);
    }

    @DeleteMapping("DeletePlants/{id}")
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
    public ResponseEntity<String> addSupplier(@Valid @RequestBody SupplierRequestDto supplierRequestDto) {
        supplierService.createSuppliers(supplierRequestDto);
        return new ResponseEntity<>("Successfully Supplier Added", HttpStatus.CREATED);
    }

    @GetMapping("/GetsupplierById/{id}")
    public ResponseEntity<Suppliers> getSupplierById(@PathVariable Long id) {
        return ResponseEntity.ok(supplierService.getBySuppliersId(id));
    }


}
