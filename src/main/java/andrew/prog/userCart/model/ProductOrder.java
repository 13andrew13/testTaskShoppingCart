package andrew.prog.userCart.model;

import javax.persistence.*;

@Entity
@Table(name = "PRODUCT_ORDER")
public class ProductOrder {
    @Id
    @GeneratedValue(generator = "PROD_ORD_GEN")
    @SequenceGenerator (name = "PROD_ORD_GEN")
    private Long id;
    private Long amount;
    @OneToOne
    private Product product;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "order_id")
    private Order order;

    public ProductOrder () {
    }

    public void setAmount (Long amount) {
        this.amount = amount;
    }

    public void setProduct (Product product) {
        this.product = product;
    }

    public void setOrder (Order order) {
        this.order = order;
    }

    public ProductOrder (Long amount, Product product, Order order) {
        this.amount = amount;
        this.product = product;
        this.order = order;
    }
}
