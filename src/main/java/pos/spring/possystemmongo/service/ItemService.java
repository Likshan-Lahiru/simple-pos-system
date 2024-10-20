package pos.spring.possystemmongo.service;




import pos.spring.possystemmongo.dto.impl.ItemDto;
import java.util.List;

public interface ItemService {
    void saveItem(ItemDto itemDto);

    String generateItemID();

    void updateItem(String itemId, ItemDto itemDto);

    List<ItemDto> getAllItem();

    void deleteItem(String itemId);

    ItemDto getItemById(String ItemId);
    String itemCount();
}
