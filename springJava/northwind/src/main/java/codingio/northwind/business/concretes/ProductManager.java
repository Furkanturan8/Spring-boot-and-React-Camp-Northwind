package codingio.northwind.business.concretes;

import codingio.northwind.business.abstracts.ProductService;
import codingio.northwind.core.utilities.results.DataResult;
import codingio.northwind.core.utilities.results.Result;
import codingio.northwind.core.utilities.results.SuccessDataResult;
import codingio.northwind.core.utilities.results.SuccessResult;
import codingio.northwind.dataAccess.abstracts.ProductDao;
import codingio.northwind.entities.concretes.Product;
import codingio.northwind.entities.dtos.ProductWithCategoryDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import java.awt.print.Pageable;
import java.util.List;


@Service // bu class business katmanındaki business (service) görevi görecek
public class ProductManager implements ProductService {

    private ProductDao productDao;
    @Autowired
    // spring gidip arka planda buna karşılık gelebilcek productDao nun instance'ı olabilecek bir sınıfı üretip onu veriypr
    public ProductManager(ProductDao productDao) {
        this.productDao = productDao;
    }

    @Override
    public DataResult<List<Product>> getAll() {
        return new SuccessDataResult<List<Product>>
                (this.productDao.findAll(),"Data Listelendi");
    }

    @Override
    public DataResult<List<Product>> getAll(int pageNo, int pageSize) {
        org.springframework.data.domain.Pageable pageable = (org.springframework.data.domain.Pageable) PageRequest.of(pageNo - 1,pageSize); // pageNo-1 cünkü sayfalama 0 dan başlar
        return new SuccessDataResult<List<Product>>(this.productDao.findAll(pageable).getContent()); // findAll(int sayfa numarası, int sayfa sayısı) metodunu kullandık, datayı okumak icin de getContent kullandık
    }

    @Override
    public DataResult<List<Product>> getAllSorted() {
        Sort sort = Sort.by(Sort.Direction.DESC,"productName"); // DESC : (isimleri z->a ya doğru yani)listeyi azalan sıraya gore sıralar
        return new SuccessDataResult<List<Product>>(this.productDao.findAll(sort),"Başarılı");
    }

    @Override
    public Result add(Product product) {
        this.productDao.save(product);
        return new SuccessResult("Ürün Eklendi");
    }

    @Override
    public DataResult<Product> getByProductName(String productName) {
        return new SuccessDataResult<Product>
                (this.productDao.getByProductName(productName),"Data Listelendi");    }

    @Override
    public DataResult<Product> getByProductNameAndCategoryCategoryId(String productName, int categoryId) {
        return new SuccessDataResult<Product>
                (this.productDao.getByProductNameAndCategoryCategoryId(productName,categoryId),"Data Listelendi");    }

    @Override
    public DataResult<List<Product>> getByProductNameOrCategoryCategoryId(String productName, int categoryId) {
        return new SuccessDataResult<List<Product>>
                (this.productDao.getByProductNameOrCategoryCategoryId(productName,categoryId),"Data Listelendi");    }

    @Override
    public DataResult<List<Product>> getByCategoryCategoryIdIn(List<Integer> categories) {
        return new SuccessDataResult<List<Product>>
                (this.productDao.getByCategoryCategoryIdIn(categories),"Data Listelendi");    }


    @Override
    public DataResult<List<Product>> getByProductNameContains(String productName) {
        return new SuccessDataResult<List<Product>>
                (this.productDao.getByProductNameContains(productName),"Data Listelendi");    }


    @Override
    public DataResult<List<Product>> getByProductNameStartsWith(String productName) {
        return new SuccessDataResult<List<Product>>
                (this.productDao.getByProductNameStartsWith(productName),"Data Listelendi");    }


    @Override
    public DataResult<List<Product>> getByNameAndCategoryCategoryId(String productName, int categoryId) {
        return new SuccessDataResult<List<Product>>
                (this.productDao.getByNameAndCategoryCategoryId(productName,categoryId),"Data Listelendi");    }

    @Override
    public DataResult<List<ProductWithCategoryDto>> getProductWithCategoryDetails() {
        return new SuccessDataResult<List<ProductWithCategoryDto>>
                (this.productDao.getProductWithCategoryDetails(),"Data listelendi");
    }


}