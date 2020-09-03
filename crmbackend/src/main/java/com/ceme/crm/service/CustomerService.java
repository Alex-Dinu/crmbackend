package com.ceme.crm.service;

import com.ceme.crm.customExceptions.CustomerNotFoundException;
import com.ceme.crm.entity.CustomerModel;
import com.ceme.crm.repository.CustomerRepository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.bson.types.ObjectId;
import java.util.List;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public CustomerModel addCustomer(CustomerModel customer) {
        return customerRepository.insert(customer);
    }

    // Add the logic in the service layer and not in the controller.
    public CustomerModel getCustomerById(String id) throws CustomerNotFoundException {
        CustomerModel foundCustomer = customerRepository.findById(new ObjectId(id)).get();
        if (foundCustomer.getId() == null) {
            throw new CustomerNotFoundException("Could not find reuqested customer.");
        }
        return foundCustomer;

    }

    public List<CustomerModel> getCustomers() {
        List<CustomerModel> customers = customerRepository.findAll();
        return customers;
    }

    public List<CustomerModel> getCustomersByEmail(String searchString) {
        List<CustomerModel> customers = customerRepository.findCustomersByEmail(searchString);
        return customers;
    }

    public void deleteCustomer(String id) {
        customerRepository.deleteById(new ObjectId(id));
    }

    public CustomerModel updateCustomer(CustomerModel customer) {
        return customerRepository.save(customer);
    }
}