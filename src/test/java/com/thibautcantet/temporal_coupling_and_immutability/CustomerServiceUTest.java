package com.thibautcantet.temporal_coupling_and_immutability;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CustomerServiceUTest {

    @Test
    void process_should_save_customer_with_name_and_address() {
        // given
        final CustomerService customerService = new CustomerService();
        final Repository repository = new Repository();

        // when
        customerService.process("name", "address", repository);

        // then
        assertThat(repository.getCustomers()).containsExactly(new Customer("name", new Address("address")));
    }
}