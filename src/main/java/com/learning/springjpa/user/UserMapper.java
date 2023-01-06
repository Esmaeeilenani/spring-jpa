package com.learning.springjpa.user;


import com.learning.springjpa.EntityMapper;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper extends EntityMapper<User, UserDto> {
    UserMapper MAP = Mappers.getMapper(UserMapper.class);

}
