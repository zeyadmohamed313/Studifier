package SpringBoot.Project.Studifier.Repositories;

import SpringBoot.Project.Studifier.Models.Content;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContentRepository extends JpaRepository<Content, Long> {
}
