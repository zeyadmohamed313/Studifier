package SpringBoot.Project.Studifier.Mapper;

import SpringBoot.Project.Studifier.Models.Course;
import SpringBoot.Project.Studifier.Models.Enrollment;
import SpringBoot.Project.Studifier.Models.User;
import SpringBoot.Project.Studifier.Requests.EnrollmentRequestDTO;
import SpringBoot.Project.Studifier.Responses.EnrollmentResponseDTO;

import java.util.List;
import java.util.stream.Collectors;

public class EnrollmentMapper {

    // Convert Enrollment to EnrollmentResponseDTO
    public static EnrollmentResponseDTO toResponseDTO(Enrollment enrollment) {
        return new EnrollmentResponseDTO(
                enrollment.getId(),
                enrollment.getCourse() != null ? enrollment.getCourse().getTitle() : null,
                enrollment.getStudent() != null ? enrollment.getStudent().getUsername() : null
        );
    }

    // Convert a list of Enrollments to a list of EnrollmentResponseDTOs
    public static List<EnrollmentResponseDTO> toResponseDTOList(List<Enrollment> enrollments) {
        return enrollments.stream().map(EnrollmentMapper::toResponseDTO).collect(Collectors.toList());
    }

    // Convert EnrollmentRequestDTO to Enrollment entity
    public static Enrollment toEntity(EnrollmentRequestDTO requestDTO, Course course, User student) {
        Enrollment enrollment = new Enrollment();
        enrollment.setCourse(course);
        enrollment.setStudent(student);
        return enrollment;
    }
}