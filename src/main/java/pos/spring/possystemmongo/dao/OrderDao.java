package pos.spring.possystemmongo.dao;


import org.springframework.data.mongodb.repository.MongoRepository;
import pos.spring.possystemmongo.entity.impl.OrderEntity;


public interface OrderDao extends MongoRepository<OrderEntity, String> {
}
