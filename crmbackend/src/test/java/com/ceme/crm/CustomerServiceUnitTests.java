package com.ceme.crm;


import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import com.ceme.crm.customExceptions.CustomerNotFoundException;
import com.ceme.crm.entity.CustomerModel;
import com.ceme.crm.repository.CustomerRepository;
import com.ceme.crm.service.CustomerService;

import org.bson.types.ObjectId;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

public class CustomerServiceUnitTests {

    @Mock
    CustomerRepository customerRepositoryMock;

    @Mock
    ObjectId id;

    @Test
    public void ThrowCustomerNotFoundTest() {
        CustomerService customerService = new CustomerService(customerRepositoryMock);
        // when(customerRepositoryMock.findById(new
        // ObjectId(anyString())).get()).thenReturn(new CustomerModel());
        when(customerRepositoryMock.findById(new ObjectId("5f511f7c199c7d14475f8a62")).get())
                .thenReturn(new CustomerModel());

        Assertions.assertThrows(CustomerNotFoundException.class, () -> {

            customerService.getCustomerById(anyString());
        });

    }

}