package com.example.userservicenov24.dtos;

import com.example.userservicenov24.models.Role;
import com.example.userservicenov24.models.User;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UserResponseDto {
    private String name;
    private String email;
    private List<Role> roleList;

    public static UserResponseDto from(User user) {
        UserResponseDto responseDto = new UserResponseDto();
        responseDto.setEmail(user.getEmail());
        responseDto.setName(user.getName());
        responseDto.setRoleList(user.getRoles());

        return responseDto;
    }
}
