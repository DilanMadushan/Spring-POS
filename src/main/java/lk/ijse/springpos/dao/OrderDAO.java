package lk.ijse.springpos.dao;

import lk.ijse.springpos.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDAO extends JpaRepository<Orders,String> {
    @Query(value = "select orderId from orders order by orderId desc limit 1",nativeQuery = true)
    String getLastIndex();

}
