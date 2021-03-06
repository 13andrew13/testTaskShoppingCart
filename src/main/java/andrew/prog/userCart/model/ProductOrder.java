package andrew.prog.userCart.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "PRODUCT_ORDER")
public class ProductOrder implements Serializable {
    @Id
    @GeneratedValue(generator = "PROD_ORD_GEN",strategy = GenerationType.SEQUENCE)
    @SequenceGenerator (name = "PROD_ORD_GEN",sequenceName="PROD_ORD_ID_SEQ", allocationSize=1)

    private Long id;
    private Long amount;
    @OneToOne
    private Product product;
    @JsonIgnore
    @ManyToOne
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

    public ProductOrder (Long amount, Product product) {
        this.amount = amount;
        this.product = product;

    }

    public Long getAmount () {
        return amount;
    }

    public Product getProduct () {
        return product;
    }

    public Order getOrder () {
        return order;
    }

    public Long getId () {
        return id;
    }
}
