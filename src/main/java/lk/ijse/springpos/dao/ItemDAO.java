package lk.ijse.springpos.dao;

import lk.ijse.springpos.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemDAO extends JpaRepository<Item,String> {
    @Query(value = "select itemId from item order by itemId desc limit 1",nativeQuery = true)
    String getLastIndex();
}
