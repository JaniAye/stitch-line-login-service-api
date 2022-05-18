package com.stitchline.stitchlineloginsystem.controller;

import com.stitchline.stitchlineloginsystem.dto.UserDTO;
import com.stitchline.stitchlineloginsystem.service.UserService;
import com.stitchline.stitchlineloginsystem.util.StandardResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;


    private final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

//
    @PostMapping(
            path = "/createUser",
            consumes = {MediaType.APPLICATION_JSON_VALUE}
    )
    public ResponseEntity addUser(@RequestBody UserDTO dto) {
        String id = userService.addUser(dto);
        return new ResponseEntity(
                new StandardResponse(201, id + " success added", dto),
                HttpStatus.CREATED);
    }


    @GetMapping(
            params = {"userName"})
    public ResponseEntity<StandardResponse> searchUser(
            @RequestParam(value = "userName") String userName

    ) {

        UserDTO userDTO = null;

        userDTO = userService.searchUser(userName);
        LOGGER.info("Get By userName");


        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200, "success", userDTO),
                HttpStatus.OK);
    }


}
