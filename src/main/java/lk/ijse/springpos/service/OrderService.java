package lk.ijse.springpos.service;

import jakarta.transaction.Transactional;
import lk.ijse.springpos.dao.CustomerDAO;
import lk.ijse.springpos.dao.ItemDAO;
import lk.ijse.springpos.dao.OrderDAO;
import lk.ijse.springpos.dao.OrderDetailsDAO;
import lk.ijse.springpos.dto.ItemDTO;
import lk.ijse.springpos.dto.OrderDTO;
import lk.ijse.springpos.entity.Customer;
import lk.ijse.springpos.entity.Item;
import lk.ijse.springpos.entity.OrderDetails;
import lk.ijse.springpos.entity.Orders;
import lk.ijse.springpos.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Optional;
import java.util.UUID;

@Service
@Transactional
public class OrderService {
    @Autowired
    Map map;
    @Autowired
    private OrderDAO orderDAO;
    @Autowired
    private OrderDetailsDAO orderDetailsDAO;
    @Autowired
    private CustomerDAO  customerDAO;
    @Autowired
    private ItemDAO itemDAO;

     private static Logger logger = LoggerFactory.getLogger("OrderService");
    public void placeOrder(OrderDTO orderDTO){
        try {

//            ----------------------- Save Order -----------------------

            Orders orderEntity = map.toOrderEntity(orderDTO);

            Optional<Customer> byId = customerDAO.findById(orderDTO.getCusId());
            if (byId.isPresent()){
                orderEntity.setCustomer(byId.get());
            }
            orderDAO.save(orderEntity);


            for (ItemDTO item : orderDTO.getItems()) {
                OrderDetails orderDetails = new OrderDetails();
                orderDetails.setDetailId("OD"+UUID.randomUUID().toString());
                orderDetails.setOrders(orderEntity);
                orderDetails.setItems(map.toItemEntity(item));
                orderDetails.setQty(item.getQty());
                orderDetails.setPrice(item.getPrice());

//               ----------------------- Save OrderDetails -----------------------

                orderDetailsDAO.save(orderDetails);

//                ----------------------- Update Item QTY -----------------------

                Optional<Item> pro = itemDAO.findById(item.getItemId());

                if (pro.isPresent()) {
                    Item items = pro.get();
                    items.setQty(items.getQty() - item.getQty());
                    logger.info("Order Placed Successfully");
                }
            }



        }catch (Exception e){
            e.printStackTrace();
            logger.error(e.getMessage());
        }

    }

    public String getLastIndex() {
        return orderDAO.getLastIndex();
    }
}
