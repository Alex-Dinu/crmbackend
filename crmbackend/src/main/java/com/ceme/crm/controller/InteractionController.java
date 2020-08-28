package com.ceme.crm.controller;

import com.ceme.crm.customExceptions.CustomerNotFoundException;
import com.ceme.crm.customExceptions.InteractionNotFoundException;
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
@RequestMapping("/api/interaction")// set the root path.
@CrossOrigin // allows requests from all domains
public class InteractionController {
    @Autowired
    private InteractionService interactionService;    
    @RequestMapping(method = RequestMethod.GET, value = "/{customerId}")
    public ResponseEntity<InteractionModel> getUserId(@PathVariable("customerId") String userId) {
        try {
            return new ResponseEntity<InteractionModel>(interactionService.getUserId(userId), HttpStatus.OK);
        } catch (InteractionNotFoundException e) {
            return new ResponseEntity<InteractionModel>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<InteractionModel>(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<InteractionModel> addComments(@RequestBody InteractionModel newComments) {
        try {
            InteractionModel addedComments = interactionService.addComments(newComments);
            return new ResponseEntity<InteractionModel>(addedComments, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<InteractionModel>(HttpStatus.BAD_REQUEST);
        }

    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{userId}")
    public void removeComments(@PathVariable("userId") String userId){
        interactionService.deleteComments(userId);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<InteractionModel> updateCustomer(@RequestBody InteractionModel comments) {
        try {
            InteractionModel updatedComments = interactionService.updateComments(comments);
            return new ResponseEntity<InteractionModel>(updatedComments, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<InteractionModel>(HttpStatus.BAD_REQUEST);
        }
    }
}