package pos.spring.possystemmongo.dto.impl;

import lombok.*;
import pos.spring.possystemmongo.dto.SuperDto;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class OrderDetailsDto implements SuperDto {
    private String orderDetailId;
    private String id;
    private String itemId;
    private double totalPrice;
    private int qty;
    private double unitPrice;
}
