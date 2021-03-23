package com.springboot.course.demo.mapper;


import com.springboot.course.demo.domain.Customer;
import com.springboot.course.demo.dto.CustomerResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CustomerMapper {


    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);

    CustomerResponseDTO toCustomerResponseDto(Customer customer);
}
