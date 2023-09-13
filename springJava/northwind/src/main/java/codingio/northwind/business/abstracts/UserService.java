package codingio.northwind.business.abstracts;

import codingio.northwind.core.entities.User;
import codingio.northwind.core.utilities.results.DataResult;
import codingio.northwind.core.utilities.results.Result;
import codingio.northwind.entities.concretes.Product;

public interface UserService {
    Result add(User user); // kullanıcı ekleme
    DataResult<User> findByEmail(String email); // ProductService deki ile aynı mantık
}
