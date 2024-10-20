package pos.spring.possystemmongo.util;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pos.spring.possystemmongo.dto.impl.CustomerDto;
import pos.spring.possystemmongo.dto.impl.ItemDto;
import pos.spring.possystemmongo.dto.impl.OrderDetailsDto;
import pos.spring.possystemmongo.dto.impl.OrderDto;
import pos.spring.possystemmongo.entity.impl.CustomerEntity;
import pos.spring.possystemmongo.entity.impl.ItemEntity;
import pos.spring.possystemmongo.entity.impl.OrderDetailsEntity;
import pos.spring.possystemmongo.entity.impl.OrderEntity;


import java.util.List;

@Component
public class Mapping {
    @Autowired
    private ModelMapper modelMapper;

    public CustomerEntity customerEntity(CustomerDto customerDto){
        return modelMapper.map(customerDto, CustomerEntity.class);
    }
    public List<CustomerDto> customerDtoList(List<CustomerEntity> customerEntityList){
        return modelMapper.map(customerEntityList, new TypeToken<List<CustomerDto>>() {}.getType());

    }
    public List<ItemDto> itemDtoList(List<ItemEntity> itemEntityList){
        return modelMapper.map(itemEntityList, new TypeToken<List<ItemDto>>() {}.getType());
    }
    public CustomerDto customerDto(CustomerEntity customerEntity){
        return modelMapper.map(customerEntity, CustomerDto.class);
    }
    public ItemEntity itemEntity(ItemDto itemDto){
        return modelMapper.map(itemDto, ItemEntity.class);
    }
    public ItemDto itemDto(ItemEntity itemEntity){
        return modelMapper.map(itemEntity, ItemDto.class);
    }

    public OrderEntity toOrderEntity(OrderDto orderDTO) {
        return modelMapper.map(orderDTO, OrderEntity.class);
    }

    public OrderDto toOrderDTO(OrderEntity placeOrder) {
        return modelMapper.map(placeOrder, OrderDto.class);
    }

    public OrderDetailsEntity toOrderDetailEntity(OrderDetailsDto orderDetailsDTO) {
        return modelMapper.map(orderDetailsDTO, OrderDetailsEntity.class);
    }

    public List<OrderDetailsDto> toOrderDetailsDtoList(List<OrderDetailsEntity> orderDetails) {
        return modelMapper.map(orderDetails, new TypeToken<List<OrderDetailsDto>>() {}.getType());
    }
}
