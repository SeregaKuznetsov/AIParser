package repository;

import model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by admin on 10.04.2017.
 */
public interface UserRepository extends JpaRepository<User, Long> {
    User findOneByEmail(String email);
    List<User> findAll();
}
