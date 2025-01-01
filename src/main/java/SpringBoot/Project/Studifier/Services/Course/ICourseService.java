package SpringBoot.Project.Studifier.Services.Course;

import SpringBoot.Project.Studifier.Models.Course;
import java.util.List;

public interface ICourseService {
    List<Course> getAllCourses();
    Course getCourseById(Long id);
    Course createCourse(Course course);
    Course updateCourse(Long id, Course updatedCourse);
    void deleteCourse(Long id);
}
