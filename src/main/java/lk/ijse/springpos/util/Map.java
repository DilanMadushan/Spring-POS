package lk.ijse.springpos.util;

import lk.ijse.springpos.dto.CustomerDto;
import lk.ijse.springpos.entity.Customer;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Map {
    @Autowired
    private ModelMapper modelMapper;
    public CustomerDto toCustomerDto(Customer customer){
        return modelMapper.map(customer, CustomerDto.class);
    }

    public Customer toCustomerEntity(CustomerDto customerDto){
        return modelMapper.map(customerDto, Customer.class);
    }
}
