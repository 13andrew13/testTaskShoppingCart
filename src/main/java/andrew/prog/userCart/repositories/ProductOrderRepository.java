package andrew.prog.userCart.repositories;

import andrew.prog.userCart.model.Product;
import andrew.prog.userCart.model.ProductOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductOrderRepository extends CrudRepository<ProductOrder,Long> {
    public ProductOrder findByProduct (Product product);

}
