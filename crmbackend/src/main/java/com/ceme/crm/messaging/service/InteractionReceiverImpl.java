package com.ceme.crm.messaging.service;

import com.ceme.crm.entity.InteractionModel;
import com.ceme.crm.service.InteractionService;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.IntegrationMessageHeaderAccessor;
import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;

@MessageEndpoint
@Service
public class InteractionReceiverImpl implements InteractionReceiver {

    @Autowired
    private InteractionService interactionService;
    
    private static final Logger logger = LogManager.getLogger(InteractionReceiverImpl.class);

    @ServiceActivator(inputChannel = "interactionChannel")
    @Override
    public InteractionModel addRecord(Message<InteractionModel> message) {
        IntegrationMessageHeaderAccessor accessor = new IntegrationMessageHeaderAccessor(message);
        logger.info("Sequence: {} / {}", accessor.getSequenceNumber(), accessor.getSequenceSize());
        logger.info("Add interaction record: {}", message.getPayload());

        return interactionService.insertInteraction(message.getPayload());

    }

}
