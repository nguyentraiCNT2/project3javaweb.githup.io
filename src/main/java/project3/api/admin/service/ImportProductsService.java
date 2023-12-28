package project3.api.admin.service;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project3.dto.ImportProductsDTO;
import project3.dto.ShipDTO;
import project3.entity.ImportProductsEntity;

import java.util.List;
import java.util.Optional;


public interface ImportProductsService {
    List<ImportProductsDTO> getAll(Pageable pageable);
    int totalItem();
   ImportProductsDTO getByImportproductsid(Long importproductsid);
    void deleteByImportproductsid(Long importproductsid);
    void createImportPrroduct(ImportProductsDTO importProductsDTO);
    void updateImportPrroduct(ImportProductsDTO importProductsDTO);
}
