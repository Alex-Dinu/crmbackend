package com.ceme.crm.controller;

import java.util.List;

import com.ceme.crm.customExceptions.InteractionsNotFoundException;
import com.ceme.crm.entity.InteractionModel;
import com.ceme.crm.service.InteractionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/interaction") // set the root path.
@CrossOrigin // allows requests from all domains
public class InteractionController {
    @Autowired
    private InteractionService interactionService;

    @RequestMapping(method = RequestMethod.GET, value = "/{customerId}")
    public ResponseEntity<List<InteractionModel>> findByCustomerID(@PathVariable("customerId") String customerId) {
        try {
            List<InteractionModel> customerInteractions = interactionService.findInterationForCustomerId(customerId);
            return new ResponseEntity<List<InteractionModel>>(
                customerInteractions, HttpStatus.OK);
        } catch (InteractionsNotFoundException e) {
            return new ResponseEntity<List<InteractionModel>>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<List<InteractionModel>>(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<InteractionModel> insertInteraction(@RequestBody InteractionModel interaction) {
        try {
            InteractionModel addedInteraction = interactionService.insertInteraction(interaction);
            return new ResponseEntity<InteractionModel>(addedInteraction, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<InteractionModel>(HttpStatus.BAD_REQUEST);
        }

    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{interactionId}")
    public void deleteInteraction(@PathVariable("interactionId") String interactionId) {
        interactionService.deleteInteraction(interactionId);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<InteractionModel> updateInteraction(@RequestBody InteractionModel interaction) {
        try {
            InteractionModel updatedInteraction = interactionService.updateInteraction(interaction);
            return new ResponseEntity<InteractionModel>(updatedInteraction, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<InteractionModel>(HttpStatus.BAD_REQUEST);
        }
    }
}