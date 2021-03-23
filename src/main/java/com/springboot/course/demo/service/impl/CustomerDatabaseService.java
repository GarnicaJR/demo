package com.springboot.course.demo.service.impl;

import com.springboot.course.demo.domain.Customer;
import com.springboot.course.demo.service.DatabaseService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Service
public class CustomerDatabaseService implements DatabaseService {

    private static final List<Customer> customers  = new CopyOnWriteArrayList<>();


    @PostConstruct
    private void loadData(){

        Customer customer = new Customer();
        customer.setSex("female");
        customer.setId(1001);
        customer.setName("Ashely Smith");
        customers.add(customer);
        System.out.println("data loaded");
    }


    public boolean save(Customer customer) {

        for(Customer c: customers){
            if(c.getId()==customer.getId()){
                return false;
            }
        }
        customers.add(customer);
        return true;
    }

    public void delete(Customer customer){
        customers.remove(customer);
    }

    public void update(Customer customer){
        for(Customer c: customers){
            if(c.getId() ==  customer.getId()){
                c.setName(customer.getName());
            }
        }
    }

    public List<Customer> all(){
        return customers;
    }
}
