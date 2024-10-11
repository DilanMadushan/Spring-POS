package lk.ijse.springpos.dao;

import lk.ijse.springpos.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerDAO extends JpaRepository<Customer,String> {
    @Query(value = "select cusId from customer order by cusId desc limit 1",nativeQuery = true)
    String getLatIndex();
}
