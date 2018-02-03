package andrew.prog.userCart.services;

import andrew.prog.userCart.exceptions.NoProductException;
import andrew.prog.userCart.model.Product;

public interface ProductService {
    Product findByName(String name) throws NoProductException;
    Product findById(Long id) throws NoProductException;

}
