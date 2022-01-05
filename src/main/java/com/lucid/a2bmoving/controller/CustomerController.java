package com.lucid.a2bmoving.controller;

import com.lucid.a2bmoving.customer.Customer;
import com.lucid.a2bmoving.interfaces.ControllerInterface;
import com.lucid.a2bmoving.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping(path = "/v1")
public class CustomerController implements ControllerInterface{
    @Autowired
    protected CustomerService customerService;

    @Override
    @GetMapping("/customers/{id}")
    public Optional<Customer> getCustomerByID(Long customer_id) {
        return customerService.getCustomerById(customer_id);
    }

    /**
     * THIS ADD A NEW WORK ORDER FROM A CUSTOMER
     * @param customer
     */
    @PostMapping("cusmter")
    public void addNewOrder(@RequestBody Customer customer)
    {
        customerService.addNewCustomerOrder(customer);
    }

    @Override
    @PatchMapping("/customers/{customer_id}")
    public void patchOrder(@PathVariable Customer customer){
        customerService.patchCustomerOrder(customer);
    }

    @Override
    @DeleteMapping("/customers/{customer_id}")
    public void deleteCustomer(@PathVariable(value = "customer_id") Long customer_id)
    {
        customerService.deleteCustomer(customer_id);
    }
}
