package SpringBoot.Project.Studifier.Services.Question;

import SpringBoot.Project.Studifier.Models.Question;
import SpringBoot.Project.Studifier.Requests.QuestionRequestDTO;
import SpringBoot.Project.Studifier.Responses.QuestionResponseDTO;

import java.util.List;

public interface IQuestionService {
    List<QuestionResponseDTO> getQuestionsByQuizId(Long quizId);
    QuestionResponseDTO addQuestionToQuiz(QuestionRequestDTO questionRequestDTO);
    void deleteQuestion(Long questionId);
}
