package com.vitu.user.request.manager.web.mapper;

import com.vitu.user.request.manager.domain.User;
import com.vitu.user.request.manager.web.dto.UserDto;
import org.springframework.beans.BeanUtils;

import java.util.List;

public interface UserMapper {

    static User toDomain(UserDto userDto) {
        User user = new User();
        BeanUtils.copyProperties(userDto, user);
        return user;
    }

    static List<User> toDomain(List<UserDto> userDtos) {
        return userDtos.stream().map(UserMapper::toDomain).toList();
    }

    static UserDto toDto(User user) {
        UserDto userDto = UserDto.builder().build();
        BeanUtils.copyProperties(user, userDto);
        return userDto;
    }

    static List<UserDto> toDto(List<User> users) {
        return users.stream().map(UserMapper::toDto).toList();
    }


}
