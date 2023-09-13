package codingio.northwind.api.controller;

import codingio.northwind.business.abstracts.ProductService;
import codingio.northwind.core.utilities.results.DataResult;
import codingio.northwind.core.utilities.results.Result;
import codingio.northwind.entities.concretes.Product;
import codingio.northwind.entities.dtos.ProductWithCategoryDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
// java olmayanlar da beni tanısın diye kullandık bunu, sen bir controllersın demek sınıfın ne yaptıgını belirttik yani
@RequestMapping("/api/products") // eger bana kodlama.io domainine kodlama.io/api/products gibi bir istek gelirse onu karşılayacak olan budur demek
@CrossOrigin
public class ProductsController {
    // apinin icinde controller sınıfı : istekte ne yapılacagına karar veriyor, bizim dıs dünyanın sistemimizle iletisim kurduğu yere controller denir
    // istekler 2 turludur : 1) veriyi bana ver 2) su veriyi degistir bunlara http (request)istekleri denir

    // @Autowired sadece bunu yazsan bile constructor yazmaya gerek yok ama biz fazladan servis de kullanabiliriz o yüzden hepsine yazman gerekir, yazmayalım şimdilik
    private ProductService productService; // apinin -> business ile iletişim kurması icin interface olan productService e ihtiyacımız var

    @Autowired
    // bana productService lazım diyor projeyi tarıyor, kim productService i implement etmiş? -> ProductManager. Spring arka planda ProductManager p= new ProductManager(); yapıp newlenmiş p yi bize gönderiyor, productService'e yerleştiriyor.Yani productManagerdaki getAll u kullanmak icin productService=p; oluyor ve onu alta getAll() ile cağırıyoruz
    public ProductsController(ProductService productService) {
        this.productService = productService;
    }


    @GetMapping("/getall")
    //işlevi:  kodlama.io/api/products/getall diye istekte bulunursam o zaman bu alttaki fonx çalışıcak
    public DataResult<List<Product>> getAll() {
        return this.productService.getAll();
    }

    @GetMapping("/getProductWithCategoryDetails")
    public DataResult<List<ProductWithCategoryDto>> getProductWithCategoryDetails() {
        return this.productService.getProductWithCategoryDetails();
    }

    @GetMapping("/getAllByPage")
    public DataResult<List<Product>> getAll(int pageNo, int pageSize){
        return this.productService.getAll(pageNo,pageSize);
    }
    @GetMapping("/getAllDesc")
    public DataResult<List<Product>> getAllSorted() {
        return this.productService.getAllSorted();
    }
    @PostMapping("/add")
    public Result add(@RequestBody Product product){ // RequestBody: Gelen verileri inceleyip kategoriye göre ayırır eşleştirir. id =10 isim =furkan gibi
        return this.productService.add(product);
    }

    @GetMapping("/getByProductName")
    public DataResult<Product> getByProductName(@RequestParam String productName){ // kullanıcıdan alınan istek(bilgi) ve bize bir productName gonderecek. productName i parametre olarak alıp okuması icin RequestParam kullanırız.
        return this.productService.getByProductName(productName);
    }

    @GetMapping("/getByProductNameAndCategoryId")
    public DataResult<Product> getByProductNameAndCategoryCategoryId(@RequestParam String productName, @RequestParam int categoryId){
        return this.productService.getByProductNameAndCategoryCategoryId(productName,categoryId);
    }

    @GetMapping("/getByProductNameOrCategoryId")
    public DataResult<List<Product>> getByProductNameOrCategoryCategoryId(@RequestParam("productName") String productName,@RequestParam("categoryId") int categoryId){ // yukarıdaki gibi de kullanılabilir böyle de. ("parantez içi olunca daha sağlıklı ama gerek de yok")
        return this.productService.getByProductNameOrCategoryCategoryId(productName,categoryId);
    }

    @GetMapping("/getByCategoryCategoryCategoryIdIn")
    public DataResult<List<Product>> getByCategoryCategoryCategoryIdIn(@RequestParam List<Integer> categories) {
        return this.productService.getByCategoryCategoryIdIn(categories);
    }
        @GetMapping("/getByProductNameContains")
    public DataResult<List<Product>> getByProductNameContains(@RequestParam String productName) {
        return this.productService.getByProductNameContains(productName);
    }

    @GetMapping("/getByProductNameStartsWith")
    public DataResult<List<Product>> getByProductNameStartsWith(@RequestParam String productName) {
        return this.productService.getByProductNameStartsWith(productName);
    }

    @GetMapping("/getByNameAndCategoryCategoryId")
    public DataResult<List<Product>> getByNameAndCategoryCategoryId(@RequestParam String productName, @RequestParam int categoryId) {
        return this.productService.getByNameAndCategoryCategoryId(productName,categoryId);
    }

    // validation : doğrulama , kullanıcıdan gelen verinin formata uygun olup olmadığını kontrol etme durumudur, validation
    // business rules : atıyorum sürücü kursundan ehliyet vereceksek, ilk yardımdan şunu almış mı, trafikten şunu almış mı diye yaptığımız şeyler iş kurallarıdır.




}

