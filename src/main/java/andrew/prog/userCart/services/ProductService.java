package andrew.prog.userCart.services;

import andrew.prog.userCart.model.Product;

public interface ProductService {
    Product findByName(String name);
    Product findById(Long id);

}
