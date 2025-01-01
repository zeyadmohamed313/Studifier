package SpringBoot.Project.Studifier.Services.User;

import SpringBoot.Project.Studifier.Models.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;
import java.util.Optional;

public interface IUserService extends UserDetailsService {
    List<User> getAllUsers();
    User getUserById(Long id);
    Optional<User> getUserByUsername(String username);
    User createUser(User user);
    String getCurrentUsername();
    User updateUser(Long id, User updatedUser);
    Boolean deleteUser(Long id);
}

