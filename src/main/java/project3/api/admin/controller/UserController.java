package project3.api.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import project3.FunctionalAccessory.RandomId;
import project3.FunctionalAccessory.TokenUtil;
import project3.api.output.UserOutput;
import project3.dto.UserDTO;
import project3.api.admin.service.UserService;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping("/user/api")
public class UserController {
    @Autowired
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping("/admin/user-list")
    public UserOutput getAll(@RequestParam("page") int page, @RequestParam("limit") int limit, Model model) {
        UserOutput result = new UserOutput();
        result.setPage(page);
        Pageable pageable = new PageRequest(page - 1, limit);
        result.setListResult(userService.getAll(pageable));
        result.setTotalPage((int) Math.ceil((double) (userService.totalItem()) / limit));
        model.addAttribute("userAccountOutput", result);
        return result;

    }

    @GetMapping("/admin/user-by-username/list/{username}")
    public UserOutput getByUsername(@PathVariable String username, @RequestParam("page") int page, @RequestParam("limit") int limit, Model model) {
        UserOutput result = new UserOutput();
        result.setPage(page);
        Pageable pageable = new PageRequest(page - 1, limit);
        result.setListResult(userService.getByUsername(username,pageable));
        result.setTotalPage((int) Math.ceil((double) (userService.totalItem()) / limit));
        model.addAttribute("userAccountOutput", result);
        return result;
    }
    @GetMapping("/admin/user-by-role-id/list/{roleid}")
    public UserOutput getByRoleid(@PathVariable Long roleid, @RequestParam("page") int page, @RequestParam("limit") int limit, Model model) {
        UserOutput result = new UserOutput();
        result.setPage(page);
        Pageable pageable = new PageRequest(page - 1, limit);
        result.setListResult(userService.getByRoleid(roleid,pageable));
        result.setTotalPage((int) Math.ceil((double) (userService.totalItem()) / limit));
        model.addAttribute("userAccountOutput", result);
        return result;
    }
    @GetMapping("/admin/user-by-id/{userId}")
    public ResponseEntity<?> getByUserId(@PathVariable String userid) {
        try {
            UserDTO userDTO = userService.getByUserid(userid);

            return new ResponseEntity<>(userDTO, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>((List<UserDTO>) null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PostMapping("/admin/create-user")
    public ResponseEntity<String> createUser(@RequestBody UserDTO userDTO) {
        try {
            String randomId = RandomId.generateRandomId(25);
            userDTO.setUserid(randomId);
            userDTO.setRoleid(1L);
            userService.createUser(userDTO);
            String taikhoan = userDTO.getUsername();
            String matkhau = userDTO.getPassword();// Thời gian hết hạn token, 1 giờ trong ví dụ này
            long expirationMillis = 3600000;
            String token = TokenUtil.generateToken(taikhoan,matkhau, expirationMillis);
            return new ResponseEntity<>("more success " + token, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/admin/update-user/{userid}")
    public ResponseEntity<String> updateUserAccount(@PathVariable String userid, @RequestBody UserDTO userDTO) {
        try {
            userDTO.setUserid(userid);
            userService.updateUser(userDTO);
            return new ResponseEntity<>(userDTO+"Cập nhật quyền người dùng thành công", HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    // xóa dữ liệu
    @Transactional
    @DeleteMapping("/admin/delete-user/{userid}")
    public ResponseEntity<String> deleteUserAccount(@PathVariable String userid) {
        try {
            userService.deleteByUserid(userid);
            return new ResponseEntity<>("Xóa Ảnh thành công", HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
