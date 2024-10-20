package pos.spring.possystemmongo.service;



import pos.spring.possystemmongo.dto.impl.CustomerDto;

import java.util.List;

public interface CustomerService {
    void saveCustomer(CustomerDto customerDto);

    String generateCustomerID();

    void updateCustomer(String customerId, CustomerDto customerDto);

    List<CustomerDto> getAllCustomer();

    void deleteCustmer(String customerId);

    CustomerDto getCustomerById(String customerID);

    String customerCount();
}

