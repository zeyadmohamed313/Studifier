package SpringBoot.Project.Studifier.Repositories;

import SpringBoot.Project.Studifier.Models.Enrollment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnrollmentRepository extends JpaRepository<Enrollment,Long> {
}
