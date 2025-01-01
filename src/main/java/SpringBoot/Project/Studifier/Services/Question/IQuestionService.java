package SpringBoot.Project.Studifier.Services.Question;

import SpringBoot.Project.Studifier.Models.Question;

import java.util.List;

public interface IQuestionService {
    List<Question> getAllQuestions();
    Question getQuestionById(Long id);
    Question createQuestion(Question question);
    Question updateQuestion(Long id, Question updatedQuestion);
    void deleteQuestion(Long id);
}
