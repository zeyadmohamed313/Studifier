package SpringBoot.Project.Studifier.Services.Enrollment;

import SpringBoot.Project.Studifier.Models.Enrollment;
import SpringBoot.Project.Studifier.Repositories.EnrollmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnrollmentService  implements IEnrollmentService{
    @Autowired
    private EnrollmentRepository enrollmentRepository;

    @Override
    public List<Enrollment> getAllEnrollments() {
        return enrollmentRepository.findAll();
    }

    @Override
    public Enrollment getEnrollmentById(Long id) {
        return enrollmentRepository.findById(id).orElse(null);
    }

    @Override
    public Enrollment createEnrollment(Enrollment enrollment) {
        return enrollmentRepository.save(enrollment);
    }

    @Override
    public Enrollment updateEnrollment(Long id, Enrollment updatedEnrollment) {
        Optional<Enrollment> optionalEnrollment = enrollmentRepository.findById(id);
        if (optionalEnrollment.isPresent()) {
            Enrollment enrollment = optionalEnrollment.get();
            enrollment.setStudent(updatedEnrollment.getStudent());
            enrollment.setCourse(updatedEnrollment.getCourse());
            enrollment.setEnrollmentDate(updatedEnrollment.getEnrollmentDate());
            enrollment.setCompleted(updatedEnrollment.getCompleted());
            enrollment.setProgressPercentage(updatedEnrollment.getProgressPercentage());
            return enrollmentRepository.save(enrollment);
        }
        return null;
    }

    @Override
    public void deleteEnrollment(Long id) {
        enrollmentRepository.deleteById(id);
    }

}
