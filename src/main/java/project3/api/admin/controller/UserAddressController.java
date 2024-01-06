package project3.api.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import project3.service.UserAddressService;
import project3.api.output.UserAddressOutPut;
import project3.dto.UserAddressDTO;
import project3.dto.UserDTO;
import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping("/admin/user-address/api")
public class UserAddressController {
    @Autowired
    private final UserAddressService userAddressService;
    public UserAddressController(UserAddressService userAddressService) {
        this.userAddressService = userAddressService;
    }
    @GetMapping("/admin/user-address-list")
    public UserAddressOutPut getAll(@RequestParam("page") int page, @RequestParam("limit") int limit, Model model) {
        UserAddressOutPut result = new UserAddressOutPut();
        result.setPage(page);
        Pageable pageable = new PageRequest(page - 1, limit);
        result.setListResult(userAddressService.getAll(pageable));
        result.setTotalPage((int) Math.ceil((double) (userAddressService.totalItem()) / limit));
        model.addAttribute("UserAddressOutPut", result);
        return result;
    }
    @GetMapping("/admin/user-address-by-id/{useraddressid}")
    public ResponseEntity<?> getByUseraddressid(@PathVariable Long useraddressid) {
        try {
            UserAddressDTO userAddressDTO = userAddressService.getByUseraddressid(useraddressid);

            return new ResponseEntity<>(userAddressDTO, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>((List<UserDTO>) null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/admin/user-address-by-addressuser-list/{useraddress}")
    public UserAddressOutPut getByUseraddress(@PathVariable String useraddress , @RequestParam("page") int page, @RequestParam("limit") int limit, Model model) {
        UserAddressOutPut result = new UserAddressOutPut();
        result.setPage(page);
        Pageable pageable = new PageRequest(page - 1, limit);
        result.setListResult(userAddressService.getByUseraddress(useraddress,pageable));
        result.setTotalPage((int) Math.ceil((double) (userAddressService.totalItem()) / limit));
        model.addAttribute("UserAddressOutPut", result);
        return result;
    }
    @PostMapping("/admin/create-user-address")
    public ResponseEntity<String> createUserAddress(@RequestBody UserAddressDTO userAddressDTO) {
        try {
            userAddressService.createUserAddress(userAddressDTO);
            return new ResponseEntity<>("create success " , HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PutMapping("/admin/update-user-address/{useraddressid}")
    public ResponseEntity<String> updateUserAccount(@PathVariable Long useraddressid, @RequestBody UserAddressDTO userAddressDTO) {
        try {
            userAddressDTO.setAddressid(useraddressid);
            userAddressService.updateUserAdress(userAddressDTO);
            return new ResponseEntity<>(userAddressDTO+"Cập nhật quyền người dùng thành công", HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    // xóa dữ liệu
    @Transactional
    @DeleteMapping("/admin/delete-user-address/{useraddressid}")
    public ResponseEntity<String> deleteUserAccount(@PathVariable Long useraddressid) {
        try {
            userAddressService.deleteByUseraddressid(useraddressid);
            return new ResponseEntity<>("Xóa Ảnh thành công", HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
