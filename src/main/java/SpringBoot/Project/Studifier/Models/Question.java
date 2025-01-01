package SpringBoot.Project.Studifier.Models;

import jakarta.persistence.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;


@Entity
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Question text is mandatory")
    @Size(min = 5, max = 500, message = "Question text must be between 5 and 500 characters")
    @Column(nullable = false)
    private String questionText;

    @NotBlank(message = "Answer is mandatory")
    @Column(nullable = false)
    private String answer;

    @ManyToOne
    @JoinColumn(name = "quiz_id", nullable = false)
    private Quiz quiz;

    // Default constructor
    public Question() {}

    // Parameterized constructor
    public Question(String questionText, String answer, Quiz quiz) {
        this.questionText = questionText;
        this.answer = answer;
        this.quiz = quiz;
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public Quiz getQuiz() {
        return quiz;
    }

    public void setQuiz(Quiz quiz) {
        this.quiz = quiz;
    }

    // toString method
    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", questionText='" + questionText + '\'' +
                ", answer='" + answer + '\'' +
                ", quiz=" + quiz +
                '}';
    }
}
