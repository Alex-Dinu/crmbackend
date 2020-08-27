package com.ceme.crm;

import com.ceme.crm.controller.CustomerController;
import com.ceme.crm.entity.CustomerModel;
import com.ceme.crm.repository.CustomerRepository;

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

// Using JUnit
@ContextConfiguration
@SpringBootTest(classes = CrmApplication.class, webEnvironment = WebEnvironment.RANDOM_PORT)
public class CustomerIntegrationTests {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @MockBean
    private CustomerRepository customerRepository;

    @Autowired
    CustomerController customerController;

    final String domain = "http://localhost:";
    final String path = "/api/customer";

    @Test
    public void addCustomer() throws Exception {
        String uri = domain + port + path;
        CustomerModel newCustomer = new CustomerModel("James5", "Bond5", "james5.bond5@mi6.uk");
        System.out.println("uri=" + uri);
        ResponseEntity<CustomerModel> responseEntity = this.restTemplate.postForEntity(uri, newCustomer,
                CustomerModel.class);
        assertEquals(200, responseEntity.getStatusCodeValue());

    }

}