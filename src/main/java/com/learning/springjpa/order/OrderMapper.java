package com.learning.springjpa.order;

import com.learning.springjpa.EntityMapper;

import org.mapstruct.Mapper;

import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface OrderMapper extends EntityMapper<Order,OrderDto> {
    OrderMapper MAP = Mappers.getMapper(OrderMapper.class);
//
//    @Override
//    @Mapping(source = "refNumber",target = "orderNumber")
//    OrderDto toDto(Order entity);


    @Override
    @Mapping(source = "products", target = "products" ,ignore = true)
    Order toEntity(OrderDto dto);

    @Override
    @Mapping(source = "products", target = "products" ,ignore = true)
    OrderDto toDto(Order entity);
}
