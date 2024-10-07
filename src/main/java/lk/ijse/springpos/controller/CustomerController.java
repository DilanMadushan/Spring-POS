package lk.ijse.springpos.controller;

import lk.ijse.springpos.dto.CustomerDto;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/customer")
public class CustomerController {
    @PostMapping
    public CustomerDto getAllCustomer(@RequestBody CustomerDto customerDto){
        return customerDto;

    }
}
