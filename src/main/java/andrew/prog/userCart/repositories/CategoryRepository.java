package andrew.prog.userCart.repositories;

import andrew.prog.userCart.model.Category;
import andrew.prog.userCart.model.Product;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category,Long>{
    Product findCategoryByName(String name);
}
