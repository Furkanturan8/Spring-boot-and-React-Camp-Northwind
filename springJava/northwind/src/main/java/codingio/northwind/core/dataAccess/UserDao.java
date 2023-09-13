package codingio.northwind.core.dataAccess;

import codingio.northwind.core.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User,Integer> {

    // Kullanıcı ekleme hazır jpa repo'da
    User findByEmail(String email); // findBy da olabilir getBy da. Gostermek icin findBy yazdık, normalde hepsini aynı yazmak daha iyi
}
