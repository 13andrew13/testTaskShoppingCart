package andrew.prog.userCart.repositories;

import andrew.prog.userCart.model.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category,Long>{
}
