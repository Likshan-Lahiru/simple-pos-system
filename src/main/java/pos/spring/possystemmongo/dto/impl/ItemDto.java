package pos.spring.possystemmongo.dto.impl;

import lombok.*;
import pos.spring.possystemmongo.dto.SuperDto;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ItemDto implements SuperDto {
    private String itemId;
    private String description;
    private double unitPrice;
    private int quantity;
}
