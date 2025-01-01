package SpringBoot.Project.Studifier.Repositories;

import SpringBoot.Project.Studifier.Models.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}
