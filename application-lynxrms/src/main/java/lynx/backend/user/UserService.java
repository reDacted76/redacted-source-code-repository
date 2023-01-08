package lynx.backend.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void saveUser(User user) {
        userRepository.save(user);
    }

    public void editUser(long id, User user) {
        userRepository.save(user);
    }

    public void deleteUser(long id) {
        userRepository.deleteById(id);
    }

    public void deleteAllUsers() {
        userRepository.deleteAll();
    }

    public User getUserById(long id) {
        return userRepository.getById(id);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Page<User> findPage(int pageNumber) {
        Pageable pageable = PageRequest.of(pageNumber - 1,2);
        return userRepository.findAll(pageable) ;
    }
}