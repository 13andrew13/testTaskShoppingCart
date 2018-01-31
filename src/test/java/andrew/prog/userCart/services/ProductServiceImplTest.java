package andrew.prog.userCart.services;

import andrew.prog.userCart.repositories.ProductRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
@RunWith (SpringRunner.class)
@SpringBootTest
public class ProductServiceImplTest {
    @Autowired
    ProductRepository productRepository;
    @Test
    public void findByName () throws Exception {
        assertNotNull (productRepository.findByName ("Phone1"));
    }

}