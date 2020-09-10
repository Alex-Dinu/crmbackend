package com.ceme.crm.messaging.service;

import com.ceme.crm.entity.InteractionModel;

import org.springframework.messaging.Message;
public interface InteractionReceiver {
    InteractionModel addRecord(Message<InteractionModel> message);
}
