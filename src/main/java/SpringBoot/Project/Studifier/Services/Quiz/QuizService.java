package SpringBoot.Project.Studifier.Services.Quiz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import SpringBoot.Project.Studifier.Models.Quiz;
import SpringBoot.Project.Studifier.Repositories.QuizRepository;
import java.util.List;

@Service
public class QuizService implements IQuizService {
    @Autowired
    private QuizRepository quizRepository;

    @Override
    public List<Quiz> getAllQuizzes() {
        return quizRepository.findAll();
    }

    @Override
    public Quiz getQuizById(Long id) {
        return quizRepository.findById(id).orElse(null);
    }

    @Override
    public Quiz createQuiz(Quiz quiz) {
        return quizRepository.save(quiz);
    }

    @Override
    public Quiz updateQuiz(Long id, Quiz quiz) {
        if(quizRepository.existsById(id)) {
            quiz.setId(id);
            return quizRepository.save(quiz);
        }
        return null;
    }

    @Override
    public void deleteQuiz(Long id) {
        quizRepository.deleteById(id);
    }
}
