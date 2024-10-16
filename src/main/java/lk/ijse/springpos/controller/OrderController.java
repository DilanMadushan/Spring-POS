package lk.ijse.springpos.controller;

import lk.ijse.springpos.dto.ItemDTO;
import lk.ijse.springpos.dto.OrderDTO;
import lk.ijse.springpos.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;


@CrossOrigin
@RestController
@RequestMapping("api/v1/order")
public class OrderController{
    @Autowired
    private OrderService orderService;

    @PostMapping(params = {"orderId","cusId","totalPrice"})
    public void placeOrder(
            @RequestBody List<ItemDTO> itemDTOS,
            @RequestParam("orderId")String orderId,
            @RequestParam("cusId")String cusId,
            @RequestParam("totalPrice")double totPrice
    ){
        OrderDTO orderDTO = new OrderDTO(
                orderId,
                LocalDate.now().toString(),
                totPrice,
                cusId,
                itemDTOS

        );

        orderService.placeOrder(orderDTO);
    }

    @GetMapping("/last")
    public String getLastIndex(){
        return orderService.getLastIndex();
    }
}
