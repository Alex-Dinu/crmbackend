package com.ceme.crm.controller;

import java.util.List;

import com.ceme.crm.customExceptions.CustomerNotFoundException;
import com.ceme.crm.entity.CustomerModel;
import com.ceme.crm.service.CustomerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;

@RestController
@RequestMapping("/api/customer") // set the root path.
@CrossOrigin // allows requests from all domains
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @Operation(summary = "Get a customer by Id.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Customer was found.", content = {
                    @Content(mediaType = "application/json") }),
            @ApiResponse(responseCode = "400", description = "Bad Request", content = @Content),
            @ApiResponse(responseCode = "404", description = "Customer was not found.", content = @Content) })
    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public ResponseEntity<CustomerModel> getCustomerById(@PathVariable("id") String id) {
        try {
            return new ResponseEntity<CustomerModel>(customerService.getCustomerById(id), HttpStatus.OK);
        } catch (CustomerNotFoundException e) {
            return new ResponseEntity<CustomerModel>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<CustomerModel>(HttpStatus.BAD_REQUEST);
        }
    }

    @Operation(summary = "Get all customers.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Customers found.", content = {
                    @Content(mediaType = "application/json") }),
            @ApiResponse(responseCode = "400", description = "Bad Request", content = @Content) })
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<CustomerModel>> getCustomers() {
        try {
            return new ResponseEntity<List<CustomerModel>>(customerService.getCustomers(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<List<CustomerModel>>(HttpStatus.BAD_REQUEST);
        }
    }

    @Operation(summary = "Get all customers by email address filter.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Customers found.", content = {
                    @Content(mediaType = "application/json") }),
            @ApiResponse(responseCode = "400", description = "Bad Request", content = @Content) })
    @RequestMapping(value = { "/search", "/search/{searchBy}" }, method = RequestMethod.GET)
    public ResponseEntity<List<CustomerModel>> getCustomersByEmailAddress(
            @PathVariable(required = false) String searchBy) {
        try {
            String searchRegex = StringUtils.isEmpty(searchBy) ? "" : searchBy;
            return new ResponseEntity<List<CustomerModel>>(customerService.getCustomersByEmail(searchRegex),
                    HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e);
            return new ResponseEntity<List<CustomerModel>>(HttpStatus.BAD_REQUEST);
        }
    }



    @Operation(summary = "Add new customer.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Customer successfully added.", content = {
                    @Content(mediaType = "application/json") }),
            @ApiResponse(responseCode = "400", description = "Bad Request", content = @Content), })
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<CustomerModel> addCustomer(@RequestBody CustomerModel newCustomer) {
        try {
            CustomerModel addedCustomer = customerService.addCustomer(newCustomer);
            return new ResponseEntity<CustomerModel>(addedCustomer, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<CustomerModel>(HttpStatus.BAD_REQUEST);
        }

    }

    @Operation(summary = "Delete customer by id.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Customer successfully deleted.", content = @Content),
            @ApiResponse(responseCode = "400", description = "Bad Request", content = @Content), })
    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public void removeCustomer(@PathVariable("id") String id) {
        customerService.deleteCustomer(id);
    }

    @Operation(summary = "Update customer.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Customer successfully Updated.", content = {
                    @Content(mediaType = "application/json") }),
            @ApiResponse(responseCode = "400", description = "Bad Request", content = @Content), })
    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<CustomerModel> updateCustomer(@RequestBody CustomerModel customer) {
        try {
            CustomerModel updatedCustomer = customerService.updateCustomer(customer);
            return new ResponseEntity<CustomerModel>(updatedCustomer, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<CustomerModel>(HttpStatus.BAD_REQUEST);
        }

    }

}