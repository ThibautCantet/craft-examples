package com.thibautcantet.temporal_coupling_and_immutability;

public class CustomerService {

    private Repository repository;

    public void process(String customerName, String addressString, Repository repository) {
        this.repository = repository;
        var address = createAddress(addressString);
        var customer = createCustomer(customerName, address);
        saveCustomer(customer);
    }

    private Address createAddress(String addressString) {
        return new Address(addressString);
    }

    private Customer createCustomer(String name, Address address) {
        return new Customer(name, address);
    }

    private void saveCustomer(Customer customer) {
        repository.save(customer);
    }
}
