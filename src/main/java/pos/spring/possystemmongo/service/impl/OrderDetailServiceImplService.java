package pos.spring.possystemmongo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pos.spring.possystemmongo.dao.ItemDao;
import pos.spring.possystemmongo.dao.OrderDao;
import pos.spring.possystemmongo.dao.OrderDetailsDao;
import pos.spring.possystemmongo.dto.impl.OrderDetailsDto;
import pos.spring.possystemmongo.entity.impl.ItemEntity;
import pos.spring.possystemmongo.entity.impl.OrderDetailsEntity;
import pos.spring.possystemmongo.entity.impl.OrderEntity;
import pos.spring.possystemmongo.exception.DataPersistException;
import pos.spring.possystemmongo.service.OrderDetailsService;
import pos.spring.possystemmongo.util.Mapping;

import java.util.List;

@Service
public class OrderDetailServiceImplService implements OrderDetailsService {

    @Autowired
    private Mapping mapper;

    @Autowired
    private OrderDao orderDao;

    @Autowired
    private ItemDao itemDao;

    @Autowired
    private OrderDetailsDao orderDetailsDao;

    @Override
    public void saveOrderDetail(OrderDetailsDto orderDetailsDTO) {

        OrderDetailsEntity orderDetail = mapper.toOrderDetailEntity(orderDetailsDTO);


        OrderEntity selectedOrder = orderDao.findById(orderDetailsDTO.getId())
                .orElseThrow(() -> new DataPersistException("Order not found"));

        ItemEntity selectedItem = itemDao.findById(orderDetailsDTO.getItemId())
                .orElseThrow(() -> new DataPersistException("Item not found"));


        orderDetail.setOrder(selectedOrder);
        orderDetail.setItem(selectedItem);


        OrderDetailsEntity savedOrderDetail = orderDetailsDao.save(orderDetail);


        String itemId = orderDetailsDTO.getItemId();
        int qty = orderDetailsDTO.getQty();

        ItemEntity fetchItem = itemDao.findById(itemId)
                .orElseThrow(() -> new DataPersistException("Item not found"));

        fetchItem.setQuantity(fetchItem.getQuantity() - qty);
        ItemEntity savedItem = itemDao.save(fetchItem);


        if (savedOrderDetail == null || savedItem == null) {
            throw new DataPersistException("Failed to save order detail or item");
        }
    }

    @Override
    public List<OrderDetailsDto> getOrderDetails(String orderId) {

        List<OrderDetailsEntity> orderDetails = orderDetailsDao.findAll();
        return mapper.toOrderDetailsDtoList(orderDetails);
    }
}
