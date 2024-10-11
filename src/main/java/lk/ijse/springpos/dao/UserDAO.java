package lk.ijse.springpos.dao;

import lk.ijse.springpos.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDAO extends JpaRepository<User,String> {
}
