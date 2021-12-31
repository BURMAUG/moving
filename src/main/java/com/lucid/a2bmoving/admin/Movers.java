package com.lucid.a2bmoving.admin;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "movers")
public class Movers {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private UUID movers_id;
    private String mover_name;
    //get the admin A2B to make to movers
    @ManyToOne//
    @JoinColumn(name = "a2b_id", nullable = false)
    private A2B a2B;

    public A2B getA2B() {
        return a2B;
    }

    public void setA2B(A2B a2B) {
        this.a2B = a2B;
    }

    public Movers() {
    }

    public Movers(String mover_name) {
        super();
        this.mover_name = mover_name;
    }

    public String getMover_name() {
        return mover_name;
    }

    public void setMover_name(String mover_name) {
        this.mover_name = mover_name;
    }

    @Override
    public String toString() {
        return "Movers{" +
                "mover_name='" + mover_name + '\'' +
                '}';
    }
}
