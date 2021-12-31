package com.lucid.a2bmoving.customer;
/**
 * @author Burmau Garba
 * @version 1.1
 */

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Table(name = "customer")
@Getter
@Setter
@ToString
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true)
    private Long customer_id;

    @Column(nullable = false)
    private String customer_name;
    @Column(nullable = false)
    private String customer_email;
    @Column(nullable = false)
    private String customer_phone;
    //PICKUP DETAILS
    @Column(nullable = false)
    private String pickup_address;
    private Status purchaseStatus;

    //DROP OFF DETAILS
    @Column(nullable = false)
    private String drop_off_address;
//    @Column(nullable = false)
//    private String drop_off_state;
//    @Column(nullable = false)
//    private int drop_off_zip_code;
//    //DROP OFF DETAILS END

    /***
     * Customers can have many workers working for him/her
     */
//    @OneToMany//one customer can have many movers
//    private Movers customerMovers;
    /**
     * The customer has only one cart
     * */
    @OneToOne(cascade = CascadeType.ALL)//one customer can have only one cart
    private Cart customerCart;
    /**Getters and setters for CART begins*/
    public Cart getCustomerCart() {
        return customerCart;
    }

    public void setCustomerCart(Cart customerCart) {
        this.customerCart = customerCart;
    }
    /**Getters and setters for CART end*/

    /**
     * The customer can have many orders
     */
//    @OneToMany//one customer can have many orders
//    private Orders customerOrders;

    @NotNull private int room_size = 0;

    private LocalDate date;//questionable I will need to check this
    /**
     * For now, I have to get the month, day and year individually
     * */
    private int month; //month
    private int day; //day
    private int year; //year

    public Customer(String customer_name,
                    String customer_email,
                    String customer_phone,
                    String pickup_address,
                    Status purchaseStatus,
                    String drop_off_address,
//                    Cart customerCart,
                    int room_size) {
        this.customer_name = customer_name;
        this.customer_email = customer_email;
        this.customer_phone = customer_phone;
        this.pickup_address = pickup_address;
        this.purchaseStatus = purchaseStatus;
        this.drop_off_address = drop_off_address;
//        this.customerCart = customerCart;
        this.room_size = room_size;
    }

    public void setStatus(Status status) {}
}


/**
 * JSon object loader for me
 */
//{
//    "customer_name": "Bum",
//    "customer_email": "Bum",
//    "customer_phone": "Bum",
//    "pickup_address": "asda",
//    "purchaseStatus": "COMPLETE",
//    "drop_off_address": "asd",
//    "room_size": 320
//
//}