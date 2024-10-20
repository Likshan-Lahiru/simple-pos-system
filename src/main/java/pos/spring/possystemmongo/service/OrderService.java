package pos.spring.possystemmongo.service;



import pos.spring.possystemmongo.dto.impl.OrderDto;

import java.util.List;

public interface OrderService {
    String generateOrderID();

    void saveOrder(OrderDto orderDTO);

    List<OrderDto> getAllOrders();

    String orderCount();
}
