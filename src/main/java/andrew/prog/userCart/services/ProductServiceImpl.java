package andrew.prog.userCart.services;

import andrew.prog.userCart.model.Product;
import andrew.prog.userCart.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductRepository productRepository;

    @Override
    public Product findByName (String name) {
        return productRepository.findByName(name);
    }

    @Override
    public Product findById (Long id) {
        return productRepository.findOne (id);
    }

}
