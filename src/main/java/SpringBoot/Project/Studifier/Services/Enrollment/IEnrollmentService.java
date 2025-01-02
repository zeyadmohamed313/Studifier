package SpringBoot.Project.Studifier.Services.Enrollment;

import SpringBoot.Project.Studifier.Models.Enrollment;
import SpringBoot.Project.Studifier.Requests.EnrollmentRequestDTO;
import SpringBoot.Project.Studifier.Responses.EnrollmentResponseDTO;

import java.util.List;

public interface IEnrollmentService {
    List<EnrollmentResponseDTO> getAllEnrollments();

    EnrollmentResponseDTO getEnrollmentById(Long id);

    EnrollmentResponseDTO createEnrollment(EnrollmentRequestDTO enrollmentRequestDTO);

    EnrollmentResponseDTO updateEnrollment(Long id, EnrollmentRequestDTO enrollmentRequestDTO);

    void deleteEnrollment(Long id);
}
