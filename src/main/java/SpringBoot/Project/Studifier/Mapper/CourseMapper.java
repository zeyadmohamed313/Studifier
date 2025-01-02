package SpringBoot.Project.Studifier.Mapper;


import SpringBoot.Project.Studifier.Models.Course;
import SpringBoot.Project.Studifier.Models.User;
import SpringBoot.Project.Studifier.Requests.CourseRequestDTO;
import SpringBoot.Project.Studifier.Responses.CourseResponseDTO;

import java.util.List;
import java.util.stream.Collectors;

public class CourseMapper {
    public static CourseResponseDTO toResponseDTO(Course course) {
        return new CourseResponseDTO(
                course.getId(),
                course.getTitle(),
                course.getDescription(),
                course.getInstructor() != null ? course.getInstructor().getUsername() : null
        );
    }

    // Convert a list of Courses to a list of CourseResponseDTOs
    public static List<CourseResponseDTO> toResponseDTOList(List<Course> courses) {
        return courses.stream().map(CourseMapper::toResponseDTO).collect(Collectors.toList());
    }

    // Convert CourseRequestDTO to Course
    public static Course toEntity(CourseRequestDTO requestDTO, User instructor) {
        Course course = new Course();
        course.setTitle(requestDTO.getTitle());
        course.setDescription(requestDTO.getDescription());
        course.setInstructor(instructor);
        course.setStartDate(requestDTO.getStartDate());
        return course;
    }
}
