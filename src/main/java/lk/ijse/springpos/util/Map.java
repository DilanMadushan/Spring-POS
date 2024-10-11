package lk.ijse.springpos.util;

import lk.ijse.springpos.dto.CustomerDTO;
import lk.ijse.springpos.dto.ItemDTO;
import lk.ijse.springpos.dto.OrderDTO;
import lk.ijse.springpos.dto.UserDTO;
import lk.ijse.springpos.entity.*;
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

    public Orders toOrderEntity(OrderDTO orderDTO){
        return modelMapper.map(orderDTO, Orders.class);
    }

    public User toUserEntity(UserDTO userDTO){
        return modelMapper.map(userDTO, User.class);
    }

    public UserDTO toUserDto(User user){
        return modelMapper.map(user, UserDTO.class);
    }

}
