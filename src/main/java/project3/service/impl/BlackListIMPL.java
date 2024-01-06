package project3.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import project3.service.BlackListService;
import project3.Mapper.Opject.BlackListMapper;
import project3.repository.BlackListRepository;
import project3.repository.UserRepository;
import project3.dto.BlackListDTO;
import project3.entity.BlackListEntity;
import project3.entity.UserEntity;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service
public class BlackListIMPL implements BlackListService {
    @Autowired
    private final BlackListRepository blackListRepository;
    private UserRepository userRepository;
    private ModelMapper modelMapper;
    private BlackListMapper blackListMapper;
    public BlackListIMPL(BlackListRepository blackListRepository, UserRepository userRepository, ModelMapper modelMapper, BlackListMapper blackListMapper) {
        this.blackListRepository = blackListRepository;
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.blackListMapper = blackListMapper;
    }

    @Override
    public List<BlackListDTO> getAll(Pageable pageable) {
        List<BlackListDTO> results = new ArrayList<>();
        List<BlackListEntity> blackListEntities = blackListRepository.findAll(pageable).getContent();
        for (BlackListEntity item: blackListEntities
        ) {
            BlackListDTO DTO = blackListMapper.maptoDTO(item);
            results.add(DTO);
        }
        return results;
    }

    @Override
    public int totalItem() {
        return (int)blackListRepository.count();
    }

    @Override
    public BlackListDTO getByBalcklistid(Long balcklistid) {
        try {
            BlackListEntity blackList = blackListRepository.findByBalcklistid(balcklistid)
                    .orElseThrow(() -> new EntityNotFoundException("Data not found with ID: " + balcklistid));
            return blackListMapper.maptoDTO(blackList);
        } catch (EntityNotFoundException ex) {
            throw ex;
        } catch (Exception e) {
            throw new RuntimeException("An error occurred while fetching data by ID", e);
        }
    }

    @Override
    public List<BlackListDTO> getByBlacklistname(String blacklistname, Pageable pageable) {
        List<BlackListDTO> results = new ArrayList<>();
        List<BlackListEntity> blackListEntities = blackListRepository.findByBlacklistname(blacklistname,pageable);
        for (BlackListEntity item: blackListEntities
        ) {
            BlackListDTO DTO = blackListMapper.maptoDTO(item);
            results.add(DTO);
        }
        return results;
    }

    @Override
    public List<BlackListDTO> getByUserid(String userid, Pageable pageable) {
        List<BlackListDTO> results = new ArrayList<>();
        List<BlackListEntity> blackListEntities = blackListRepository.findByUserid(userid,pageable);
        for (BlackListEntity item: blackListEntities
        ) {
            BlackListDTO DTO = blackListMapper.maptoDTO(item);
            results.add(DTO);
        }
        return results;
    }

    @Override
    public void deleteByBalcklistid(Long balcklistid) {
        blackListRepository.deleteByBalcklistid(balcklistid);
    }

    @Override
    public void createBalcklist(BlackListDTO blackListDTO) {
        if ( blackListDTO != null) {
            BlackListEntity blackList = blackListMapper.maptoEntity(blackListDTO);
            UserEntity user = userRepository.findByUserid(blackListDTO.getUserid()).orElse(null);

            if (blackList != null) {
                blackList.setUserid(user);
                blackListRepository.save(blackList);
            } else {
                throw new RuntimeException("Không lấy được dữ liệu của Entity");
            }
        }
    }

    @Override
    public void updateBalcklist(BlackListDTO blackListDTO) {
        BlackListEntity existingBlackLists = blackListRepository.findByBalcklistid(blackListDTO.getBalcklistid())
                .orElseThrow(() -> new RuntimeException("Khong tim thay du lieu User"));
        modelMapper.map(blackListDTO, existingBlackLists);
        blackListRepository.save(existingBlackLists);
    }
}
