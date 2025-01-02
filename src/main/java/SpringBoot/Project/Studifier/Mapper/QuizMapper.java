package SpringBoot.Project.Studifier.Mapper;

import SpringBoot.Project.Studifier.Models.Course;
import SpringBoot.Project.Studifier.Models.Quiz;
import SpringBoot.Project.Studifier.Requests.QuizRequestDTO;
import SpringBoot.Project.Studifier.Responses.QuizResponseDTO;

import java.util.List;
import java.util.stream.Collectors;

public class QuizMapper {
    public static QuizResponseDTO toResponseDTO(Quiz quiz) {
        return new QuizResponseDTO(
                quiz.getId(),
                quiz.getTitle(),
                quiz.getCourse().getTitle() // Assuming Course has a getTitle() method
        );
    }

    public static List<QuizResponseDTO> toResponseDTOList(List<Quiz> quizzes) {
        return quizzes.stream().map(QuizMapper::toResponseDTO).collect(Collectors.toList());
    }

    public static Quiz toEntity(QuizRequestDTO requestDTO, Course course) {
        Quiz quiz = new Quiz();
        quiz.setTitle(requestDTO.getTitle());
        quiz.setCourse(course);
        return quiz;
    }
}