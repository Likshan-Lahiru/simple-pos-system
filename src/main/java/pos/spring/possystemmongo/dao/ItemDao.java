package pos.spring.possystemmongo.dao;


import org.springframework.data.mongodb.repository.MongoRepository;
import pos.spring.possystemmongo.entity.impl.ItemEntity;


public interface ItemDao extends MongoRepository<ItemEntity, String> {
}
