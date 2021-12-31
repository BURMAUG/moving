package com.lucid.a2bmoving.config;

import com.lucid.a2bmoving.customer.Customer;
import com.lucid.a2bmoving.customer.Status;
import com.lucid.a2bmoving.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

@org.springframework.context.annotation.Configuration
public class Configuration {

    @Autowired
    private CustomerRepository customerRepo;
    @Bean
    public CommandLineRunner runner() {
        return arg -> {
            customerRepo.save(
                    new Customer(
                            "Antony Fogle ",
                            "a.foggle@a2b.com",
                            "513-725-8333",
                            "A2B INC",
                            Status.COMPLETE,
                            "A2B HQ",
//                            new Cart(),
                            1000
                    ));
            customerRepo.save(new Customer(
                    "Marty",
                    "marty@a2b.com",
                    "800-hot-line",
                    "A2B INC",
                    Status.IN_PROGRESS,
                    "A2B HQ",
//                    new Cart(),
                    23
            ));
            customerRepo.save(new Customer(
                    "Josh Oziri ",
                    "josh@a2b.com",
                    "800-a2b-spicy",
                    "A2B INC",
                    Status.PURCHASE,
                    "A2B HQ",
//                    new Cart(),
                    23
            ));
            customerRepo.save(new Customer(
                    "Johnny",
                    "johnny@a2b.com",
                    "800-big-drip",
                    "A2B INC",
                    Status.PENDING,
                    "A2B HQ",
//                    new Cart(),
                    23
            ));
            customerRepo.save(new Customer(
                    "DJ",
                    "dj@a2b.com",
                    "800-clumzy-hand",
                    "A2B INC",
                    Status.CANCEL,
                    "A2B HQ",
//                    new Cart(),
                    23
            ));
        };
    }
}
