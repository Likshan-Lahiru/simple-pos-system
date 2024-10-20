package pos.spring.possystemmongo.entity.impl;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Document(collection = "orders")
public class OrderEntity {
    @Id
    private String id;
    private String date;
    private double discount_value;
    private double sub_total;

    @DBRef
    private CustomerEntity customer;

    @DBRef
    private List<OrderDetailsEntity> orderDetails;
}
