package codingio.northwind.business.abstracts;

import codingio.northwind.core.utilities.results.DataResult;
import codingio.northwind.core.utilities.results.Result;
import codingio.northwind.entities.concretes.Product;
import codingio.northwind.entities.dtos.ProductWithCategoryDto;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductService {
    DataResult<List<Product>> getAll(); // dataresult başarılı olması durumunda list product dondurucek.
    DataResult<List<Product>> getAll(int pageNo, int pageSize);

    DataResult<List<Product>> getAllSorted();
    Result add(Product product);
    DataResult<Product> getByProductName(String productName); // jpa repo. bizim yerimize where kosulu yazıyor. getBy/findBy ile başlamak önemli
    DataResult<Product> getByProductNameAndCategoryCategoryId(String productName,int categoryId);
    DataResult<List<Product>> getByProductNameOrCategoryCategoryId(String productName, int categoryId);
    DataResult<List<Product>> getByCategoryCategoryIdIn(List<Integer> categories);
    DataResult<List<Product>> getByProductNameContains(String productName);
    DataResult<List<Product>> getByProductNameStartsWith(String productName);
    DataResult<List<Product>> getByNameAndCategoryCategoryId(String productName, int categoryId);
    DataResult<List<ProductWithCategoryDto>> getProductWithCategoryDetails();
}