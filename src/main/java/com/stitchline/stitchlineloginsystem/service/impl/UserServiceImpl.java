package com.stitchline.stitchlineloginsystem.service.impl;

import com.stitchline.stitchlineloginsystem.dto.UserDTO;
import com.stitchline.stitchlineloginsystem.exception.EntryDuplicateException;
import com.stitchline.stitchlineloginsystem.exception.NotFoundException;
import com.stitchline.stitchlineloginsystem.repo.UserRepo;
import com.stitchline.stitchlineloginsystem.service.UserService;
import com.stitchline.stitchlineloginsystem.util.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepo repo;

    @Autowired
    private UserMapper mapper;


    @Override
    public String addUser(UserDTO dto) {
        if (!repo.existsById(dto.getUserName())) {
            return repo.save(mapper.toUser(dto)).getUserName();
        } else {
            throw new EntryDuplicateException("User is already exists");

        }
    }

    @Override
    public UserDTO searchUser(String userName) {

        UserDTO userDTO = mapper.toUserDTO(repo.findByUserName(userName));

        if (userDTO!=null) {

            return userDTO;

        } else {
            throw new NotFoundException("User not exists");

        }
    }
}
