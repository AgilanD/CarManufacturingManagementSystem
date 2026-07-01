package cmms.masterdata.service;

import cmms.masterdata.dto.SupplierRequestDto;
import cmms.masterdata.dto.SupplierResponseDto;
import cmms.masterdata.entity.Suppliers;

import java.util.List;

public interface SuppilerService {

    public SupplierResponseDto createSuppliers (SupplierRequestDto suppliersRequestDto);

    public Suppliers saveAll(Suppliers suppliers);

    public Suppliers getBySuppliersId(Long id);

    public List<Suppliers> getAllSuppliers();

}
