package com.thibautcantet.temporal_coupling_and_immutability;

public class CustomerService {

    private Address address;
    private Customer customer;
    private Repository repository;

    public void process(String customerName, String addressString, Repository repository) {
        this.repository = repository;
        this.createAddress(addressString);
        this.createCustomer(customerName, address);
        this.saveCustomer(customer);
    }

    private void createAddress(String addressString) {
        address = new Address(addressString);
    }

    private void  createCustomer(String name, Address address) {
        customer = new Customer(name, address);
    }

    private void saveCustomer(Customer customer) {
        repository.save(customer);
    }
}
