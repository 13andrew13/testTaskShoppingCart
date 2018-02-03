package andrew.prog.userCart.services;

import andrew.prog.userCart.exceptions.NoProductException;
import andrew.prog.userCart.model.Order;
import andrew.prog.userCart.model.Product;
import andrew.prog.userCart.model.ProductOrder;
import andrew.prog.userCart.repositories.ProductOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductOrderServiceImpl implements ProductOrderService{
    @Autowired
    ProductOrderRepository repository;
    @Autowired
    ProductService productService;

    public void remove(ProductOrder pr){
        repository.delete (pr);
    }

    public ProductOrder updateAmount(Long product_id, Long amount) throws NoProductException {
        ProductOrder pr = repository.findByProduct (productService.findById (product_id));
        pr.setAmount (amount);
        return repository.save (pr);
    }
}
