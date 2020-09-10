package com.ceme.crm.messaging.service;

import com.ceme.crm.entity.InteractionModel;

public interface InteractionSender {
    InteractionModel addInteractionRecord(InteractionModel interaction);
}
