package lk.ijse.springpos.dao;

import lk.ijse.springpos.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDAO extends JpaRepository<Orders,String> {

}
