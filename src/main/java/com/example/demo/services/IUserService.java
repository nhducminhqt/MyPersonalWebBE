package com.example.demo.services;

import com.example.demo.dtos.UserDTO;
import com.example.demo.exceptions.DataNotFoundException;
import com.example.demo.models.User;

public interface IUserService {
    User createUser(UserDTO userDTO) throws DataNotFoundException;
    String Login(String phoneNumber, String password);
}
