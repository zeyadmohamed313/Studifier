package SpringBoot.Project.Studifier.Repositories;

import SpringBoot.Project.Studifier.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> findByUsername(String username);
    User findByEmail(String email);
}
