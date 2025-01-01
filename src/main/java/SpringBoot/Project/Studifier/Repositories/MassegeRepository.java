package SpringBoot.Project.Studifier.Repositories;

import SpringBoot.Project.Studifier.Models.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MassegeRepository extends JpaRepository<Message,Long> {
}
