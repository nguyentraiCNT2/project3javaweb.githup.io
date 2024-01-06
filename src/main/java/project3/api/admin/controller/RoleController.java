package project3.api.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import project3.service.RoleSerVice;
import project3.api.output.RoleOutPut;
import project3.dto.RoleDTO;

import javax.transaction.Transactional;

@RestController
@RequestMapping("/admin/role-manager/api")
public class RoleController {
    @Autowired
   private final RoleSerVice roleSerVice;

    public RoleController(RoleSerVice roleSerVice) {
        this.roleSerVice = roleSerVice;
    }

    @GetMapping("/admin/role-list")
    public RoleOutPut getAll(@RequestParam("page") int page, @RequestParam("limit") int limit, Model model) {
        RoleOutPut result = new RoleOutPut();
        result.setPage(page);
        Pageable pageable = new PageRequest(page - 1, limit);
        result.setListResult(roleSerVice.getAll(pageable));
        result.setTotalPage((int) Math.ceil((double) (roleSerVice.totalItem()) / limit));
        model.addAttribute("userAccountOutput", result);
        return result;
    }
    @PostMapping("/admin/create-role")
    public ResponseEntity<String> createUser(@RequestBody RoleDTO roleDTO) {
        try {
            roleSerVice.createRole(roleDTO);
            return new ResponseEntity<>("more success " + roleDTO, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PutMapping("/admin/update-role/{roleid}")
    public ResponseEntity<String> updateRole(@PathVariable Long roleid, @RequestBody RoleDTO roleDTO) {
        try {
            roleDTO.setRoleid(roleid);
            roleSerVice.updateRole(roleDTO);
            return new ResponseEntity<>(roleDTO+"Cập nhật quyền người dùng thành công", HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @Transactional
    @DeleteMapping("/admin/delete-role/{roleid}")
    public ResponseEntity<String> deleteUserAccount(@PathVariable Long roleid) {
        try {
            roleSerVice.deleteByRoleid(roleid);
            return new ResponseEntity<>("Xóa Ảnh thành công", HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
