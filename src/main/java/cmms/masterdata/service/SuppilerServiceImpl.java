package cmms.masterdata.service;


import cmms.masterdata.dto.SupplierRequestDto;
import cmms.masterdata.dto.SupplierResponseDto;
import cmms.masterdata.entity.Suppliers;
import cmms.masterdata.repository.SuppliersRepository;
import cmms.masterdata.util.SuppilersMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SuppilerServiceImpl implements SuppilerService{


   private final SuppliersRepository suppliersRepository;
   private final SuppilersMapper suppliersMapper;


   public List<Suppliers> getAllSuppliers(){
       return suppliersRepository.findAll();
   }

   public Suppliers getBySuppliersId(Long id){
       return suppliersRepository.findById(id).orElse(null);
   }

   public Suppliers saveAll(Suppliers suppliers){
       return suppliersRepository.save(suppliers);
   }



    public SupplierResponseDto createSuppliers (SupplierRequestDto suppliersRequestDto){

        Suppliers supply = saveAll(suppliersMapper.createSupplier(suppliersRequestDto));

        return suppliersMapper.mapToResponseDto(supply);

    }


}
