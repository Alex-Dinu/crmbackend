package com.ceme.crm;

import com.ceme.crm.controller.CustomerController;
import com.ceme.crm.entity.CustomerModel;
import com.ceme.crm.repository.CustomerRepository;

import org.junit.jupiter.api.BeforeAll;

// import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

// import java.io.Console;
// import java.nio.charset.Charset;
// import java.util.Set;

// import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
// import org.junit.jupiter.params.ParameterizedTest;
// import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
// import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
// import org.springframework.data.web.JsonPath;
// import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;

// import org.springframework.test.context.junit4.SpringRunner;
// import org.springframework.test.web.servlet.MockMvc;
// import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
// import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
// import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.hamcrest.MatcherAssert.assertThat;

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

    // @Test
    // public void manualTest() {
    // CustomerModel newCustomer = new CustomerModel("James3", "Bond3",
    // "james3.bond3@mi6.uk");

    // ResponseEntity<CustomerModel> addedCustomer =
    // customerController.addCustomer(newCustomer);
    // assertTrue(addedCustomer.getBody().getId().length() > 0);

    // }

    // @Test
    // public void manualServiceTest() {
    // CustomerModel newCustomer = new CustomerModel("James3", "Bond3",
    // "james3.bond3@mi6.uk");

    // CustomerModel addedCustomer = customerRepository.insert(newCustomer);
    // assertTrue(addedCustomer.getId().length() > 0);

    // }
}