package codingio.northwind.dataAccess.abstracts;

import codingio.northwind.entities.concretes.Product;
import codingio.northwind.entities.dtos.ProductWithCategoryDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;


public interface ProductDao extends JpaRepository<Product,Integer> { //entity = product , primary key = ınteger old. dolayı

    Product getByProductName(String productName); // jpa repo. bizim yerimize where kosulu yazıyor. getBy/findBy ile başlamak önemli
    Product getByProductNameAndCategoryCategoryId(String productName,int categoryId);
    List<Product> getByProductNameOrCategoryCategoryId(String productName, int categoryId);
    List<Product> getByCategoryCategoryIdIn(List<Integer> categories);
    List<Product> getByProductNameContains(String productName);
    List<Product> getByProductNameStartsWith(String productName);

    @Query("FROM Product WHERE productName=:productName AND category.categoryId=:categoryId") // from ile başlarsak hepsini getirir * gibi yani
    // dikkat bu sorgu sql gibi degil. Bu sorgu Product(Entity) sınıfındanki nesnelerle(categoryId ve productName) işlem yapar. Ayrıca =: "parametre"yi okumak icin (asagidaki parametreleri)kullanılır.
    List<Product> getByNameAndCategoryCategoryId(String productName, int categoryId);


    @Query("Select new codingio.northwind.entities.dtos.ProductWithCategoryDto"
            + "(p.id, p.productName, c.categoryName) "
            + "From Category c Inner Join c.products p")
    List<ProductWithCategoryDto> getProductWithCategoryDetails();
    // JPQL de bunlar asagidakine denk. Constructor ın ici pwithcDto sınıfının cons.ındaki nesneler
    // Select * from Category c inner join Product p  on c.categoryId = p.categoryId
    // Yıldız yerine --> Select p.productId, p.productName, c.categoryName from Category c inner join Product p  on c.categoryId = p.categoryId




}
