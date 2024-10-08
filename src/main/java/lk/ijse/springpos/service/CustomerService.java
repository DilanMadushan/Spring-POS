package lk.ijse.springpos.service;

import jakarta.transaction.Transactional;
import lk.ijse.springpos.dao.CustomerDAO;
import lk.ijse.springpos.dto.CustomerDto;
import lk.ijse.springpos.entity.Customer;
import lk.ijse.springpos.util.Conveter;
import lk.ijse.springpos.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Transactional
public class CustomerService {
    @Autowired
    private Map map;
    @Autowired
    private CustomerDAO customerDAO;
    @Autowired
    private Conveter conveter;

    public CustomerDto saveCustomer(CustomerDto customerDto){
        Customer save = customerDAO.save(map.toCustomerEntity(customerDto));
        if (save !=null){
            return map.toCustomerDto(save);
        }
        return null;
    }

    public CustomerDto updateCustomer(String id, CustomerDto customerDto) {
        Optional<Customer> byId = customerDAO.findById(id);

        if (byId.isPresent()) {
            Customer customer = byId.get();
            Customer updated = conveter.customerConvter(customer, customerDto);
            return map.toCustomerDto(updated);
        }
        return null;
    }
}
