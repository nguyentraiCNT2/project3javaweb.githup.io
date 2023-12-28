package project3.api.admin.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project3.entity.ShipEntity;

import java.util.List;
import java.util.Optional;

@Repository
public interface ShipRepository extends JpaRepository<ShipEntity, Long> {
    Optional<ShipEntity> findByShipid(Long shipid);
    List<ShipEntity> findByShipname(String shipname, Pageable pageable);
    void deleteByShipid(Long shipid);
    ShipEntity saveAndFlush(ShipEntity shipEntity);
}
