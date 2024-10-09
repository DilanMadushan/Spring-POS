package lk.ijse.springpos.service;

import jakarta.transaction.Transactional;
import lk.ijse.springpos.dao.ItemDAO;
import lk.ijse.springpos.dto.ItemDTO;
import lk.ijse.springpos.entity.Item;
import lk.ijse.springpos.util.Conveter;
import lk.ijse.springpos.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ItemService {
    @Autowired
    private ItemDAO itemDAO;
    @Autowired
    private Map map;
    @Autowired
    private Conveter conveter;
    public void saveItem(ItemDTO itemDTO) {
        itemDAO.save(map.toItemEntity(itemDTO));
    }

    public void updateItem(String id, ItemDTO itemDTO) {
        Optional<Item> byId = itemDAO.findById(id);

        if(byId.isPresent()){
            Item item = byId.get();
            conveter.itemConvter(item, itemDTO);
        }
    }

    public void deleteItem(String id) {
        itemDAO.deleteById(id);
    }

    public List<ItemDTO> getAllItems() {
        List<Item> all = itemDAO.findAll();
        List<ItemDTO> allDto = new ArrayList<>();

        for (Item item : all) {
            allDto.add(map.toItemDTO(item));
        }
        return allDto;
    }

    public ItemDTO findItem(String id) {
        Optional<Item> byId = itemDAO.findById(id);

        if (byId.isPresent()) {
            Item item = byId.get();
            return map.toItemDTO(item);
        }
        return null;

    }
}
