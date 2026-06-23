package cmms.MasterData.util;

import cmms.MasterData.Dto.SupplierRequestDto;
import cmms.MasterData.Dto.SupplierResponseDto;
import cmms.MasterData.entity.Suppliers;

public class SuppilersMapper {

    public  static Suppliers createSupplier(SupplierRequestDto requestDto) {

        return Suppliers.builder()
                .supplierName(requestDto.getSupplierName())
                .supplierCode(requestDto.getSupplierCode())
                .contactEmail(requestDto.getContactEmail())
                .rating(requestDto.getRating())
                .gstNumber(requestDto.getGstNumber())
                .isActive(requestDto.getIsActive())
                .build();

    }

    public  static SupplierResponseDto mapToResponseDto(Suppliers supplier) {

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
