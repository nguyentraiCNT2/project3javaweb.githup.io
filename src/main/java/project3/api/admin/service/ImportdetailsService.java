package project3.api.admin.service;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project3.dto.ImportdetailsDTO;
import project3.dto.ShipDTO;
import project3.entity.ImportdetailsEntity;

import java.util.List;
import java.util.Optional;

@Repository
public interface ImportdetailsService  {
    List<ImportdetailsDTO> getAll(Pageable pageable);
    int totalItem();
    ImportdetailsDTO getByImportdetailsid(Long importdetailsid);
    List<ImportdetailsDTO> getByProductsid(Long productsid, Pageable pageable);
    List<ImportdetailsDTO> getByImportProductsid(Long importProductsid, Pageable pageable);
    void deleteByImportdetailsid(Long importdetailsid);
    void createImportdetails(ImportdetailsDTO importdetailsDTO);
    void updateImportdetails(ImportdetailsDTO importdetailsDTO);
}
