package SpringBoot.Project.Studifier.Services.Question;

import SpringBoot.Project.Studifier.Models.Question;
import SpringBoot.Project.Studifier.Repositories.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService implements IQuestionService {
    @Autowired
    private QuestionRepository questionRepository;

    @Override
    public List<Question> getAllQuestions() {
        return questionRepository.findAll();
    }

    @Override
    public Question getQuestionById(Long id) {
        return questionRepository.findById(id).orElse(null);
    }

    @Override
    public Question createQuestion(Question question) {
        return questionRepository.save(question);
    }

    @Override
    public Question updateQuestion(Long id, Question updatedQuestion) {
        if (questionRepository.existsById(id)) {
            updatedQuestion.setId(id);
            return questionRepository.save(updatedQuestion);
        }
        return null;
    }

    @Override
    public void deleteQuestion(Long id) {
        questionRepository.deleteById(id);
    }
}