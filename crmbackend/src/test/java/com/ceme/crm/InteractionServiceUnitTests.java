package com.ceme.crm;

import com.ceme.crm.customExceptions.InteractionNotFoundException;
import com.ceme.crm.entity.InteractionModel;
import com.ceme.crm.repository.InteractionRepository;
import com.ceme.crm.service.InteractionService;
import com.mongodb.assertions.Assertions;

import org.bson.types.ObjectId;
import org.junit.Test;
import org.mockito.Mock;

public class InteractionServiceUnitTests {
    @Mock
    InteractionRepository interactionRepositoryMock;

    @Mock
    ObjectId id;

    @Test
    public void ThrowUserNotFoundTest() {
        InteractionService interactionService = new InteractionService(interactionRepositoryMock);
       
        when(interactionRepositoryMock.findByUserId(new ObjectId("5a46dd050075914ded6e5c8r")).get())
                .thenReturn(new InteractionModel());

        Assertions.assertThrows(InteractionNotFoundException.class, () -> {

            interactionService.getUserId(anyString());
        });

    }
}