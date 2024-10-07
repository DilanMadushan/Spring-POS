package lk.ijse.springpos.service;

import jakarta.transaction.Transactional;
import lk.ijse.springpos.dao.CustomerDAO;
import lk.ijse.springpos.dto.CustomerDto;
import lk.ijse.springpos.entity.Customer;
import lk.ijse.springpos.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class CustomerService {
    @Autowired
    private Map map;
    @Autowired
    CustomerDAO customerDAO;

    public CustomerDto saveCustomer(CustomerDto customerDto){
        Customer save = customerDAO.save(map.toCustomerEntity(customerDto));
        if (save !=null){
            return map.toCustomerDto(save);
        }
        return null;
    }
}
