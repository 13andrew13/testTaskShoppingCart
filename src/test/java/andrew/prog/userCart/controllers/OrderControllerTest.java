package andrew.prog.userCart.controllers;

import andrew.prog.userCart.model.Order;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.Assert.*;
import static org.mockito.BDDMockito.given;

@RunWith (SpringRunner.class)
@WebMvcTest(OrderController.class)
public class OrderControllerTest {
    @Autowired
    MockMvc mockMvc;
    @MockBean
    OrderController controller;
    @Test
    public void createOrder () throws Exception {
        Order order = new Order ();
        given(controller.createOrder ()).willReturn (order);
    }

    @Test
    public void addProduct () throws Exception {
    }

}