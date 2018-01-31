package andrew.prog.userCart.model;



import javax.persistence.*;

@Entity
@Table(name = "PRODUCTS")
public class Product {
    @Id
    @SequenceGenerator (name = "PRODUCT_GEN")
    @GeneratedValue(generator = "PRODUCT_GEN")
    private Long id;
    private String name;
    private String description;
    private Double price;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    public Product () {
    }

    public Product (String name, String description, Double price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public void setCategory (Category category) {
        this.category = category;

    }
}
