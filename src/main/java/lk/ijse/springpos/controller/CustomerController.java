package lk.ijse.springpos.controller;

import lk.ijse.springpos.dto.CustomerDto;
import lk.ijse.springpos.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;
    @PostMapping
    public ResponseEntity<?> getAllSave(@RequestBody CustomerDto customerDto){
        customerService.saveCustomer(customerDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PatchMapping(value = "{id}")
    public ResponseEntity<?> updateCustomer(@PathVariable("id") String id , @RequestBody CustomerDto customerDto){
        customerService.updateCustomer(id,customerDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<?> deleteCustomer(@PathVariable("id") String id){
        customerService.deleteCustomer(id);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping
    public List<CustomerDto> getAllCustomers(){
        return customerService.getAllCustomer();
    }

    @GetMapping(value = "{id}")
    public CustomerDto findCustomer(@PathVariable("id") String id){
        return customerService.findCustomer(id);
    }
}
