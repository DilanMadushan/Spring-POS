package lk.ijse.springpos.entity;

import jakarta.persistence.*;
import jdk.jfr.Name;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "OrderDetails")
public class OrderDetails {
    @Id
    private String detailId;
    @ManyToOne
    @JoinColumn(name = "orderId")
    private Orders orders;
    @ManyToOne
    @JoinColumn(name = "itemId")
    private Item items;
    private double qty;
    private double price;

}
