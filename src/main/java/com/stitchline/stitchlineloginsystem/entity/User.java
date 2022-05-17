package com.stitchline.stitchlineloginsystem.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;


@Document(collection="user")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements SuperEntity {

    @Id
    private String userName;
    @NotNull(message = "Name is mandatory")
    private String name;

    @NotNull(message = "Email is mandatory")
    private String email;

    @NotNull(message = "Mobile is mandatory")
    private int mobile;

    @NotNull(message = "Password is mandatory")
    private String password;

    @NotNull(message = "Address is mandatory")
    private String address;

    @NotNull(message = "NIC is mandatory")
    private String nic;

    @NotNull(message = "Employee No is mandatory")
    private String empNo;
    @Enumerated(EnumType.STRING)
    @NotNull(message = "User Type is mandatory")
    private UserType userType;

}
