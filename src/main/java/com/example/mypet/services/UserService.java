package com.example.mypet.services;

import com.example.mypet.entities.User;
import com.example.mypet.payload.dao.UserResponse;
import com.example.mypet.payload.dto.UserRequest;
import com.example.mypet.payload.objectmapper.UserMapper;
import com.example.mypet.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * @author Abdelmajid EL AYACHI
 */

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * @return List of all users
     */
    public List<UserResponse> findAllUser() {
        List<UserResponse> users = ((List<User>) userRepository.findAll()).stream().map(user -> {
            UserMapper userMapper = new UserMapper();
            return userMapper.convertToUserResponse(user);
        }).toList();
        return users;
    }

    /**
     * @param id
     * @return User by id
     */
    public UserResponse findUserById(Long id) {
        Optional<User> user = userRepository.findById(id);
        UserMapper userMapper = new UserMapper();
        return userMapper.convertToUserResponse(user);
    }

    /**
     * @param userRequest
     * @return User
     */
    public User saveUser(UserRequest userRequest) {
        User user = new User();
        if (userRequest.getFirstname() == null || userRequest.getLastname() == null || userRequest.getEmail() == null || userRequest.getPassword() == null || userRequest.getConfirmPassword() == null) {
            throw new IllegalArgumentException("Firstname, lastname, email, password and confirm password  are required");
        }
        if (!userRequest.getPassword().equals(userRequest.getConfirmPassword())) {
            throw new IllegalArgumentException("Password and confirm password must be the same");
        }
        user.setFirstname(userRequest.getFirstname());
        user.setLastname(userRequest.getLastname());
        user.setEmail(userRequest.getEmail());
        user.setPassword(userRequest.getPassword());
        if (userRequest.getUsername() != null) {
            user.setUsername(userRequest.getUsername());
        }
        if (userRequest.getPhone() != null) {
            user.setTel(userRequest.getPhone());
        }
        return userRepository.save(user);
    }

    /**
     * delete user by id
     *
     * @param id
     * @return void
     */
    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }

    /**
     * update user by id
     *
     * @param userRequest
     * @param id
     * @return User
     */
    @Transactional
    public User updateUser(UserRequest userRequest, Long id) {
        Optional<User> userToUpdate = userRepository.findById(id);
        if (userToUpdate.isPresent()) {
            User user = userToUpdate.get();
            if (userRequest.getFirstname() != null) {
                user.setFirstname(userRequest.getFirstname());
            }
            if (userRequest.getLastname() != null) {
                user.setLastname(userRequest.getLastname());
            }
            if (userRequest.getEmail() != null) {
                user.setEmail(userRequest.getEmail());
            }
            if (userRequest.getPassword() != null) {
                user.setPassword(userRequest.getPassword());
            }
            if (userRequest.getPhone() != null) {
                user.setTel(userRequest.getPhone());
            }
            if (userRequest.getUsername() != null) {
                user.setUsername(userRequest.getUsername());
            }
            return user;
        } else {
            throw new RuntimeException("User not found");
        }
    }


}
