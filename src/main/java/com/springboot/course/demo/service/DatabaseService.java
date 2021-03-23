package com.springboot.course.demo.service;

import com.springboot.course.demo.domain.Customer;

import java.util.List;

public interface DatabaseService {


    public boolean save(Customer customer);
    public void delete(Customer customer);
    public void update(Customer customer);
    public List<Customer> all();
}
