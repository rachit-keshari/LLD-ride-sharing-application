package com.transport.ride_sharing.service;

import com.transport.ride_sharing.model.Users;
import com.transport.ride_sharing.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersService {

    @Autowired
    private UsersRepository usersRepository;

    public void add_user(String name,String gender,int age){
        Users user=new Users();
        user.setName(name);
        user.setGender(gender);
        user.setAge(age);
        usersRepository.save(user);
    }
}
