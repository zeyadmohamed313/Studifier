package SpringBoot.Project.Studifier.Services.Course;

import SpringBoot.Project.Studifier.Models.Course;
import SpringBoot.Project.Studifier.Responses.CourseResponseDTO;

import java.util.List;

public interface ICourseService {
    List<CourseResponseDTO> getAllCourses();
    Course getCourseById(Long id);
    Course createCourse(Course course);
    Course updateCourse(Long id, Course updatedCourse);
    void deleteCourse(Long id);
}
