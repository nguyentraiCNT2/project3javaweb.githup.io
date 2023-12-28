package project3.api.admin.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import project3.Mapper.Opject.OrderMapper;
import project3.api.admin.repository.OrderRepository;
import project3.api.admin.repository.UserRepository;
import project3.api.admin.service.OrderService;
import project3.dto.OrderOTD;
import project3.entity.OrderEntity;
import project3.entity.ProductsEntity;
import project3.entity.ReviewEntity;
import project3.entity.UserEntity;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrderIMPL implements OrderService {
    @Autowired
    private final OrderRepository orderRepository;
    private ModelMapper modelMapper;
    private OrderMapper orderMapper;
    private UserRepository userRepository;

    public OrderIMPL(OrderRepository orderRepository, ModelMapper modelMapper, OrderMapper orderMapper, UserRepository userRepository) {
        this.orderRepository = orderRepository;
        this.modelMapper = modelMapper;
        this.orderMapper = orderMapper;
        this.userRepository = userRepository;
    }


    @Override
    public List<OrderOTD> getAll(Pageable pageable) {
        List<OrderOTD> results = new ArrayList<>();
        List<OrderEntity> orderEntities = orderRepository.findAll(pageable).getContent();
        for (OrderEntity item: orderEntities
        ) {
            OrderOTD DTO = orderMapper.maptoDTO(item);
            results.add(DTO);
        }
        return results;
    }

    @Override
    public int totalItem() {
        return (int)orderRepository.count();
    }

    @Override
    public OrderOTD findByOrderid(Long orderid) {
        try {
            OrderEntity order = orderRepository.findByOrderid(orderid)
                    .orElseThrow(() -> new EntityNotFoundException("Data not found with ID: " + orderid));
            return orderMapper.maptoDTO(order);
        } catch (EntityNotFoundException ex) {
            throw ex;
        } catch (Exception e) {
            throw new RuntimeException("An error occurred while fetching data by ID", e);
        }
    }

    @Override
    public List<OrderOTD> getByUserid(String userid, Pageable pageable) {
        List<OrderOTD> results = new ArrayList<>();
        List<OrderEntity> orderEntities = orderRepository.findByUserid(userid,pageable);
        for (OrderEntity item: orderEntities
        ) {
            OrderOTD DTO = orderMapper.maptoDTO(item);
            results.add(DTO);
        }
        return results;
    }

    @Override
    public void deleteByOrderid(Long orderid) {
        orderRepository.deleteByOrderid(orderid);
    }

    @Override
    public void createOrder(OrderOTD orderOTD) {
        if ( orderOTD != null) {
            OrderEntity order = orderMapper.maptoEntity(orderOTD);
            UserEntity user = userRepository.findByUserid(orderOTD.getUserid()).orElse(null);
            if (order != null) {
                order.setUserid(user);
                orderRepository.save(order);
            } else {
                throw new RuntimeException("Không lấy được dữ liệu của Entity");
            }
        }
    }

    @Override
    public void updateOrder(OrderOTD orderOTD) {
        OrderEntity existinOrder  = orderRepository.findByOrderid(orderOTD.getOrderid())
                .orElseThrow(() -> new RuntimeException("Khong tim thay du lieu User"));
        modelMapper.map(orderOTD, existinOrder);
        orderRepository.save(existinOrder);
    }
}
