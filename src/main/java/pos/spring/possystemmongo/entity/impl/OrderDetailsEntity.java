package pos.spring.possystemmongo.entity.impl;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Document(collection = "orderDetails")
public class OrderDetailsEntity {

    @Id

    private String orderId;


    @DBRef
    private ItemEntity item;

    @DBRef
    private OrderEntity order;

    private String qty;
    private String unitPrice;
    private String totalPrice;
}
