package SpringBoot.Project.Studifier.Mapper;

import SpringBoot.Project.Studifier.Models.Question;
import SpringBoot.Project.Studifier.Models.Quiz;
import SpringBoot.Project.Studifier.Requests.QuestionRequestDTO;
import SpringBoot.Project.Studifier.Responses.QuestionResponseDTO;

import java.util.List;
import java.util.stream.Collectors;

public class QuestionMapper {
    public static QuestionResponseDTO toResponseDTO(Question question) {
        return new QuestionResponseDTO(
                question.getId(),
                question.getQuestionText(),
                question.getAnswer()
        );
    }

    public static List<QuestionResponseDTO> toResponseDTOList(List<Question> questions) {
        return questions.stream().map(QuestionMapper::toResponseDTO).collect(Collectors.toList());
    }

    public static Question toEntity(QuestionRequestDTO requestDTO, Quiz quiz) {
        Question question = new Question();
        question.setQuestionText(requestDTO.getQuestionText());
        question.setAnswer(requestDTO.getAnswer());
        question.setQuiz(quiz);
        return question;
    }
}