package project3.api.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import project3.api.output.Categoryoutput;
import project3.api.output.OrderOutput;
import project3.api.output.OrderRequestOUTPUT;
import project3.api.output.Orderdetailsoutput;
import project3.dto.*;
import project3.service.CustomersService;
import project3.service.OrderService;
import project3.service.OrderdetailsService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/order/api")
public class OrderController {
    @Autowired
    private OrderService orderService;
    @Autowired
    private OrderdetailsService orderdetailsService;
    @Autowired
    private CustomersService customersService;

    @GetMapping("/oder/order-id/list/{orderid}")
    public Orderdetailsoutput getByOrderid(@PathVariable Long orderid, @RequestParam("page") int page, @RequestParam("limit") int limit, Model model) {
        Orderdetailsoutput result = new Orderdetailsoutput();
        result.setPage(page);
        Pageable pageable = new PageRequest(page - 1, limit);
        result.setListResult(orderdetailsService.getByOrderid(orderid,pageable));
        result.setTotalPage((int) Math.ceil((double) (orderdetailsService.totalItem()) / limit));
        model.addAttribute("Orderdetailsoutput", result);
        return result;
    }

    @GetMapping("/oder/ordercancel/list/{ordercancel}")
    public OrderRequestOUTPUT getByOrdercancel(@PathVariable String ordercancel, @RequestParam("page") int page, @RequestParam("limit") int limit, Model model) {
        OrderRequestOUTPUT result = new OrderRequestOUTPUT();
        List<OrderRequestDTO> orderRequestDTO = new ArrayList<>();
        result.setPage(page);
        Pageable pageable = new PageRequest(page - 1, limit);
        List<OrderOTD> orderOTD = orderService.getByOrdercancel(ordercancel,pageable);
        for (OrderOTD item: orderOTD
        ) {
            OrderRequestDTO requestDTO = new OrderRequestDTO();
            List<OrderdetailsDTO> orderdetailsDTO = orderdetailsService.getByOrderid(item.getOrderid(),pageable);
            requestDTO.setOrder(item);
            requestDTO.setOrderDetailsList(orderdetailsDTO);
            orderRequestDTO.add(requestDTO);
        }

        result.setListResult(orderRequestDTO);
        result.setTotalPage((int) Math.ceil((double) (orderService.totalItem()) / limit));
        model.addAttribute("Orderdetailsoutput", result);
        return result;
    }
    @GetMapping("/admin/order/list")
    public OrderRequestOUTPUT getAll( @RequestParam("page") int page, @RequestParam("limit") int limit, Model model) {
        OrderRequestOUTPUT result = new OrderRequestOUTPUT();
        List<OrderRequestDTO> orderRequestDTO = new ArrayList<>();
        result.setPage(page);
        Pageable pageable = new PageRequest(page - 1, limit);
        List<OrderOTD> orderOTD = orderService.getAll(pageable);
            for (OrderOTD item: orderOTD
            ) {
                OrderRequestDTO requestDTO = new OrderRequestDTO();
                List<OrderdetailsDTO> orderdetailsDTO = orderdetailsService.getByOrderid(item.getOrderid(),pageable);
                requestDTO.setOrder(item);
                requestDTO.setOrderDetailsList(orderdetailsDTO);
                orderRequestDTO.add(requestDTO);
            }
        result.setListResult(orderRequestDTO);
        result.setTotalPage((int) Math.ceil((double) (orderService.totalItem()) / limit));
        model.addAttribute("Orderdetailsoutput", result);
        return result;
    }
    @GetMapping("/admin/order-by-id/{orderid}")
    public ResponseEntity<?> getByUserId(@PathVariable Long orderid) {
        try {
            OrderRequestDTO orderRequestDTO = orderService.getByOrderid(orderid);

            return new ResponseEntity<>(orderRequestDTO, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>((List<UserDTO>) null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/oder/orderstatus/list/{orderstatus}")
    public OrderRequestOUTPUT getByOrderstatus(@PathVariable String orderstatus, @RequestParam("page") int page, @RequestParam("limit") int limit, Model model) {
        OrderRequestOUTPUT result = new OrderRequestOUTPUT();
        List<OrderRequestDTO> orderRequestDTO = new ArrayList<>();
        result.setPage(page);
        Pageable pageable = new PageRequest(page - 1, limit);
        List<OrderOTD> orderOTD = orderService.getByOrderstatus(orderstatus,pageable);
        for (OrderOTD item: orderOTD
        ) {
            OrderRequestDTO requestDTO = new OrderRequestDTO();
            List<OrderdetailsDTO> orderdetailsDTO = orderdetailsService.getByOrderid(item.getOrderid(),pageable);
            requestDTO.setOrder(item);
            requestDTO.setOrderDetailsList(orderdetailsDTO);
            orderRequestDTO.add(requestDTO);
        }

        result.setListResult(orderRequestDTO);
        result.setTotalPage((int) Math.ceil((double) (orderService.totalItem()) / limit));
        model.addAttribute("Orderdetailsoutput", result);
        return result;
    }
    @GetMapping("/oder/orderpay/list/{orderpay}")
    public OrderRequestOUTPUT getByOrderpay(@PathVariable String orderpay, @RequestParam("page") int page, @RequestParam("limit") int limit, Model model) {
        OrderRequestOUTPUT result = new OrderRequestOUTPUT();
        List<OrderRequestDTO> orderRequestDTO = new ArrayList<>();
        result.setPage(page);
        Pageable pageable = new PageRequest(page - 1, limit);
        List<OrderOTD> orderOTD = orderService.getByOrderpay(orderpay,pageable);
        for (OrderOTD item: orderOTD
        ) {
            OrderRequestDTO requestDTO = new OrderRequestDTO();
            List<OrderdetailsDTO> orderdetailsDTO = orderdetailsService.getByOrderid(item.getOrderid(),pageable);
            requestDTO.setOrder(item);
            requestDTO.setOrderDetailsList(orderdetailsDTO);
            orderRequestDTO.add(requestDTO);
        }

        result.setListResult(orderRequestDTO);
        result.setTotalPage((int) Math.ceil((double) (orderService.totalItem()) / limit));
        model.addAttribute("Orderdetailsoutput", result);
        return result;
    }
    @PostMapping("/oder/create-order")
    public ResponseEntity<String> createUser(@RequestBody OrderdetailsDTO orderdetailsDTO) {
        try {
            orderdetailsService.createOrderdetails(orderdetailsDTO);
            return new ResponseEntity<>("more success ", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PostMapping("/oder/placeOrder")
    public ResponseEntity<String> createUser(@RequestBody OrderRequestDTO orderdetailsDTO) {
        try {
            OrderOTD orderDTO  = orderdetailsDTO.getOrder();
            List<OrderdetailsDTO> orderDetailsList = orderdetailsDTO.getOrderDetailsList();
            orderService.placeOrder(orderDTO,orderDetailsList);
            return new ResponseEntity<>("more success ", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PostMapping("/oder/updateorder/{orderid}")
    public ResponseEntity<String> updateUser(@PathVariable Long orderid,@RequestBody OrderRequestDTO orderdetailsDTO) {
        try {
            OrderOTD orderDTO  = orderdetailsDTO.getOrder();
            orderDTO.setOrderid(orderid);
            List<OrderdetailsDTO> orderDetailsList = orderdetailsDTO.getOrderDetailsList();
            orderService.approveOrders(orderDTO,orderDetailsList);
            return new ResponseEntity<>("more success ", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
