package com.ceme.crm.messaging.configuration;

import com.ceme.crm.entity.InteractionModel;
import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.messaging.Message;

@MessagingGateway(name = "interactionGateway", defaultRequestChannel = "interactionChannel")
public interface InteractionGateway {

    @Gateway
    InteractionModel addRecord(Message<InteractionModel> record);
}
