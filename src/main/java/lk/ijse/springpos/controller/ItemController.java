package lk.ijse.springpos.controller;

import lk.ijse.springpos.dto.ItemDTO;
import lk.ijse.springpos.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/item")
public class ItemController {
    @Autowired
    private ItemService itemService;
    @GetMapping
    public List<ItemDTO> getAllItem(){
        return itemService.getAllItems();
    }

    @PostMapping
    public ResponseEntity<?> saveItem(@RequestBody ItemDTO itemDTO){
        itemService.saveItem(itemDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PatchMapping(value = "{id}")
    public ResponseEntity<?> updateItem(@PathVariable("id") String id,@RequestBody ItemDTO itemDTO){
        itemService.updateItem(id,itemDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<?> deleteItem(@PathVariable("id") String id){
        itemService.deleteItem(id);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
