package com.lucid.a2bmoving.interfaces;

import com.lucid.a2bmoving.admin.Movers;
import com.lucid.a2bmoving.customer.Customer;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ControllerInterface {
    Optional<Customer> getCustomerByID(@PathVariable("id") Long customer_id);

    void addNewOrder(@RequestBody Customer customer);

    void patchOrder(@PathVariable(value = "customer_id") Customer customer);

    void deleteCustomer(@PathVariable(value = "customer_id") Long customer_id);
}