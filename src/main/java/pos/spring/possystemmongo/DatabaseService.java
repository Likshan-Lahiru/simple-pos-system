package pos.spring.possystemmongo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pos.spring.possystemmongo.dao.CustomerDao;
import pos.spring.possystemmongo.dao.ItemDao;
import pos.spring.possystemmongo.dao.OrderDao;
import pos.spring.possystemmongo.dao.OrderDetailsDao;
import pos.spring.possystemmongo.entity.impl.CustomerEntity;
import pos.spring.possystemmongo.entity.impl.ItemEntity;
import pos.spring.possystemmongo.entity.impl.OrderDetailsEntity;
import pos.spring.possystemmongo.entity.impl.OrderEntity;


import java.util.Arrays;

@Service
public class DatabaseService {

    @Autowired
    private CustomerDao customerRepository;

    @Autowired
    private ItemDao itemRepository;

    @Autowired
    private OrderDao orderRepository;

    @Autowired
    private OrderDetailsDao orderDetailsRepository;

    public void initializeDatabase() {

        System.out.println("Database initialized with sample data.");
    }
}
