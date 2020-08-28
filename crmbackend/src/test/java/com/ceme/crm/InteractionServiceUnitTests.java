package com.ceme.crm;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import com.ceme.crm.customExceptions.InteractionsNotFoundException;
import com.ceme.crm.entity.InteractionModel;
import com.ceme.crm.repository.InteractionRepository;
import com.ceme.crm.service.InteractionService;

import org.bson.types.ObjectId;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.mockito.Mock;

public class InteractionServiceUnitTests {
    @Mock
    InteractionRepository interactionRepositoryMock;

    @Mock
    ObjectId id;

    // @Test
    // public void WhenNoInteractionAreFound_ExpectInteractionsNotFoundException() {
    // InteractionService interactionService = new
    // InteractionService(interactionRepositoryMock);

    // when(interactionRepositoryMock.findInterationsForCustomerId(new
    // ObjectId("5f46dd050075914ded6e5c8a")))
    // .thenReturn(new ArrayList<InteractionModel>());

    // Assertions.assertThrows(InteractionsNotFoundException.class, () -> {

    // interactionService.findInterationForCustomerId(anyString());
    // });

    // }
}