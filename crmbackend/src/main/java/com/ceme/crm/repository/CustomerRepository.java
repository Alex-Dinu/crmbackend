package com.ceme.crm.repository;

import com.ceme.crm.entity.CustomerModel;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerRepository extends MongoRepository<CustomerModel, ObjectId> {
    // <model, Id Type>
    public CustomerModel findById(String id);
}