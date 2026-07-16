package cmms.masterdata.service;

import cmms.masterdata.dto.SupplierRequestDto;
import cmms.masterdata.dto.SupplierResponseDto;
import cmms.masterdata.entity.Suppliers;
import cmms.masterdata.repository.SuppliersRepository;
import cmms.masterdata.util.SuppilersMapper;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SuppilerServiceImpl implements SuppilerService {

    private final SuppliersRepository suppliersRepository;
    private final SuppilersMapper suppliersMapper;

    @Override
    public List<Suppliers> getAllSuppliers(){
        return suppliersRepository.findAll();
    }

    @Override
    public Suppliers getBySuppliersId(Long id){
        return suppliersRepository.findById(id).orElse(null);
    }

    @Override
    public Suppliers saveAll(Suppliers suppliers){
        return suppliersRepository.save(suppliers);
    }

    @Override
    public SupplierResponseDto createSuppliers(SupplierRequestDto suppliersRequestDto){
        Suppliers supply = saveAll(suppliersMapper.createSupplier(suppliersRequestDto));
        return suppliersMapper.mapToResponseDto(supply);
    }

    @Override
    @Transactional
    public SupplierResponseDto updateSupplier(Long id, SupplierRequestDto dto) {
        Suppliers existingSupplier = suppliersRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Supplier not found with id: " + id));

        existingSupplier.setSupplierName(dto.getSupplierName());
        existingSupplier.setSupplierCode(dto.getSupplierCode());
        existingSupplier.setContactEmail(dto.getContactEmail());
        existingSupplier.setRating(dto.getRating());
        existingSupplier.setGstin(dto.getGstNumber());
        existingSupplier.setGstNumber(dto.getGstNumber());
        existingSupplier.setIsActive(dto.getIsActive());

        Suppliers updatedSupplier = suppliersRepository.save(existingSupplier);
        return suppliersMapper.mapToResponseDto(updatedSupplier);
    }

    @Override
    @Transactional
    public void deleteSupplier(Long id) {
        if (!suppliersRepository.existsById(id)) {
            throw new EntityNotFoundException("Supplier not found with id: " + id);
        }
        suppliersRepository.deleteById(id);
    }
}