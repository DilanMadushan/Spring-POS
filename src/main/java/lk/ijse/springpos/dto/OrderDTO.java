package lk.ijse.springpos.dto;

import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lk.ijse.springpos.entity.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderDTO {
    private String orderId;
    private String date;
    private double total;
    private String cusId;
    private List<ItemDTO> items;
}
