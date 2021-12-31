package com.lucid.a2bmoving.admin;

import com.lucid.a2bmoving.customer.Customer;
import javax.persistence.*;
import java.util.UUID;
import java.util.List;

@Entity
@Table(name = "A2B")
public class A2B {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @OneToMany
    private List<Movers> moversList;
    @OneToMany
    private List<Customer> customers;
    //I don't know if I need the customers carts



    public A2B(List<Movers> moversList) {
        this.moversList = moversList;
    }

    public A2B() {

    }
}
