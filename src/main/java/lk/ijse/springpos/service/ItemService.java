package lk.ijse.springpos.service;

import jakarta.transaction.Transactional;
import lk.ijse.springpos.dao.ItemDAO;
import lk.ijse.springpos.dto.ItemDTO;
import lk.ijse.springpos.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ItemService {
    @Autowired
    private ItemDAO itemDAO;
    @Autowired
    private Map map;
    public void saveItem(ItemDTO itemDTO) {
        itemDAO.save(map.toItemEntity(itemDTO));
    }
}
