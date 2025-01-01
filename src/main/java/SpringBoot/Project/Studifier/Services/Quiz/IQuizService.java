package SpringBoot.Project.Studifier.Services.Quiz;

import SpringBoot.Project.Studifier.Models.Quiz;
import java.util.List;

public interface IQuizService {
    List<Quiz> getAllQuizzes();
    Quiz getQuizById(Long id);
    Quiz createQuiz(Quiz quiz);
    Quiz updateQuiz(Long id, Quiz quiz);
    void deleteQuiz(Long id);
}
