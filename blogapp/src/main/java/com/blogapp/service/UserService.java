package com.blogapp.service;

import com.blogapp.entity.User;
import com.blogapp.exception.UserNotFoundException;
import com.blogapp.dto.UserDto;
import com.blogapp.mapper.UserMapper;
import com.blogapp.dto.request.CreateUserRequest;
import com.blogapp.repository.UserRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional

public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;


    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public List<UserDto> fetchAllUsers() {

        return userRepository.findAll()
                .stream()
                .map(userMapper::toDto)
                .collect(Collectors.toList());

    }

    public UserDto getUserById(String id) {
        return userMapper.toDto(findUserById(id));
    }


    public UserDto createUser(CreateUserRequest request) {

        User user = new User();

        user.setUserName(request.getUserName());
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        return userMapper.toDto(userRepository.save(user));

    }


    public UserDto updateUser(String id, UserDto userDto) {

        return userRepository.findById(id)
                .map(entry -> update(entry, userDto))
                .map(userMapper::toDto)
                .orElseThrow(() -> new UserNotFoundException("No user found for " + id));

    }


    public String deleteUser(String id) {
        User existingUser = findUserById(id);
        userRepository.delete(existingUser);
        return "The user with this username " + existingUser.getUserName() + " and this id: " + id + " is deleted";
    }


    private User update(User user, UserDto userDto) {
        user.setUserName(userDto.getUserName());
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        return user;
    }


    public User findUserById(String id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User with this " + id + " not found!"));
    }


}
