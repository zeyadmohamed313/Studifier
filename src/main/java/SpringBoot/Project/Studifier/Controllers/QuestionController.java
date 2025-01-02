package SpringBoot.Project.Studifier.Controllers;

import SpringBoot.Project.Studifier.Helpers.ApiResponse;
import SpringBoot.Project.Studifier.Requests.QuestionRequestDTO;
import SpringBoot.Project.Studifier.Responses.QuestionResponseDTO;
import SpringBoot.Project.Studifier.Services.Question.IQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/quizzes")
public class QuestionController {
    @Autowired
    private IQuestionService questionService;

    /**
     * Get all questions for a specific quiz.
     *
     * @param quizId The ID of the quiz.
     * @return List of QuestionResponseDTO objects wrapped in an ApiResponse.
     */
    @GetMapping("/{quizId}/getQuestionsByQuiz")
    public ResponseEntity<ApiResponse<List<QuestionResponseDTO>>> getQuestionsByQuiz(@PathVariable Long quizId) {
        List<QuestionResponseDTO> questions = questionService.getQuestionsByQuizId(quizId);
        return ResponseEntity.ok(new ApiResponse<>(questions, HttpStatus.OK));
    }

    /**
     * Add a new question to a specific quiz.
     *
     * @param quizId             The ID of the quiz.
     * @param questionRequestDTO The details of the question to be added.
     * @return The created QuestionResponseDTO wrapped in an ApiResponse.
     */
    @PostMapping("/{quizId}/AddQuestionToQuiz")
    public ResponseEntity<ApiResponse<QuestionResponseDTO>> addQuestion(
            @PathVariable Long quizId,
            @RequestBody @Valid QuestionRequestDTO questionRequestDTO) {
        questionRequestDTO.setQuizId(quizId); // Ensure quiz ID is set in the DTO
        QuestionResponseDTO createdQuestion = questionService.addQuestionToQuiz(questionRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ApiResponse<>(createdQuestion, HttpStatus.CREATED));
    }

    /**
     * Delete a specific question by its ID.
     *
     * @param quizId     The ID of the quiz.
     * @param questionId The ID of the question to be deleted.
     * @return Confirmation message wrapped in an ApiResponse.
     */
    @DeleteMapping("/{quizId}/questions/{questionId}")
    public ResponseEntity<ApiResponse<String>> deleteQuestion(
            @PathVariable Long quizId,
            @PathVariable Long questionId) {
        questionService.deleteQuestion(questionId);
        return ResponseEntity.ok(new ApiResponse<>("Question deleted successfully", HttpStatus.OK));
    }
}
