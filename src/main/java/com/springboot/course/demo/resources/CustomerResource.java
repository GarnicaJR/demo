package com.springboot.course.demo.resources;


import com.springboot.course.demo.domain.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<Customer> createCustomer(@RequestBody  Customer customer){
        customer.setId(customer.getId());
        customer.setName(customer.getName());

        service.save(customer);

        return ResponseEntity.status(201).body(customer);
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
