package SpringBoot.Project.Studifier.Repositories;

import SpringBoot.Project.Studifier.Models.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question, Long> {
}
