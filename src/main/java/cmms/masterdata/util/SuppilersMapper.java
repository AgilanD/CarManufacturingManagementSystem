package cmms.masterdata.util;

import cmms.masterdata.dto.SupplierRequestDto;
import cmms.masterdata.dto.SupplierResponseDto;
import cmms.masterdata.entity.Suppliers;
import org.springframework.stereotype.Component;

@Component
public class SuppilersMapper {

    public Suppliers createSupplier(SupplierRequestDto requestDto) {

        return Suppliers.builder()
                .supplierName(requestDto.getSupplierName())
                .supplierCode(requestDto.getSupplierCode())
                .contactEmail(requestDto.getContactEmail())
                .rating(requestDto.getRating())
                .gstNumber(requestDto.getGstNumber())
                .isActive(requestDto.getIsActive())
                .build();

    }

    public  SupplierResponseDto mapToResponseDto(Suppliers supplier) {

        return SupplierResponseDto.builder()
                .id(supplier.getId())
                .supplierName(supplier.getSupplierName())
                .supplierCode(supplier.getSupplierCode())
                .contactEmail(supplier.getContactEmail())
                .rating(supplier.getRating())
                .gstNumber(supplier.getGstNumber())
                .isActive(supplier.getIsActive())
                .build();

    }



}
