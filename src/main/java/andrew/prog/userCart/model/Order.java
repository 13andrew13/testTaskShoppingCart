package andrew.prog.userCart.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "ORDERS")
public class Order implements Serializable{
    @Id
    @SequenceGenerator (name = "ORDER_GEN")
    @GeneratedValue(generator = "ORDER_GEN")
    private Long id;
    private Double cost;
    @OneToMany(cascade = CascadeType.ALL)
    private List<ProductOrder> productList = new ArrayList<ProductOrder> ();

    public Order () {
    }
    public void addProductOrder(ProductOrder productOrder){
        productList.add (productOrder);
        productOrder.setOrder (this);
    }

    public List<ProductOrder> getProductList () {
        return productList;
    }
    public Double getCost () {
        return cost;
    }

    public void setCost (Double cost) {
        this.cost = cost;
    }
}
