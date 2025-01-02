package SpringBoot.Project.Studifier.Services.Quiz;

import SpringBoot.Project.Studifier.Models.Quiz;
import SpringBoot.Project.Studifier.Requests.QuizRequestDTO;
import SpringBoot.Project.Studifier.Responses.QuizResponseDTO;

import java.util.List;

public interface IQuizService {
    List<QuizResponseDTO> getAllQuizzes();
    QuizResponseDTO getQuizById(Long id);
    QuizResponseDTO createQuiz(QuizRequestDTO quizRequestDTO);
    QuizResponseDTO updateQuiz(Long id, QuizRequestDTO quizRequestDTO);
    void deleteQuiz(Long id);
}
