package SpringBoot.Project.Studifier.Services.Question;

import SpringBoot.Project.Studifier.Mapper.QuestionMapper;
import SpringBoot.Project.Studifier.Models.Question;
import SpringBoot.Project.Studifier.Models.Quiz;
import SpringBoot.Project.Studifier.Repositories.QuestionRepository;
import SpringBoot.Project.Studifier.Repositories.QuizRepository;
import SpringBoot.Project.Studifier.Requests.QuestionRequestDTO;
import SpringBoot.Project.Studifier.Responses.QuestionResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService implements IQuestionService {
    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private QuizRepository quizRepository;

    @Override
    public List<QuestionResponseDTO> getQuestionsByQuizId(Long quizId) {
        Quiz quiz = quizRepository.findById(quizId)
                .orElseThrow(() -> new IllegalArgumentException("Quiz not found"));
        return QuestionMapper.toResponseDTOList(questionRepository.findByQuiz(quiz));
    }

    @Override
    public QuestionResponseDTO addQuestionToQuiz(QuestionRequestDTO questionRequestDTO) {
        Quiz quiz = quizRepository.findById(questionRequestDTO.getQuizId())
                .orElseThrow(() -> new IllegalArgumentException("Quiz not found"));

        Question question = QuestionMapper.toEntity(questionRequestDTO, quiz);
        Question savedQuestion = questionRepository.save(question);

        return QuestionMapper.toResponseDTO(savedQuestion);
    }

    @Override
    public void deleteQuestion(Long questionId) {
        if (!questionRepository.existsById(questionId)) {
            throw new IllegalArgumentException("Question not found");
        }
        questionRepository.deleteById(questionId);
    }
}