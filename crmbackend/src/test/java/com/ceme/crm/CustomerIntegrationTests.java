package com.ceme.crm;

import com.ceme.crm.controller.CustomerController;
import com.ceme.crm.entity.CustomerModel;
import com.ceme.crm.repository.CustomerRepository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.UUID;

// Using JUnit
@ContextConfiguration
@SpringBootTest(classes = CrmApplication.class, webEnvironment = WebEnvironment.RANDOM_PORT)
public class CustomerIntegrationTests {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private CustomerRepository customerRepository;
    // @MockBean
    // private CustomerRepository customerRepository;

    @Autowired
    CustomerController customerController;

    final String domain = "http://localhost:";
    final String path = "/api/customer";
    String uri;
    ResponseEntity<CustomerModel> responseEntityCustomer;

    @BeforeEach
    void initCustomer() {
        uri = domain + port + path;
        System.out.println("before each uri=" + uri);
        responseEntityCustomer = createNewCustomer(uri);
    }

    @Test
    public void addCustomer() throws Exception {
        assertEquals(200, responseEntityCustomer.getStatusCodeValue());
    }

    @Test
    public void deleteCustomer() {
        CustomerModel customer = responseEntityCustomer.getBody();
        this.restTemplate.delete(uri, customer.getId());
    }

    @Test
    public void updateCustomer() {
        CustomerModel customer = responseEntityCustomer.getBody();
        customer.setEmailAddress("me@here.com");
        this.restTemplate.put(uri, customer, CustomerModel.class);
    }

    private ResponseEntity<CustomerModel> createNewCustomer(String uri) {

        CustomerModel newCustomer = new CustomerModel(getGuid(), "Bond", "james.bond@mi6.uk");
        System.out.println("uri=" + uri);
        ResponseEntity<CustomerModel> responseEntity = this.restTemplate.postForEntity(uri, newCustomer,
                CustomerModel.class);
        return responseEntity;
    }

    private String getGuid() {
        UUID uuid = UUID.randomUUID();
        return uuid.toString();
    }

    @Test
    public void addCustomers() throws Exception {

        customerRepository.deleteAll();
        CustomerModel newCustomer;
        newCustomer = new CustomerModel("James", "Bond", "james.bond@mi6.uk");
        customerRepository.insert(newCustomer);

        newCustomer = new CustomerModel("Audie", "Murphy", "audie.murphy@ww2.com");
        customerRepository.insert(newCustomer);

        newCustomer = new CustomerModel("Ada", "Lovelace", "ada.lopvelace@oop.com");
        customerRepository.insert(newCustomer);

        newCustomer = new CustomerModel("Rogers", "Nelson", "Rogers.Nelsony@Paisley.com");
        customerRepository.insert(newCustomer);

    }

}