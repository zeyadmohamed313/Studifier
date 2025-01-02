package SpringBoot.Project.Studifier.Services.Enrollment;

import SpringBoot.Project.Studifier.Mapper.EnrollmentMapper;
import SpringBoot.Project.Studifier.Models.Course;
import SpringBoot.Project.Studifier.Models.Enrollment;
import SpringBoot.Project.Studifier.Models.User;
import SpringBoot.Project.Studifier.Repositories.CourseRepository;
import SpringBoot.Project.Studifier.Repositories.EnrollmentRepository;
import SpringBoot.Project.Studifier.Repositories.UserRepository;
import SpringBoot.Project.Studifier.Requests.EnrollmentRequestDTO;
import SpringBoot.Project.Studifier.Responses.EnrollmentResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnrollmentService  implements IEnrollmentService{
    @Autowired
    private EnrollmentRepository enrollmentRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private UserRepository userRepository;

    public List<EnrollmentResponseDTO> getAllEnrollments() {
        List<Enrollment> enrollments = enrollmentRepository.findAll();
        return EnrollmentMapper.toResponseDTOList(enrollments);
    }

    public EnrollmentResponseDTO createEnrollment(EnrollmentRequestDTO enrollmentRequestDTO) {
        Course course = courseRepository.findById(enrollmentRequestDTO.getCourseId())
                .orElseThrow(() -> new IllegalArgumentException("Course not found"));

        User student = userRepository.findById(enrollmentRequestDTO.getStudentId())
                .orElseThrow(() -> new IllegalArgumentException("Student not found"));

        Enrollment enrollment = EnrollmentMapper.toEntity(enrollmentRequestDTO, course, student);
        Enrollment savedEnrollment = enrollmentRepository.save(enrollment);

        return EnrollmentMapper.toResponseDTO(savedEnrollment);
    }

    public EnrollmentResponseDTO getEnrollmentById(Long id) {
        Enrollment enrollment = enrollmentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Enrollment not found"));

        return EnrollmentMapper.toResponseDTO(enrollment);
    }

    public EnrollmentResponseDTO updateEnrollment(Long id, EnrollmentRequestDTO enrollmentRequestDTO) {
        Enrollment enrollment = enrollmentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Enrollment not found"));

        Course course = courseRepository.findById(enrollmentRequestDTO.getCourseId())
                .orElseThrow(() -> new IllegalArgumentException("Course not found"));

        User student = userRepository.findById(enrollmentRequestDTO.getStudentId())
                .orElseThrow(() -> new IllegalArgumentException("Student not found"));

        enrollment.setCourse(course);
        enrollment.setStudent(student);

        Enrollment updatedEnrollment = enrollmentRepository.save(enrollment);

        return EnrollmentMapper.toResponseDTO(updatedEnrollment);
    }

    public void deleteEnrollment(Long id) {
        if (!enrollmentRepository.existsById(id)) {
            throw new IllegalArgumentException("Enrollment not found");
        }
        enrollmentRepository.deleteById(id);
    }
}
