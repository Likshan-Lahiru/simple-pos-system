package pos.spring.possystemmongo.dao;


import org.springframework.data.mongodb.repository.MongoRepository;
import pos.spring.possystemmongo.entity.impl.OrderDetailsEntity;


public interface OrderDetailsDao extends MongoRepository<OrderDetailsEntity, String> {

}
