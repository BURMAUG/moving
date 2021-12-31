package com.lucid.a2bmoving.service;


import com.lucid.a2bmoving.customer.Customer;
import com.lucid.a2bmoving.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Iterable<Customer> getAllCustomer()
    {
        return customerRepository.findAll();
    }

    public Optional<Customer> getCustomerById(Long id)
    {
        return customerRepository.findById(id);
    }

    public void addNewCustomerOrder(Customer customer) {
        Optional<Customer> customerByEmail =
                customerRepository
                .findCustomerByCustomer_email(customer
                        .getCustomer_email());
        if (customerByEmail.isPresent())
            throw new IllegalArgumentException("The is someone with this email");
        customerRepository.save(customer);
    }

    public void patchCustomerOrder(Customer customer) {
    }

    public void deleteCustomer(Long customer_id)
    {
        Optional<Customer> customerById = customerRepository
                .findById(customer_id);
        if (!customerById.isPresent())
            throw new IllegalArgumentException("No Such Customer with that ID ");
        customerRepository.deleteById(customer_id);
    }
}
