package pos.spring.possystemmongo.service;



import pos.spring.possystemmongo.dto.impl.OrderDetailsDto;

import java.util.List;

public interface OrderDetailsService {
    void saveOrderDetail(OrderDetailsDto orderDetailsDTO);
    List<OrderDetailsDto> getOrderDetails(String orderId);
}
