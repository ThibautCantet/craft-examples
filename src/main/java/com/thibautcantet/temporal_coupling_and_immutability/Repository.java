package com.thibautcantet.temporal_coupling_and_immutability;

import java.util.ArrayList;
import java.util.List;

public class Repository {
    private final List<Customer> customers = new ArrayList<>();

    public void save(Customer customer) {
        customers.add(customer);
    }

    public List<Customer> getCustomers() {
        return customers;
    }
}
