package com.learning.springjpa.product;

import com.learning.springjpa.EntityMapper;
import com.learning.springjpa.order.OrderMapper;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(uses = OrderMapper.class)
public interface ProductMapper extends EntityMapper<Product, ProductDto> {

    ProductMapper MAP = Mappers.getMapper(ProductMapper.class);
}
