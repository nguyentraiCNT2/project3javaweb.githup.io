package project3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project3.entity.ImportProductsEntity;
import project3.entity.LoveListEntity;

import java.util.List;
import java.util.Optional;

@Repository
public interface ImportProductsRepository extends JpaRepository<ImportProductsEntity,Long> {
    Optional<ImportProductsEntity> findByImportproductsid(Long importproductsid);
    void deleteByImportproductsid(Long importproductsid);
    ImportProductsEntity saveAndFlush(ImportProductsEntity importProductsEntity);
}
