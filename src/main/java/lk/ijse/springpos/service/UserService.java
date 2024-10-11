package lk.ijse.springpos.service;

import jakarta.transaction.Transactional;
import lk.ijse.springpos.dao.UserDAO;
import lk.ijse.springpos.dto.UserDTO;
import lk.ijse.springpos.entity.User;
import lk.ijse.springpos.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

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

    public UserDTO findUser(String id) {
        Optional<User> byId = userDAO.findById(id);
        if (byId.isPresent()) {
            User user = byId.get();
            return map.toUserDto(user);
        }
        return null;
    }
}
