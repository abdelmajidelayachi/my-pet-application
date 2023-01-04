package com.example.mypet.payload.objectmapper;

import com.example.mypet.payload.dao.UserResponse;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {



    public UserResponse convertToUserResponse(Object user) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(user, UserResponse.class);
    }


}
