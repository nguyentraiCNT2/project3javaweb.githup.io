package project3.service;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import project3.dto.ImportdetailsDTO;

import java.util.List;

@Repository
public interface ImportdetailsService  {
    List<ImportdetailsDTO> getAll(Pageable pageable);
    int totalItem();
    ImportdetailsDTO getByImportdetailsid(Long importdetailsid);
    List<ImportdetailsDTO> getByProductsid(Long productsid, Pageable pageable);
    void deleteByImportdetailsid(Long importdetailsid);
    void createImportdetails(ImportdetailsDTO importdetailsDTO);
    void updateImportdetails(ImportdetailsDTO importdetailsDTO);
}
