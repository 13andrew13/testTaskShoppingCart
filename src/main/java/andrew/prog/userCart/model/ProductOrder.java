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
}
