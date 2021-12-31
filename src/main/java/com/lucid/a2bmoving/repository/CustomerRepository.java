package com.lucid.a2bmoving.repository;
/**
 * @author Burmau Garba
 * @version 1.1
 **/
import com.lucid.a2bmoving.customer.Customer;
import com.lucid.a2bmoving.customer.Status;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {
     List<Customer> findByPurchaseStatus(@Param("status") Status status);
     Iterable<Customer>findAll();
//     Optional<Customer> findByCustomer_email(String customerEmail);
     @Query("select s from Customer s where s.customer_email = ?1")
     Optional<Customer> findCustomerByCustomer_email(String customerEmail);
     List<Customer> findCustomerByPurchaseStatus(Status status);
}
