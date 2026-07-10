package cmms.masterdata.service;

import cmms.masterdata.dto.SupplierRequestDto;
import cmms.masterdata.dto.SupplierResponseDto;
import cmms.masterdata.entity.Suppliers;

import java.util.List;

public interface SuppilerService {

    SupplierResponseDto createSuppliers(SupplierRequestDto suppliersRequestDto);

    Suppliers saveAll(Suppliers suppliers);

    Suppliers getBySuppliersId(Long id);

    List<Suppliers> getAllSuppliers();

    SupplierResponseDto updateSupplier(Long id, SupplierRequestDto supplierRequestDto);

    void deleteSupplier(Long id);
}