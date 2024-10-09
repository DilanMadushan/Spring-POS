package lk.ijse.springpos.util;

import lk.ijse.springpos.dto.CustomerDTO;
import lk.ijse.springpos.dto.ItemDTO;
import lk.ijse.springpos.entity.Customer;
import lk.ijse.springpos.entity.Item;
import org.springframework.stereotype.Component;

@Component
public class Conveter {
    public Customer customerConvter(Customer customer, CustomerDTO customerDto){
        customer.setName(customerDto.getName());
        customer.setAddress(customerDto.getAddress());
        customer.setTel(customerDto.getTel());
        return customer;
    }

    public Item itemConvter(Item item, ItemDTO itemDTO){
        item.setName(itemDTO.getName());
        item.setPrice(itemDTO.getPrice());
        item.setQty(itemDTO.getQty());
        return item;
    }
}
