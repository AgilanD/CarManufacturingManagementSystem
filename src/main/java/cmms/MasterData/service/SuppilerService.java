package cmms.MasterData.service;

import cmms.MasterData.Dto.SupplierRequestDto;
import cmms.MasterData.Dto.SupplierResponseDto;
import cmms.MasterData.entity.Suppliers;

import java.util.List;

public interface SuppilerService {

    public SupplierResponseDto CreateSuppliers (SupplierRequestDto suppliersRequestDto);

    public Suppliers SaveAll(Suppliers suppliers);

    public Suppliers GetBySuppliersId(Long id);

    public List<Suppliers> GetAllSuppliers();

}
