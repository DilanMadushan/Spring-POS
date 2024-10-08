package lk.ijse.springpos.util;

import lk.ijse.springpos.dto.CustomerDto;
import lk.ijse.springpos.entity.Customer;
import org.springframework.stereotype.Component;

@Component
public class Conveter {
    public Customer customerConvter(Customer customer, CustomerDto customerDto){
        customer.setName(customerDto.getName());
        customer.setAddress(customerDto.getAddress());
        customer.setTel(customerDto.getTel());
        return customer;
    }
}
