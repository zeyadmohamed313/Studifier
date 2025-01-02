package SpringBoot.Project.Studifier.Controllers;
import SpringBoot.Project.Studifier.Helpers.ApiResponse;
import SpringBoot.Project.Studifier.Models.Enrollment;
import SpringBoot.Project.Studifier.Models.Quiz;
import SpringBoot.Project.Studifier.Requests.QuizRequestDTO;
import SpringBoot.Project.Studifier.Responses.QuizResponseDTO;
import SpringBoot.Project.Studifier.Services.Enrollment.EnrollmentService;
import SpringBoot.Project.Studifier.Services.Quiz.IQuizService;
import SpringBoot.Project.Studifier.Services.Quiz.QuizService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/quizzes")
public class QuizController {
    @Autowired
    private QuizService quizService;

    @GetMapping("/all")
    public ResponseEntity<ApiResponse<List<QuizResponseDTO>>> getAllQuizzes() {
        List<QuizResponseDTO> quizzes = quizService.getAllQuizzes();
        return ResponseEntity.ok(new ApiResponse<>(quizzes, HttpStatus.OK));
    }

    @PostMapping
    public ResponseEntity<ApiResponse<QuizResponseDTO>> createQuiz(@RequestBody @Valid QuizRequestDTO quizRequestDTO) {
        QuizResponseDTO createdQuiz = quizService.createQuiz(quizRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ApiResponse<>(createdQuiz, HttpStatus.CREATED));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<QuizResponseDTO>> getQuizById(@PathVariable Long id) {
        QuizResponseDTO quiz = quizService.getQuizById(id);
        return ResponseEntity.ok(new ApiResponse<>(quiz, HttpStatus.OK));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<QuizResponseDTO>> updateQuiz(
            @PathVariable Long id, @RequestBody @Valid QuizRequestDTO quizRequestDTO) {
        QuizResponseDTO updatedQuiz = quizService.updateQuiz(id, quizRequestDTO);
        return ResponseEntity.ok(new ApiResponse<>(updatedQuiz, HttpStatus.OK));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<String>> deleteQuiz(@PathVariable Long id) {
        quizService.deleteQuiz(id);
        return ResponseEntity.ok(new ApiResponse<>("Quiz deleted successfully", HttpStatus.OK));
    }
}