package andrew.prog.userCart.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "CATEGORIES")
public class Category implements Serializable {
    @Id
    @GeneratedValue(generator = "CATEGORY_GEN",strategy = GenerationType.SEQUENCE)
    @SequenceGenerator (name = "CATEGORY_GEN",sequenceName="CATEGORY_ID_SEQ", allocationSize=1)

    private Long id;
    private String name;
    private String description;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Product> products = new ArrayList<Product> ();

    public Category (String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Category () {
    }

    public void addProduct (Product product) {
        products.add (product);
        product.setCategory (this);
    }
}
