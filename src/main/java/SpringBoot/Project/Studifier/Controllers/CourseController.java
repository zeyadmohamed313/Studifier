package SpringBoot.Project.Studifier.Controllers;

import SpringBoot.Project.Studifier.Helpers.ApiResponse;
import SpringBoot.Project.Studifier.Models.Course;
import SpringBoot.Project.Studifier.Requests.CourseRequestDTO;
import SpringBoot.Project.Studifier.Responses.CourseResponseDTO;
import SpringBoot.Project.Studifier.Services.Course.CourseService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
@RequestMapping("/api/courses")
public class CourseController {
    @Autowired
    private CourseService courseService;

    @GetMapping("/all")
    public ResponseEntity<ApiResponse<List<CourseResponseDTO>>> getAllCourses() {
        List<CourseResponseDTO> courses = courseService.getAllCourses();
        return ResponseEntity.ok(new ApiResponse<>(courses, HttpStatus.OK));
    }

    @PostMapping
    public ResponseEntity<ApiResponse<CourseResponseDTO>> createCourse(@RequestBody @Valid CourseRequestDTO courseRequestDTO) {
        CourseResponseDTO createdCourse = courseService.createCourse(courseRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ApiResponse<>(createdCourse, HttpStatus.CREATED));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<CourseResponseDTO>> getCourseById(@PathVariable Long id) {
        CourseResponseDTO course = courseService.getCourseById(id);
        return ResponseEntity.ok(new ApiResponse<>(course, HttpStatus.OK));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<CourseResponseDTO>> updateCourse(@PathVariable Long id, @RequestBody CourseRequestDTO courseRequestDTO) {
        CourseResponseDTO updatedCourse = courseService.updateCourse(id, courseRequestDTO);
        return ResponseEntity.ok(new ApiResponse<>(updatedCourse, HttpStatus.OK));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<String>> deleteCourse(@PathVariable Long id) {
        courseService.deleteCourse(id);
        return ResponseEntity.ok(new ApiResponse<>("Course deleted successfully", HttpStatus.OK));
    }
}
