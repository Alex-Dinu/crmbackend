package com.ceme.crm.repository;

import java.util.List;

import com.ceme.crm.entity.InteractionModel;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface InteractionRepository extends MongoRepository<InteractionModel, ObjectId> {

    public List<InteractionModel> findByCustomerId(String customerId);
}