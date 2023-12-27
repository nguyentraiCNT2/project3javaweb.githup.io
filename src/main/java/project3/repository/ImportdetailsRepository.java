package project3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project3.entity.ImportdetailsEntity;
import project3.entity.LoveListEntity;

import java.util.List;
import java.util.Optional;

@Repository
public interface ImportdetailsRepository extends JpaRepository<ImportdetailsEntity,Long> {
    Optional<ImportdetailsEntity> findByImportdetailsid(Long importdetailsid);
    List<ImportdetailsEntity> findByProductsid(Long productsid);
    List<ImportdetailsEntity> findByImportProductsid(Long importProductsid);
    void deleteByImportdetailsid(Long importdetailsid);
    ImportdetailsEntity saveAndFlush(ImportdetailsEntity importdetailsEntity);
}
