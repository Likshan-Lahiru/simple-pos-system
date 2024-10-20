package pos.spring.possystemmongo.entity.impl;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Document(collection = "item")
public class ItemEntity {
    @Id
    private String itemId;
    private String description;
    private double unitPrice;
    private int quantity;

    @DBRef
    private List<OrderDetailsEntity> orderDetail;
}
