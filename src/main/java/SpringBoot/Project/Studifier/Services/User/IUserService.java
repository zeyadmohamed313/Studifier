package SpringBoot.Project.Studifier.Services.User;

import SpringBoot.Project.Studifier.Models.User;
import SpringBoot.Project.Studifier.Requests.UserDTO;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;
import java.util.Optional;

public interface IUserService extends UserDetailsService {
    List<UserDTO> getAllUsers();
    User getUserById(Long id);
    Optional<User> getUserByUsername(String username);
    User createUser(UserDTO user);
    String getCurrentUsername();
    User updateUser(Long id, User updatedUser);
    Boolean deleteUser(Long id);

}

