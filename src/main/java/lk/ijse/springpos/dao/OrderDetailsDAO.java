package lk.ijse.springpos.dao;

import lk.ijse.springpos.entity.OrderDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDetailsDAO extends JpaRepository<OrderDetails,String> {

}
