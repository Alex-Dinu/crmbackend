package com.ceme.crm.service;

import com.ceme.crm.customExceptions.CustomerNotFoundException;
import com.ceme.crm.entity.CustomerModel;
import com.ceme.crm.repository.CustomerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.bson.types.ObjectId;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    public CustomerModel addCustomer(CustomerModel customer){
        return customerRepository.insert(customer);
    }

    public CustomerModel getCustomerById(String id) throws CustomerNotFoundException {
        CustomerModel foundCustomer = customerRepository.findById(new ObjectId(id)).get();
        if(foundCustomer.getId() == null) {
            throw new CustomerNotFoundException("Could not find reuqested customer.");
        }
        return foundCustomer;


    }

    public void deleteCustomer(String id){
        customerRepository.deleteById(new ObjectId(id));
    }

    public CustomerModel updateCustomer(CustomerModel customer){
        return customerRepository.save(customer);
    }
}