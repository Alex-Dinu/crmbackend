package com.ceme.crm.service;

import java.util.List;

import com.ceme.crm.customExceptions.InteractionNotFoundException;
import com.ceme.crm.entity.InteractionModel;
import com.ceme.crm.repository.InteractionRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.bson.types.ObjectId;

@Service
public class InteractionService {
    @Autowired
    private InteractionRepository interactionRepository;
    public InteractionService(InteractionRepository interactionRepository){
        this.interactionRepository = interactionRepository;
    }
    
    public InteractionModel addComments(InteractionModel comments) {
        return interactionRepository.insert(comments);
    }

    public void deleteComments(String userId) {
        interactionRepository.deleteById(new ObjectId(userId));
    }

    public InteractionModel updateComments(InteractionModel comments) {
        return interactionRepository.save(comments);
    }


     public List< InteractionModel> findInterationForCustomerId(String customerId) throws InteractionNotFoundException {
        List <InteractionModel> interactions = interactionRepository.findInterationsForCustomerId(customerId);
        if (interactions != null && interactions.size() == 0) {
            throw new InteractionNotFoundException("Interractions Not found .");
        }
        return interactions;

    }
}