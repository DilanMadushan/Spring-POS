package lk.ijse.springpos.dao;

import lk.ijse.springpos.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemDAO extends JpaRepository<Item,String> {
}
