package andrew.prog.userCart.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "ORDERS")
public class Order {
    @Id
    @SequenceGenerator (name = "ORDER_GEN")
    @GeneratedValue(generator = "ORDER_GEN")
    private Long id;
    private Double cost;
    @OneToMany(fetch = FetchType.LAZY)
    private List<ProductOrder> productList = new ArrayList<ProductOrder> ();

    public Order () {
    }
    public void addProductOrder(ProductOrder productOrder){
        productList.add (productOrder);
        productOrder.setOrder (this);
    }
}
