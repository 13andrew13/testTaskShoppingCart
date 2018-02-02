package andrew.prog.userCart.model;



import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "PRODUCTS")
public class Product implements Serializable {
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

    public String getName () {
        return name;
    }

    public String getDescription () {
        return description;
    }

    public Double getPrice () {
        return price;
    }

    public Long getId () {
        return id;
    }

    public Category getCategory () {
        return category;
    }
}
