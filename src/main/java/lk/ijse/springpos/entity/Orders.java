package lk.ijse.springpos.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "orders")
public class Orders {
    @Id
    private String orderId;
    private String date;
    private double total;
    @ManyToOne
    @JoinColumn(name = "cusId",nullable = false)
    private Customer customer;
    @OneToMany(mappedBy = "orders")
    private List<OrderDetails> items;
}
