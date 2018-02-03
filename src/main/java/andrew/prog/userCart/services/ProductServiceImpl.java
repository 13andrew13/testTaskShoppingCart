package andrew.prog.userCart.services;

import andrew.prog.userCart.exceptions.NoProductException;
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
    public Product findByName (String name) throws NoProductException {

        try {
            return productRepository.findByName(name);
        }catch (NullPointerException ex){
            throw new NoProductException ("There is no product like this");
        }
    }

    @Override
    public Product findById (Long id) throws NoProductException {
        try {
            return productRepository.findOne (id);
        }catch (NullPointerException ex){
            throw new NoProductException ("There is no product like this");
        }
    }

}
