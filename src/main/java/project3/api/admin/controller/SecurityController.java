package project3.api.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project3.FunctionalAccessory.RandomId;
import project3.FunctionalAccessory.TokenUtil;
import project3.dto.UserDTO;
import project3.service.SecurityService;

import javax.servlet.http.Cookie;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/security")
public class SecurityController {
    @Autowired
    private final SecurityService securityService;

    public SecurityController(SecurityService securityService) {
        this.securityService = securityService;
    }

    @PostMapping("/admin/signin")
    public ResponseEntity<?> signinAdmin(@RequestParam String username, @RequestParam String password) {
        try {
            UserDTO userDTO = securityService.signinAdmin(username, password);
            Date date  = new Date();
            long expirationMillis = 3600000;
            String mainToken = TokenUtil.generateToken(userDTO.getUserid(), expirationMillis);
            Map<String, Object> response = new HashMap<>();
            Cookie cookie = new Cookie("token", mainToken);
            String role = "User";
            cookie.setHttpOnly(true);
            cookie.setMaxAge(3600000);
            cookie.setPath("/");
           response.put("token",mainToken);
            response.put("role",role);
            response.put("userid",userDTO.getUserid());
             return new ResponseEntity<>(response, HttpStatus.OK);

        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
    @PostMapping("/user/signin")
    public ResponseEntity<?> signinUser(@RequestParam String username, @RequestParam String password) {
        try {

            UserDTO userDTO = securityService.signinUser(username, password);
            Date date  = new Date();
            long expirationMillis = 3600000;
            String mainToken = TokenUtil.generateToken(userDTO.getUserid(), expirationMillis);
            Map<String, Object> response = new HashMap<>();
            Cookie cookie = new Cookie("token", mainToken);
            String role = "User";
            cookie.setHttpOnly(true);
            cookie.setMaxAge(3600000);
            cookie.setPath("/");
            response.put("token",mainToken);
            return new ResponseEntity<>(response, HttpStatus.OK);

        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/signup")
    public ResponseEntity<?> signup(@RequestBody UserDTO userDTO) {
        try {
            String randomId = RandomId.generateRandomId(30);
            userDTO.setUserid(randomId);
            userDTO.setRoleid(1L);
            userDTO.setStatus(true);
            securityService.signup(userDTO);
            Date date  = new Date();
            long expirationMillis = 3600000;
            String mainToken = TokenUtil.generateToken(userDTO.getUsername(), expirationMillis);
            Map<String, Object> response = new HashMap<>();
            Cookie cookie = new Cookie("token", mainToken);
            cookie.setHttpOnly(true);
            cookie.setMaxAge(3600000);
            cookie.setPath("/");
            response.put("token",mainToken);
            response.put("userid",userDTO.getUserid());
            return new ResponseEntity<>("Signup successful"+response, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/profile/user/{userid}")
    public ResponseEntity<?> profileUser(@PathVariable String userid) {
        try {
            UserDTO userDTO = securityService.profile(userid);
            return new ResponseEntity<>(userDTO, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/profile/admin/{userid}")
    public ResponseEntity<?> profileAdmin(@PathVariable String userid) {
        try {
            UserDTO userDTO = securityService.profile(userid);
            return new ResponseEntity<>(userDTO, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
}
