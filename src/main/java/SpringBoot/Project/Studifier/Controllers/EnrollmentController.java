package SpringBoot.Project.Studifier.Controllers;

import SpringBoot.Project.Studifier.Models.Enrollment;
import SpringBoot.Project.Studifier.Services.Enrollment.EnrollmentService;
import org.springframework.web.bind.annotation.PutMapping;
import SpringBoot.Project.Studifier.Helpers.ApiResponse;
import SpringBoot.Project.Studifier.Models.Course;
import SpringBoot.Project.Studifier.Services.Course.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/enrollments")

public class EnrollmentController {
    @Autowired
    private EnrollmentService enrollmentService;

    @GetMapping
    public ResponseEntity<ApiResponse<List<Enrollment>>> getAllEnrollments() {
        List<Enrollment> enrollments = enrollmentService.getAllEnrollments();
        return ResponseEntity.ok(new ApiResponse<>(true, "Fetched all enrollments successfully", enrollments));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Enrollment>> getEnrollmentById(@PathVariable Long id) {
        Enrollment enrollment = enrollmentService.getEnrollmentById(id);
        if (enrollment == null) {
            return ResponseEntity.ok(new ApiResponse<>(false, "Enrollment not found", null));
        }
        return ResponseEntity.ok(new ApiResponse<>(true, "Enrollment fetched successfully", enrollment));
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Enrollment>> createEnrollment(@RequestBody Enrollment enrollment) {
        Enrollment createdEnrollment = enrollmentService.createEnrollment(enrollment);
        return ResponseEntity.ok(new ApiResponse<>(true, "Enrollment created successfully", createdEnrollment));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Enrollment>> updateEnrollment(@PathVariable Long id, @RequestBody Enrollment updatedEnrollment) {
        Enrollment enrollment = enrollmentService.updateEnrollment(id, updatedEnrollment);
        if (enrollment == null) {
            return ResponseEntity.ok(new ApiResponse<>(false, "Enrollment not found", null));
        }
        return ResponseEntity.ok(new ApiResponse<>(true, "Enrollment updated successfully", enrollment));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteEnrollment(@PathVariable Long id) {
        enrollmentService.deleteEnrollment(id);
        return ResponseEntity.ok(new ApiResponse<>(true, "Enrollment deleted successfully", null));
    }
}