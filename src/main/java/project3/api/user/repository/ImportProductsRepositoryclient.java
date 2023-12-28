package project3.api.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project3.entity.ImportProductsEntity;

import java.util.Optional;

@Repository
public interface ImportProductsRepositoryclient extends JpaRepository<ImportProductsEntity,Long> {
    Optional<ImportProductsEntity> findByImportproductsid(Long importproductsid);
    void deleteByImportproductsid(Long importproductsid);
    ImportProductsEntity saveAndFlush(ImportProductsEntity importProductsEntity);
}
