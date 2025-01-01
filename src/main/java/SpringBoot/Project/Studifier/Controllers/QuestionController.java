package SpringBoot.Project.Studifier.Controllers;
import SpringBoot.Project.Studifier.Helpers.ApiResponse;
import SpringBoot.Project.Studifier.Models.Course;
import SpringBoot.Project.Studifier.Models.Notification;
import SpringBoot.Project.Studifier.Models.Question;
import SpringBoot.Project.Studifier.Services.Course.CourseService;
import SpringBoot.Project.Studifier.Services.Notification.NotificationService;
import SpringBoot.Project.Studifier.Services.Question.QuestionService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/questions")
public class QuestionController {
    @Autowired
    private QuestionService questionService;

    @GetMapping
    public ResponseEntity<ApiResponse<List<Question>>> getAllQuestions() {
        List<Question> questions = questionService.getAllQuestions();
        return ResponseEntity.ok(new ApiResponse<>(true, "Fetched all questions successfully", questions));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Question>> getQuestionById(@PathVariable Long id) {
        Question question = questionService.getQuestionById(id);
        if (question == null) {
            return ResponseEntity.ok(new ApiResponse<>(false, "Question not found", null));
        }
        return ResponseEntity.ok(new ApiResponse<>(true, "Question fetched successfully", question));
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Question>> createQuestion(@RequestBody Question question) {
        Question createdQuestion = questionService.createQuestion(question);
        return ResponseEntity.ok(new ApiResponse<>(true, "Question created successfully", createdQuestion));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Question>> updateQuestion(@PathVariable Long id, @RequestBody Question updatedQuestion) {
        Question question = questionService.updateQuestion(id, updatedQuestion);
        if (question == null) {
            return ResponseEntity.ok(new ApiResponse<>(false, "Question not found", null));
        }
        return ResponseEntity.ok(new ApiResponse<>(true, "Question updated successfully", question));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteQuestion(@PathVariable Long id) {
        questionService.deleteQuestion(id);
        return ResponseEntity.ok(new ApiResponse<>(true, "Question deleted successfully", null));
    }
}