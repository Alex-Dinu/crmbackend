package com.ceme.crm;

import com.ceme.crm.repository.InteractionRepository;

import org.bson.types.ObjectId;

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