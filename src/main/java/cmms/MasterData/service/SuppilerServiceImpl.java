package cmms.MasterData.service;


import cmms.MasterData.Dto.PlantsRequestDto;
import cmms.MasterData.Dto.PlantsResponseDto;
import cmms.MasterData.Dto.SupplierRequestDto;
import cmms.MasterData.Dto.SupplierResponseDto;
import cmms.MasterData.entity.Plants;
import cmms.MasterData.entity.Suppliers;
import cmms.MasterData.repository.SuppliersRepository;
import cmms.MasterData.util.PlantsMapper;
import cmms.MasterData.util.SuppilersMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Supplier;

@Service
@RequiredArgsConstructor
public class SuppilerServiceImpl implements SuppilerService{


   private final SuppliersRepository suppliersRepository;
   private final SuppilersMapper suppliersMapper;


   public List<Suppliers> GetAllSuppliers(){
       return suppliersRepository.findAll();
   }

   public Suppliers GetBySuppliersId(Long id){
       return suppliersRepository.findById(id).orElse(null);
   }

   public Suppliers SaveAll(Suppliers suppliers){
       return suppliersRepository.save(suppliers);
   }



    public SupplierResponseDto CreateSuppliers (SupplierRequestDto suppliersRequestDto){

        Suppliers supply = SaveAll(suppliersMapper.createSupplier(suppliersRequestDto));

        return suppliersMapper.mapToResponseDto(supply);

    }


}
