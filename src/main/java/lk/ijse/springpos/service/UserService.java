package lk.ijse.springpos.service;

import jakarta.transaction.Transactional;
import lk.ijse.springpos.dao.UserDAO;
import lk.ijse.springpos.dto.UserDTO;
import lk.ijse.springpos.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UserService {
    @Autowired
    private UserDAO userDAO;
    @Autowired
    private Map map;
    public void saveUser(UserDTO userDTO) {
        userDAO.save(map.toUserEntity(userDTO));
    }
}
