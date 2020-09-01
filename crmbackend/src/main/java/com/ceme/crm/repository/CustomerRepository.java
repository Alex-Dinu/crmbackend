package com.ceme.crm.repository;

import java.util.List;

import com.ceme.crm.entity.CustomerModel;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

// extend MongoRepository, tell it the model and the Id type and it will
// automagically create all the crud operations for you.
public interface CustomerRepository extends MongoRepository<CustomerModel, ObjectId> {

    public CustomerModel findById(String id);

    @Query("{'emailAddress': { $regex: ?0, $options:'i'}} ")
    public List<CustomerModel> findCustomersByEmail(final String searchString);
}