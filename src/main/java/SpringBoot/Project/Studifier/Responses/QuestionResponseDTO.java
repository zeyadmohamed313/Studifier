package SpringBoot.Project.Studifier.Responses;

public class QuestionResponseDTO {
    private Long id;
    private String questionText;
    private String answer;

    // Constructor
    public QuestionResponseDTO(Long id, String questionText, String answer) {
        this.id = id;
        this.questionText = questionText;
        this.answer = answer;
    }

    // Getters
    public Long getId() {
        return id;
    }

    public String getQuestionText() {
        return questionText;
    }

    public String getAnswer() {
        return answer;
    }
}
