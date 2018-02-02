package andrew.prog.userCart.controllers;

import andrew.prog.userCart.model.Order;
import andrew.prog.userCart.services.OrderServcice;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class OrderControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private OrderServcice orderServcice;

    @Autowired
    private TestRestTemplate restTemplate;


    @Test
    public void createOrder () throws Exception {
        mockMvc.perform (get("/order/create"))
                .andExpect (status().isOk ()).andExpect (content ().contentType (MediaType.APPLICATION_JSON_UTF8));
    }


    @Test
    public void addProduct () throws Exception {
        ResponseEntity<Order> response = restTemplate.getForEntity ("/order/2/add/product/2/amount/2",Order.class);
        assertThat (response.getBody ().equals (orderServcice.getOrderById (2L)));
    }
    @Test
    public void updateAmountOfProducts () throws Exception {
        ResponseEntity<Order> response = restTemplate.getForEntity ("/order/2/update/product/2/amount/5",Order.class);
        assertThat (response.getBody ().equals (orderServcice.getOrderById (2L)));
    }

    @Test
    public void removeProduct () throws Exception {

            ResponseEntity<Order> response = restTemplate.getForEntity ("/order/2/remove/product/2",Order.class);
            assertThat (response.getBody ().equals (orderServcice.getOrderById (2L)));

    }


    @Test
    public void getOrder () throws Exception {
        ResponseEntity<Order> responseEntity = restTemplate.getForEntity ("/order/get/2",Order.class);
        assertThat (responseEntity.getBody ().equals (new Order ()));
    }

}