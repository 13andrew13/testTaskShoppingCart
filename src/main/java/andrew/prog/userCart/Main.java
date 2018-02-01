package andrew.prog.userCart;

import andrew.prog.userCart.model.Category;
import andrew.prog.userCart.model.Product;
import andrew.prog.userCart.repositories.CategoryRepository;
import andrew.prog.userCart.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("andrew.prog.userCart")
public class Main {
    public static void main (String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run (Main.class,args);
        context.getBean (Main.class).run ();
    }
    @Autowired
    CategoryRepository categoryRepository;
    public void run(){
        Product p1 = new Product ("Phone1","Mobile phones",12.3);
        Product p2 = new Product ("Phone2","Mobile phones",12.3);
        Product p3 = new Product ("Phone3","Mobile phones",12.3);
        Category category = new Category ("Phones","Mobile Phones");
        category.addProduct (p1);
        category.addProduct (p2);
        category.addProduct (p3);
        categoryRepository.save (category);
    }
}
