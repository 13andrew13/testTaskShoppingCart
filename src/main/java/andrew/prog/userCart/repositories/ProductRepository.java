package andrew.prog.userCart.repositories;

import andrew.prog.userCart.model.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product,Long>{
    Product findByName(String name);
}
