package com.stitchline.stitchlineloginsystem.repo;

import com.stitchline.stitchlineloginsystem.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface UserRepo extends MongoRepository<User,String> {
        User findByUserNameAndPasswordEquals(String userName, String password);
}
