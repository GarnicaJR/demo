package com.springboot.course.demo.resources;


import com.springboot.course.demo.domain.Customer;
import com.springboot.course.demo.dto.CustomerResponseDTO;
import com.springboot.course.demo.mapper.CustomerMapper;
import com.springboot.course.demo.service.DatabaseService;
import com.springboot.course.demo.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/customer")
public class CustomerResource {


    @Autowired
    private DatabaseService databaseService;


    @Autowired
    private PaymentService paymentService;


    @Autowired
    @Qualifier("debitCardPaymentService")
    private PaymentService debitcardPaymentService;

    //Rest API -> GET PUT POST PATCH DELETE

    @GetMapping()
    public ResponseEntity<List<CustomerResponseDTO>>  all(){

        List<Customer> customer = databaseService.all();

        //Call a payment method
        paymentService.pay("888a8sd8fas",150);
        debitcardPaymentService.pay("kkkak",100);

        List<CustomerResponseDTO> payload = customer.stream()
                .map(CustomerMapper.INSTANCE::toCustomerResponseDto)
                .collect(Collectors.toList());


        return ResponseEntity.ok(payload);
    }

    @PostMapping()
    public ResponseEntity<CustomerResponseDTO> createCustomer(@RequestBody  Customer customer){

        boolean isSaved = databaseService.save(customer);


        if(isSaved){
            CustomerResponseDTO customerResponseDTO = CustomerMapper.INSTANCE.toCustomerResponseDto(customer);
            return ResponseEntity.status(201).body(customerResponseDTO);
        }
        else{
            return ResponseEntity.status(204).build();
        }
    }


    @PutMapping
    public ResponseEntity<?> updateCustomer(@RequestBody Customer customer){
        databaseService.update(customer);
        return ResponseEntity.status(204).build();
    }

    @DeleteMapping
    public ResponseEntity<?> deleteCustomer(@RequestBody Customer customer){

        databaseService.delete(customer);
        return ResponseEntity.status(204).build();
    }

}
