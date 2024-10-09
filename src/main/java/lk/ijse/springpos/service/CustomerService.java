package lk.ijse.springpos.service;

import jakarta.transaction.Transactional;
import lk.ijse.springpos.dao.CustomerDAO;
import lk.ijse.springpos.dto.CustomerDTO;
import lk.ijse.springpos.entity.Customer;
import lk.ijse.springpos.util.Conveter;
import lk.ijse.springpos.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
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

    public CustomerDTO saveCustomer(CustomerDTO customerDto){
        Customer save = customerDAO.save(map.toCustomerEntity(customerDto));
        if (save !=null){
            return map.toCustomerDto(save);
        }
        return null;
    }

    public CustomerDTO updateCustomer(String id, CustomerDTO customerDto) {
        Optional<Customer> byId = customerDAO.findById(id);

        if (byId.isPresent()) {
            Customer customer = byId.get();
            Customer updated = conveter.customerConvter(customer, customerDto);
            return map.toCustomerDto(updated);
        }
        return null;
    }

    public boolean deleteCustomer(String id) {
        if (customerDAO.existsById(id)) {
            customerDAO.deleteById(id);
            return true;
        }else{
            return false;
        }
    }

    public List<CustomerDTO> getAllCustomer() {
        List<Customer> all = customerDAO.findAll();
        List<CustomerDTO> customerDto = new ArrayList<>();

        for (Customer customer : all) {
            customerDto.add(map.toCustomerDto(customer));
        }
        return customerDto;
    }

    public CustomerDTO findCustomer(String id) {
        Optional<Customer> byId = customerDAO.findById(id);

        if (byId.isPresent()) {
            Customer customer = byId.get();
            return map.toCustomerDto(customer);
        }
        return null;
    }
}
