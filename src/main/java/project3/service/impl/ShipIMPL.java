package project3.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import project3.service.ShipService;
import project3.Mapper.Opject.Shipmapper;
import project3.repository.ShipRepository;
import project3.dto.ShipDTO;
import project3.entity.ShipEntity;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service
public class ShipIMPL implements ShipService {
    @Autowired
    private final ShipRepository shipRepository;
    private ModelMapper modelMapper;
    private Shipmapper shipmapper;

    public ShipIMPL(ShipRepository shipRepository, ModelMapper modelMapper, Shipmapper shipmapper) {
        this.shipRepository = shipRepository;
        this.modelMapper = modelMapper;
        this.shipmapper = shipmapper;
    }


    @Override
    public List<ShipDTO> getAll(Pageable pageable) {
        List<ShipDTO> results = new ArrayList<>();
        List<ShipEntity> shipEntities = shipRepository.findAll(pageable).getContent();
        for (ShipEntity item: shipEntities
        ) {
            ShipDTO DTO = shipmapper.maptoDTO(item);
            results.add(DTO);
        }
        return results;
    }

    @Override
    public int totalItem() {
        return (int) shipRepository.count();
    }

    @Override
    public ShipDTO getByShipid(Long shipid) {
        try {
            ShipEntity ship = shipRepository.findByShipid(shipid)
                    .orElseThrow(() -> new EntityNotFoundException("Data not found with ID: " + shipid));
            return shipmapper.maptoDTO(ship);
        } catch (EntityNotFoundException ex) {
            throw ex;
        } catch (Exception e) {
            throw new RuntimeException("An error occurred while fetching data by ID", e);
        }
    }

    @Override
    public List<ShipDTO> getByShipname(String shipname, Pageable pageable) {
        List<ShipDTO> results = new ArrayList<>();
            List<ShipEntity> shipEntities = shipRepository.findByShipname(shipname,pageable);
        for (ShipEntity item: shipEntities
        ) {
            ShipDTO DTO = shipmapper.maptoDTO(item);
            results.add(DTO);
        }
        return results;
    }

    @Override
    public void deleteByShipid(Long shipid) {
        shipRepository.deleteByShipid(shipid);
    }

    @Override
    public void createShip(ShipDTO shipDTO) {
        if ( shipDTO != null) {
            ShipEntity ship = shipmapper.maptoEntity(shipDTO);
            if (ship != null) {
                shipRepository.save(ship);
            } else {
                throw new RuntimeException("Không lấy được dữ liệu của Entity");
            }
        }
    }

    @Override
    public void updateShip(ShipDTO shipDTO) {
        ShipEntity existingShip  = shipRepository.findByShipid(shipDTO.getShipid())
                .orElseThrow(() -> new RuntimeException("Khong tim thay du lieu User"));
        modelMapper.map(shipDTO, existingShip);
        shipRepository.save(existingShip);
    }
}
