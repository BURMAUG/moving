package com.lucid.a2bmoving.admin.controller;

import com.lucid.a2bmoving.admin.Movers;
import com.lucid.a2bmoving.admin.service.MoverService;
import com.lucid.a2bmoving.customer.Customer;
import com.lucid.a2bmoving.customer.Status;
import com.lucid.a2bmoving.repository.CustomerRepository;
import com.lucid.a2bmoving.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping(path = "/admin")
public class AdminController {
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private CustomerService customerService;
    @Autowired
    private MoverService moverService;

    @GetMapping("/customers")
    public Iterable<Customer> getAllCustomers()
    {
        return customerService.getAllCustomer();
    }

    @PostMapping("/customers")
    public void postCustomer(@RequestBody Customer customer)
    {
        customerRepository.save(customer);
    }
    /**
     * @param customer_id
     * get a customer from the database with a specific id.
     */
    @GetMapping("/customers/{id}")
    public Optional<Customer> getCustomerById(@PathVariable(value = "id") Long customer_id)
    {
        return customerService.getCustomerById(customer_id);
    }

    /**
     * @return  List<customers> a list of customer that have their moving done completely
     */
    @GetMapping("/complete")
    public List<Customer> getCustomersByPurchaseStatus(){
        return customerRepository.findByPurchaseStatus(Status.COMPLETE);
    }

    /**
     * @return list of Customers
     * this method finds a specific list of customers that have purchased our product and the
     * order was in progress.
     */
    @GetMapping("/progress")
    public List<Customer> getCustomersByProgressStatus()
    {
        return customerRepository.findByPurchaseStatus(Status.IN_PROGRESS);
    }

    /**
     * this method finds a specific list of customers that have purchased our product.
     */
    @GetMapping("/purchase")
    public List<Customer> getCustomersByPurchase()
    {
        return customerRepository.findByPurchaseStatus(Status.PURCHASE);
    }

    /**
     * @param customer_id
     * this method is used to delete a customer either when a customers order has been
     * complete, or cancelled
     */
    @DeleteMapping("/customers/{customer_id}")
    public void deleteCustomer(@PathVariable(value = "customer_id") Long customer_id)
    {
        customerService.deleteCustomer(customer_id);
    }

    @GetMapping("/movers")
    public Iterable<Movers> getMovers()
    {
      return moverService.getAllMovers();
    }
}