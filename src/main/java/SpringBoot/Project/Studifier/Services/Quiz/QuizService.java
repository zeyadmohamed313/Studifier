package SpringBoot.Project.Studifier.Services.Quiz;

import SpringBoot.Project.Studifier.Mapper.QuizMapper;
import SpringBoot.Project.Studifier.Models.Course;
import SpringBoot.Project.Studifier.Repositories.CourseRepository;
import SpringBoot.Project.Studifier.Requests.QuizRequestDTO;
import SpringBoot.Project.Studifier.Responses.QuizResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import SpringBoot.Project.Studifier.Models.Quiz;
import SpringBoot.Project.Studifier.Repositories.QuizRepository;
import java.util.List;

@Service
public class QuizService implements IQuizService {
    @Autowired
    private QuizRepository quizRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public List<QuizResponseDTO> getAllQuizzes() {
        return QuizMapper.toResponseDTOList(quizRepository.findAll());
    }

    @Override
    public QuizResponseDTO getQuizById(Long id) {
        Quiz quiz = quizRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Quiz not found"));
        return QuizMapper.toResponseDTO(quiz);
    }

    @Override
    public QuizResponseDTO createQuiz(QuizRequestDTO quizRequestDTO) {
        Course course = courseRepository.findById(quizRequestDTO.getCourseId())
                .orElseThrow(() -> new IllegalArgumentException("Course not found"));

        Quiz quiz = QuizMapper.toEntity(quizRequestDTO, course);
        Quiz savedQuiz = quizRepository.save(quiz);

        return QuizMapper.toResponseDTO(savedQuiz);
    }

    @Override
    public QuizResponseDTO updateQuiz(Long id, QuizRequestDTO quizRequestDTO) {
        Quiz quiz = quizRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Quiz not found"));

        Course course = courseRepository.findById(quizRequestDTO.getCourseId())
                .orElseThrow(() -> new IllegalArgumentException("Course not found"));

        quiz.setTitle(quizRequestDTO.getTitle());
        quiz.setCourse(course);

        Quiz updatedQuiz = quizRepository.save(quiz);

        return QuizMapper.toResponseDTO(updatedQuiz);
    }

    @Override
    public void deleteQuiz(Long id) {
        if (!quizRepository.existsById(id)) {
            throw new IllegalArgumentException("Quiz not found");
        }
        quizRepository.deleteById(id);
    }
}