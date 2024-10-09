package lk.ijse.springpos.util;

import lk.ijse.springpos.dto.CustomerDTO;
import lk.ijse.springpos.dto.ItemDTO;
import lk.ijse.springpos.entity.Customer;
import lk.ijse.springpos.entity.Item;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Map {
    @Autowired
    private ModelMapper modelMapper;
    public CustomerDTO toCustomerDto(Customer customer){
        return modelMapper.map(customer, CustomerDTO.class);
    }

    public Customer toCustomerEntity(CustomerDTO customerDto){
        return modelMapper.map(customerDto, Customer.class);
    }

    public Item toItemEntity(ItemDTO itemDTO){
        return modelMapper.map(itemDTO, Item.class);
    }

    public ItemDTO toItemDTO(Item item){
        return modelMapper.map(item, ItemDTO.class);
    }
}
