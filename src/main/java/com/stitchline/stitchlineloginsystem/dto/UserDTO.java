package com.stitchline.stitchlineloginsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO implements SuperDTO{
    private String userName;
    private String name;
    private String email;
    private int mobile;
    private String password;
    private String address;
    private String nic;
    private String empNo;
    private UserTypeDto userType;


}
