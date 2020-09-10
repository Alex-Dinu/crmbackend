package com.ceme.crm.messaging.service;

import com.ceme.crm.entity.InteractionModel;
import com.ceme.crm.messaging.configuration.InteractionGateway;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.IntegrationMessageHeaderAccessor;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class InteractionSenderImpl implements InteractionSender {

    private static final Logger logger = LogManager.getLogger(InteractionSenderImpl.class);

    @Autowired
    private InteractionGateway interactionGateway;

    @Override
    public InteractionModel addInteractionRecord(InteractionModel interaction) {
        logger.info("InteractionSender Service: add interaction record: {}", interaction);
        // Add the payload and the headers.
        Message<InteractionModel> message = MessageBuilder.withPayload(interaction)
                .setHeader(IntegrationMessageHeaderAccessor.SEQUENCE_NUMBER, 1)
                .setHeader(IntegrationMessageHeaderAccessor.SEQUENCE_SIZE, 5).build();
        return interactionGateway.addRecord(message);

    }

}
