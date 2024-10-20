package pos.spring.possystemmongo.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pos.spring.possystemmongo.dao.ItemDao;
import pos.spring.possystemmongo.dto.impl.ItemDto;
import pos.spring.possystemmongo.entity.impl.ItemEntity;
import pos.spring.possystemmongo.entity.impl.OrderEntity;
import pos.spring.possystemmongo.service.ItemService;
import pos.spring.possystemmongo.util.Mapping;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ItemServiceImpl implements ItemService {


    @Autowired
    private ItemDao itemDao;

    @Autowired
    private Mapping mapper;

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public void saveItem(ItemDto itemDto) {

        ItemEntity save = itemDao.save(mapper.itemEntity(itemDto));
        if(save == null) {
            throw new DataIntegrityViolationException("Item saved failed");
        }
    }

    @Override
    public String generateItemID() {
        Query query = new Query();
        query.with(Sort.by(Sort.Order.desc("itemId")));
        query.limit(1);


        ItemEntity lastItem = mongoTemplate.findOne(query, ItemEntity.class);


        if (lastItem != null) {
            String lastItemId = lastItem.getItemId();
            int generatedItemId = Integer.parseInt(lastItemId.replace("I00-", "")) + 1;
            return String.format("I00-%03d", generatedItemId);
        } else {
            return "I00-001";
        }
    }

    @Override
    public void updateItem(String itemId, ItemDto itemDto) {

        Optional<ItemEntity> optionalItem = itemDao.findById(itemId);


        System.out.println(itemDto.getQuantity() + " Item dto update qty");

        if (optionalItem.isPresent()) {
            ItemEntity existingItem = optionalItem.get();


            existingItem.setDescription(itemDto.getDescription());
            existingItem.setQuantity(itemDto.getQuantity());
            existingItem.setUnitPrice(itemDto.getUnitPrice());


            itemDao.save(existingItem);
        } else {

            System.out.println("Item not found with ID: " + itemId);
        }
    }


    @Override
    public List<ItemDto> getAllItem() {
        return mapper.itemDtoList(itemDao.findAll());
    }

    @Override
    public void deleteItem(String itemId) {
        System.out.println("deleteItem service layer");
        Optional<ItemEntity> tempItem = itemDao.findById(itemId);
        if (!tempItem.isPresent()) {
            throw new DataIntegrityViolationException("Item with id"+ itemId +"Item not found");
        }else {
            itemDao.deleteById(itemId);
        }

    }

    @Override
    public ItemDto getItemById(String itemId) {

        ItemEntity itemEntity = itemDao.findById(itemId)
                .orElseThrow(() -> new RuntimeException("Item not found with ID: " + itemId));


        return mapper.itemDto(itemEntity);
    }

    @Override
    public String itemCount() {
        long count = mongoTemplate.count(new Query(), ItemEntity.class);
        return String.valueOf(count);
    }

}
