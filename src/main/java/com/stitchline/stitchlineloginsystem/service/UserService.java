package com.stitchline.stitchlineloginsystem.service;


import com.stitchline.stitchlineloginsystem.dto.UserDTO;


public interface UserService {
    String addUser(UserDTO dto);
    UserDTO searchUser(String userName, String password);

}
