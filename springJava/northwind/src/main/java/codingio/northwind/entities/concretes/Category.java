package codingio.northwind.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="categories")
@Entity // Sen Bir Veritabani Nesnesisin !
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","products"})
public class Category {
    @Id
    @Column(name="category_id")
    private int categoryId;
    @Column(name="category_name")
    private String categoryName;

    @OneToMany(mappedBy = "category")
    private List<Product> products; // category ile product nesneleri arasında one to many ilişkisi var


}
