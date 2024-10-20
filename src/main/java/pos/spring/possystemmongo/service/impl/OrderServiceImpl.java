package pos.spring.possystemmongo.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import pos.spring.possystemmongo.dao.CustomerDao;
import pos.spring.possystemmongo.dao.OrderDao;
import pos.spring.possystemmongo.dto.impl.OrderDto;
import pos.spring.possystemmongo.entity.impl.OrderEntity;
import pos.spring.possystemmongo.service.OrderService;
import pos.spring.possystemmongo.util.Mapping;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import pos.spring.possystemmongo.entity.impl.CustomerEntity;
import pos.spring.possystemmongo.exception.DataPersistException;
@Service
public class OrderServiceImpl implements OrderService {


    @Autowired
    private OrderDao orderDao;

    @Autowired
    private CustomerDao customerDao;

    @Autowired
    private Mapping mapper;
    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public String generateOrderID() {

        Query query = new Query();
        query.with(Sort.by(Sort.Order.desc("id")));
        query.limit(1);


        OrderEntity lastOrderId = mongoTemplate.findOne(query, OrderEntity.class);


        if (lastOrderId != null) {
            String lastOrderIdId = lastOrderId.getId();
            int generatedOrderId = Integer.parseInt(lastOrderIdId.replace("O00-", "")) + 1;
            return String.format("O00-%03d", generatedOrderId);
        } else {
            return "O00-001";
        }
    }

    @Override
    public void saveOrder(OrderDto orderDTO) {
        Optional<CustomerEntity> customer = customerDao.findById(orderDTO.getCustomerId());
        OrderEntity order = mapper.toOrderEntity(orderDTO);
        order.setId(generateOrderID());
        order.setCustomer(customer.get());
        OrderEntity save = orderDao.save(order);
        if (save == null) {
            throw new DataPersistException();
        }
    }
    @Override
    public List<OrderDto> getAllOrders() {
        Iterable<OrderEntity> all = orderDao.findAll();
        List<OrderDto> placeOrderDto = new ArrayList<>();

        all.forEach(placeOrder -> {
            placeOrderDto.add(mapper.toOrderDTO(placeOrder));
        });
        return placeOrderDto;
    }

    @Override
    public String orderCount() {
        long count = mongoTemplate.count(new Query(), OrderEntity.class);
        return String.valueOf(count);
    }
}
