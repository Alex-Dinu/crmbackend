package com.ceme.crm.service;

import java.util.Date;
import java.util.List;

import com.ceme.crm.customExceptions.InteractionsNotFoundException;
import com.ceme.crm.entity.InteractionModel;
import com.ceme.crm.repository.InteractionRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.bson.types.ObjectId;

@Service
public class InteractionService {
    @Autowired
    private InteractionRepository interactionRepository;

    public InteractionService(InteractionRepository interactionRepository) {
        this.interactionRepository = interactionRepository;
    }

    public InteractionModel insertInteraction(InteractionModel interaction) {
        interaction.setDateTime(new Date());
        return interactionRepository.insert(interaction);
    }

    public void deleteInteraction(String interactionId) {
        interactionRepository.deleteById(new ObjectId(interactionId));
    }

    public InteractionModel updateInteraction(InteractionModel interaction) {
        interaction.setDateTime(new Date());
        return interactionRepository.save(interaction);
    }

    public List<InteractionModel> findInterationForCustomerId(String customerId) throws InteractionsNotFoundException {
        List<InteractionModel> interactions = (List<InteractionModel>) interactionRepository
                .findByCustomerId(customerId);
        if (interactions != null && interactions.size() == 0) {
            throw new InteractionsNotFoundException("Interractions Not found .");
        }
        return interactions;

    }
}