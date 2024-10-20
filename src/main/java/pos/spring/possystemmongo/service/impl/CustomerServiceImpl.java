package pos.spring.possystemmongo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.domain.Sort;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pos.spring.possystemmongo.dao.CustomerDao;
import pos.spring.possystemmongo.dto.impl.CustomerDto;
import pos.spring.possystemmongo.entity.impl.CustomerEntity;
import pos.spring.possystemmongo.entity.impl.ItemEntity;
import pos.spring.possystemmongo.exception.DataPersistException;
import pos.spring.possystemmongo.service.CustomerService;
import pos.spring.possystemmongo.util.Mapping;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerDao customerDao;

    @Autowired
    private Mapping mapper;

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    @Transactional
    public void saveCustomer(CustomerDto customerDto) {
        System.out.println("customerDTO" + customerDto.getCustomerName());
        System.out.println("Saving customer in service impl");
        CustomerEntity customerEntity = mapper.customerEntity(customerDto);
        System.out.println("customerEntity" + customerEntity.getCustomerPhone());
        customerDao.save(customerEntity);
    }

    @Override
    @Transactional
    public void updateCustomer(String customerId, CustomerDto customerDto) {
        CustomerEntity customerEntity = customerDao.findById(customerId)
                .orElseThrow(() -> new DataPersistException("Customer with id " + customerId + " not found"));

        customerEntity.setCustomerName(customerDto.getCustomerName());
        customerEntity.setCustomerAddress(customerDto.getCustomerAddress());
        customerEntity.setCustomerPhone(customerDto.getCustomerPhone());
        customerDao.save(customerEntity);
    }

    @Override
    @Transactional(readOnly = true)
    public List<CustomerDto> getAllCustomer() {
        List<CustomerEntity> customers = customerDao.findAll();
        return mapper.customerDtoList(customers);
    }

    @Override
    public void deleteCustmer(String customerId) {
        if (!customerDao.existsById(customerId)) {
            throw new DataIntegrityViolationException("Customer with id " + customerId + " not found");
        }
        customerDao.deleteById(customerId);
    }

    @Override
    @Transactional(readOnly = true)
    public CustomerDto getCustomerById(String customerId) {
        CustomerEntity customerEntity = customerDao.findById(customerId)
                .orElseThrow(() -> new DataPersistException("Customer with id " + customerId + " not found"));

        return mapper.customerDto(customerEntity);
    }

    @Override
    public String customerCount() {
        long count = mongoTemplate.count(new Query(), CustomerEntity.class);
        return String.valueOf(count);
    }

    @Override
    @Transactional
    public String generateCustomerID() {

        Query query = new Query();
        query.with(Sort.by(Sort.Order.desc("customerId")));
        query.limit(1);


        CustomerEntity lastCustomer = mongoTemplate.findOne(query, CustomerEntity.class);


        if (lastCustomer != null) {
            String lastCustomerId = lastCustomer.getCustomerId();
            int generatedCustomerId = Integer.parseInt(lastCustomerId.replace("C00-", "")) + 1;
            return String.format("C00-%03d", generatedCustomerId);
        } else {
            return "C00-001";
        }
    }
}
