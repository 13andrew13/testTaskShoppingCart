package andrew.prog.userCart.repositories;

import andrew.prog.userCart.model.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order, Long> {
}
