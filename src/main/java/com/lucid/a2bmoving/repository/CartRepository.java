package com.lucid.a2bmoving.repository;

import com.lucid.a2bmoving.customer.Cart;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CartRepository extends CrudRepository<Cart, UUID> {

}
