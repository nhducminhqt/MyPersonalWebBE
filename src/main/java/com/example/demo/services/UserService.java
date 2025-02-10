package com.example.demo.services;

import com.example.demo.dtos.UserDTO;
import com.example.demo.exceptions.DataNotFoundException;
import com.example.demo.models.Role;
import com.example.demo.models.User;
import com.example.demo.repositories.RoleRepository;
import com.example.demo.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService implements IUserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    @Override
    public User createUser(UserDTO userDTO) throws DataNotFoundException {
        String phoneNumber = userDTO.getPhoneNumber();
        if (userRepository.existsByPhoneNumber(phoneNumber)) {
            throw new DataIntegrityViolationException("Phone number already exists");
        }
        User newUser = User.builder()
                .fullName(userDTO.getFullName())
                .phoneNumber(phoneNumber)
                .password(userDTO.getPassword())
                .address(userDTO.getAddress())
                .dateOfBirth(userDTO.getDateOfBirth())
                .facebookAccountId(userDTO.getFacebookAccountId())
                .googleAccountId(userDTO.getGoogleAccountId()).build();
        Role role = roleRepository.findById(userDTO.getRoleId())
                .orElseThrow(()-> new DataNotFoundException("Role not found"));
        newUser.setRole(role);
        if (userDTO.getFacebookAccountId() ==0 && userDTO.getGoogleAccountId() ==0) {
            String password = userDTO.getPassword();

        }
        return userRepository.save(newUser);
    }

    @Override
    public String Login(String phoneNumber, String password) {
        return "";
    }
}
