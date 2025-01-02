package SpringBoot.Project.Studifier.Requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class QuestionRequestDTO {
    @NotBlank(message = "Question text is mandatory")
    @Size(min = 5, max = 500, message = "Question text must be between 5 and 500 characters")
    private String questionText;

    @NotBlank(message = "Answer is mandatory")
    private String answer;

    @NotNull(message = "Quiz ID is mandatory")
    private Long quizId;

    // Getters and Setters
    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Long getQuizId() {
        return quizId;
    }

    public void setQuizId(Long quizId) {
        this.quizId = quizId;
    }
}