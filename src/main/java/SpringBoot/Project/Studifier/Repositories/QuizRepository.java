package SpringBoot.Project.Studifier.Repositories;

import SpringBoot.Project.Studifier.Models.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizRepository extends JpaRepository<Quiz, Long> {
}
