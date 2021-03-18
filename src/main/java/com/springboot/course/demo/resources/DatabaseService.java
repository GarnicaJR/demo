package com.springboot.course.demo.resources;

import com.springboot.course.demo.domain.Customer;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Service
public class DatabaseService {

    private static final List<Customer> customers  = new CopyOnWriteArrayList<>();


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
