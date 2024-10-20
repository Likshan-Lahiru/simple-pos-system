package pos.spring.possystemmongo.dto.impl;

import lombok.*;
import pos.spring.possystemmongo.dto.SuperDto;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OrderDto implements SuperDto {
    private String id;
    private String date;
    private double discount_value;
    private double sub_total;
    private String customerId;
}
