package pl.coderslab.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.entity.User;

public interface UserDao extends JpaRepository<User, Long> {

}
