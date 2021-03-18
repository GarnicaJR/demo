package com.springboot.course.demo.resources;


import com.fasterxml.jackson.databind.node.POJONode;
import com.springboot.course.demo.domain.Customer;
import com.springboot.course.demo.domain.CustomerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/customer")
public class CustomerResource {


    @Autowired
    private DatabaseService service;

    //Rest API -> GET PUT POST PATCH DELETE

    @GetMapping()
    public ResponseEntity<List<Customer>>  all(){

        List<Customer> customer = service.all();
        return ResponseEntity.ok(customer);
    }

    @PostMapping()
    public ResponseEntity<CustomerResponse> createCustomer(@RequestBody  Customer customer){

        boolean isSaved = service.save(customer);
        CustomerResponse response = new CustomerResponse();

        if(isSaved){
            response.setStatus("Customer has been created");
            response.setDate(LocalDate.now().toString());
            return ResponseEntity.status(201).body(response);
        }
        else{
            response.setStatus("look like the ID already exists");
            response.setDate(LocalDate.now().toString());
            return ResponseEntity.status(400).body(response);
        }
    }


    @PutMapping
    public ResponseEntity<?> updateCustomer(@RequestBody Customer customer){
        service.update(customer);
        return ResponseEntity.status(204).build();
    }

    @DeleteMapping
    public ResponseEntity<?> deleteCustomer(@RequestBody Customer customer){

        service.delete(customer);
        return ResponseEntity.status(204).build();
    }

}
