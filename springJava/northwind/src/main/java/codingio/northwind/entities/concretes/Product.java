package codingio.northwind.entities.concretes;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity // aslında bu: sen bir veritabanı nesnesisin demektir
@Table(name="products")
@Data // bize getter setter constructor gibi kullandığımız önemli dataları verir
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id // tablodaki id alanını belirttik cünkü bu primary key,sorgular buna gore yapılır
    @GeneratedValue(strategy = GenerationType.IDENTITY) // veritabanında id alanı otomatik arttırılıyor,bu ifade id nin 1er 1er arttırıldıgını ifade eder
    @Column(name="product_id") // bu alan veri tabanında column a denk geliyor
    private int id;

    // @Column(name="category_id")
    // private int categoryId;  AŞAĞIDA JOİN İLE KULLANDIGIMIZ ICIN BUNLARI YAPMAYA GEREK KALMADI
    @Column(name="product_name")
    private String productName;
    @Column(name="unit_price")
    private double unitPrice;
    @Column(name="units_in_stock")
    private short unitsInStock;
    @Column(name="quantity_per_unit")
    private String quantityPerUnit; //ürün açıklaması

    @ManyToOne()
    @JoinColumn(name="category_id") //product ın category_id si ile eşleşip join yapacak
    private Category category; // aslında product , category nin category_id sine mevcut olucak


}
