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
@Document(collection = "customer")
public class CustomerEntity {
    @Id
    private String customerId;
    private String customerName;
    private String customerAddress;
    private String customerPhone;

    @DBRef
    private List<OrderEntity> orders;
}
