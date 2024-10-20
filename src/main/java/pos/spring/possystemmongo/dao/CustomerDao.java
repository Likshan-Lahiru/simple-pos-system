package pos.spring.possystemmongo.dao;


import pos.spring.possystemmongo.entity.impl.CustomerEntity;


import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerDao extends MongoRepository<CustomerEntity, String> {
    // You can define custom query methods here if needed
}
