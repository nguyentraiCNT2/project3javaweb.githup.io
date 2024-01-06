package project3.service;

import project3.dto.UserDTO;

public interface SecurityService {
    UserDTO signinAdmin(String username, String password);
    UserDTO signinUser(String username, String password);
    void signup(UserDTO userDTO );
    UserDTO profile(String userid);

}
