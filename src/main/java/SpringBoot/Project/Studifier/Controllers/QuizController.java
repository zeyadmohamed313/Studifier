package SpringBoot.Project.Studifier.Controllers;
import SpringBoot.Project.Studifier.Helpers.ApiResponse;
import SpringBoot.Project.Studifier.Models.Enrollment;
import SpringBoot.Project.Studifier.Models.Quiz;
import SpringBoot.Project.Studifier.Services.Enrollment.EnrollmentService;
import SpringBoot.Project.Studifier.Services.Quiz.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/quizzes")
public class QuizController {
    @Autowired
    private QuizService quizService;

    @GetMapping
    public ResponseEntity<ApiResponse<List<Quiz>>> getAllQuizzes() {
        List<Quiz> quizzes = quizService.getAllQuizzes();
        return ResponseEntity.ok(new ApiResponse<>(true, "Fetched all quizzes successfully", quizzes));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Quiz>> getQuizById(@PathVariable Long id) {
        Quiz quiz = quizService.getQuizById(id);
        if (quiz == null) {
            return ResponseEntity.ok(new ApiResponse<>(false, "Quiz not found", null));
        }
        return ResponseEntity.ok(new ApiResponse<>(true, "Quiz fetched successfully", quiz));
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Quiz>> createQuiz(@RequestBody Quiz quiz) {
        Quiz createdQuiz = quizService.createQuiz(quiz);
        return ResponseEntity.ok(new ApiResponse<>(true, "Quiz created successfully", createdQuiz));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Quiz>> updateQuiz(@PathVariable Long id, @RequestBody Quiz updatedQuiz) {
        Quiz quiz = quizService.updateQuiz(id, updatedQuiz);
        if (quiz == null) {
            return ResponseEntity.ok(new ApiResponse<>(false, "Quiz not found", null));
        }
        return ResponseEntity.ok(new ApiResponse<>(true, "Quiz updated successfully", quiz));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteQuiz(@PathVariable Long id) {
        quizService.deleteQuiz(id);
        return ResponseEntity.ok(new ApiResponse<>(true, "Quiz deleted successfully", null));
    }
}