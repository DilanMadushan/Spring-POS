package lk.ijse.springpos.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "item")
public class Item {
    @Id
    private String itemId;
    private String name;
    private double price;
    private double qty;
    @OneToMany(mappedBy = "items")
    private List<OrderDetails> orderDetails;
}
