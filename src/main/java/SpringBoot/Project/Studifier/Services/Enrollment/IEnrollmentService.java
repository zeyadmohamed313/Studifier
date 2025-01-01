package SpringBoot.Project.Studifier.Services.Enrollment;

import SpringBoot.Project.Studifier.Models.Enrollment;

import java.util.List;

public interface IEnrollmentService {
    List<Enrollment> getAllEnrollments();
    Enrollment getEnrollmentById(Long id);
    Enrollment createEnrollment(Enrollment enrollment);
    Enrollment updateEnrollment(Long id, Enrollment updatedEnrollment);
    void deleteEnrollment(Long id);
}
