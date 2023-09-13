package codingio.northwind.api.controller;

import codingio.northwind.business.abstracts.UserService;
import codingio.northwind.core.entities.User;
import codingio.northwind.core.utilities.results.ErrorDataResult;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value="/api/users")
public class UsersController {

    private UserService userService;

    @Autowired
    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(value="/add")
    public ResponseEntity<?> add(@Valid @RequestBody User user){ // Valid demek bunu validation dan geçir demek
        return ResponseEntity.ok(this.userService.add(user));  // buradaki hata/başarı gelebileceği için donuş tipini unknow "?" yaptık

    }// burada doğrulama hataları da olabilir o yüzden global bi hata yakalama yazacağız aşağıya
    //200 : apiden donen code --> get icin kullanılır (add icin 201)
    //300 :
    //400 : hata
    //500 : hata

    // AOP mantığı geliyor burada : biz bütün operasyonlarımızın geçeceği bir tane global exception handle yazacağız
    // dolayısıyla biz bütün operasyonlarımıza try catch yazmak yerine,bir tane try catch yazarız ve butun operasyonları oraya yollarız.
    // bunu da hazır şekilde spring boot ile karşımıza çıkıyor.

    @ExceptionHandler(MethodArgumentNotValidException.class) // bu sistemde şu türde hata olursa bu metodu devreye sok manasına gelir
    @ResponseStatus(HttpStatus.BAD_REQUEST) //bu metot default olarak bad request (500) hatası donsun
    public ErrorDataResult<Object> handleValidationException(MethodArgumentNotValidException exceptions){ // döneceği tip her şey olabilir o yüzden genel bir veri tipi olarak object yazıyoruz. her şeyin base i objectir.
        // Validation hatalarını listeye koyacağız--> hata formatı ne / neden olmadı şeklinde 2 yapıda olacak

        Map<String,String> validationErrors = new HashMap<String,String>(); // maplar diger dillerde dictionary diye geçer
        for(FieldError fieldError : exceptions.getBindingResult().getFieldErrors()){ // mesela Userda o hata alanların tümünü oku, list döndürüyor bu
            validationErrors.put(fieldError.getField(),fieldError.getDefaultMessage()); // yukarıda tanımladığımız mapa ekle
        }

        ErrorDataResult<Object> errors = new ErrorDataResult<Object>(validationErrors,"Doğrulama Hataları");
        // validationErrors'u bir ErrorDataResult'a çevirmem lazım yukarıda yaptım onu
        return errors;
    }

    // Maplar hakkında kısa bilgi : Map, Java Collections Framework ‘un bir üyesidir.
    // Map (gönderim) anahtarları değerlere eşleştiren bir nesnedir.
    // Örneğin, bir ad listesinde her ada bir sıra numarası vermek bir Map (gönderim) işlemidir.
    // Bu işlemde sıra numaralarının her biri bir anahtar, her ad bir değer olur.
}
