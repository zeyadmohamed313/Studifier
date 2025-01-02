package SpringBoot.Project.Studifier.Services.Course;

import SpringBoot.Project.Studifier.Mapper.CourseMapper;
import SpringBoot.Project.Studifier.Models.Course;
import SpringBoot.Project.Studifier.Models.User;
import SpringBoot.Project.Studifier.Repositories.CourseRepository;
import SpringBoot.Project.Studifier.Repositories.UserRepository;
import SpringBoot.Project.Studifier.Requests.CourseRequestDTO;
import SpringBoot.Project.Studifier.Responses.CourseResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CourseService {
    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private UserRepository userRepository;

    public List<CourseResponseDTO> getAllCourses() {
        List<Course> courses = courseRepository.findAll();
        return CourseMapper.toResponseDTOList(courses);
    }

    public CourseResponseDTO createCourse(CourseRequestDTO courseRequestDTO) {
        User instructor = userRepository.findById(courseRequestDTO.getInstructorId())
                .orElseThrow(() -> new IllegalArgumentException("Instructor not found"));

        Course course = CourseMapper.toEntity(courseRequestDTO, instructor);
        Course savedCourse = courseRepository.save(course);

        return CourseMapper.toResponseDTO(savedCourse);
    }

    public CourseResponseDTO getCourseById(Long id) {
        Course course = courseRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Course not found"));

        return CourseMapper.toResponseDTO(course);
    }

    public CourseResponseDTO updateCourse(Long id, CourseRequestDTO courseRequestDTO) {
        Course course = courseRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Course not found"));

        User instructor = userRepository.findById(courseRequestDTO.getInstructorId())
                .orElseThrow(() -> new IllegalArgumentException("Instructor not found"));

        course.setTitle(courseRequestDTO.getTitle());
        course.setDescription(courseRequestDTO.getDescription());
        course.setInstructor(instructor);

        Course updatedCourse = courseRepository.save(course);

        return CourseMapper.toResponseDTO(updatedCourse);
    }

    public void deleteCourse(Long id) {
        if (!courseRepository.existsById(id)) {
            throw new IllegalArgumentException("Course not found");
        }
        courseRepository.deleteById(id);
    }
}


