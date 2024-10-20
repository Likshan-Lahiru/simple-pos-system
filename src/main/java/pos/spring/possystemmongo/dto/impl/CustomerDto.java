package pos.spring.possystemmongo.dto.impl;

import lombok.*;
import pos.spring.possystemmongo.dto.SuperDto;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CustomerDto implements SuperDto {
    private String customerId;
    private String customerName;
    private String customerAddress;
    private String customerPhone;
}
