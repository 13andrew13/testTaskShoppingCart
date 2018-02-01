package andrew.prog.userCart.services;

import andrew.prog.userCart.model.Order;
import andrew.prog.userCart.repositories.ProductOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductOrderServiceImpl implements ProductOrderService{
    @Autowired
    ProductOrderRepository repository;
}
