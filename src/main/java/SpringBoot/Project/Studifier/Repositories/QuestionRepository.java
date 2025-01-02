package SpringBoot.Project.Studifier.Repositories;

import SpringBoot.Project.Studifier.Models.Question;
import SpringBoot.Project.Studifier.Models.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Question, Long> {
    List<Question> findByQuiz(Quiz quiz);
}
