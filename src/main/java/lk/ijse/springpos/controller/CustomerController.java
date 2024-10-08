package lk.ijse.springpos.controller;

import lk.ijse.springpos.dto.CustomerDto;
import lk.ijse.springpos.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;
    @PostMapping
    public CustomerDto getAllSave(@RequestBody CustomerDto customerDto){
        return customerService.saveCustomer(customerDto);
    }

    @PatchMapping(value = "{id}")
    public CustomerDto updateCustomer(@PathVariable("id") String id , @RequestBody CustomerDto customerDto){
        return customerService.updateCustomer(id,customerDto);
    }

    @DeleteMapping(value = "{id}")
    public boolean deleteCustomer(@PathVariable("id") String id){
        return customerService.deleteCustomer(id);
    }
}
