package SpringBoot.Project.Studifier.Controllers;

import SpringBoot.Project.Studifier.Models.Enrollment;
import SpringBoot.Project.Studifier.Requests.EnrollmentRequestDTO;
import SpringBoot.Project.Studifier.Responses.EnrollmentResponseDTO;
import SpringBoot.Project.Studifier.Services.Enrollment.EnrollmentService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PutMapping;
import SpringBoot.Project.Studifier.Helpers.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


    @RestController
    @RequestMapping("/api/enrollments")
    public class EnrollmentController {
        @Autowired
        private EnrollmentService enrollmentService;

        @GetMapping("/all")
        public ResponseEntity<ApiResponse<List<EnrollmentResponseDTO>>> getAllEnrollments() {
            List<EnrollmentResponseDTO> enrollments = enrollmentService.getAllEnrollments();
            return ResponseEntity.ok(new ApiResponse<>(enrollments, HttpStatus.OK));
        }

        @PostMapping
        public ResponseEntity<ApiResponse<EnrollmentResponseDTO>> createEnrollment(@RequestBody @Valid EnrollmentRequestDTO enrollmentRequestDTO) {
            EnrollmentResponseDTO createdEnrollment = enrollmentService.createEnrollment(enrollmentRequestDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(new ApiResponse<>(createdEnrollment, HttpStatus.CREATED));
        }

        @GetMapping("/{id}")
        public ResponseEntity<ApiResponse<EnrollmentResponseDTO>> getEnrollmentById(@PathVariable Long id) {
            EnrollmentResponseDTO enrollment = enrollmentService.getEnrollmentById(id);
            return ResponseEntity.ok(new ApiResponse<>(enrollment, HttpStatus.OK));
        }

        @PutMapping("/{id}")
        public ResponseEntity<ApiResponse<EnrollmentResponseDTO>> updateEnrollment(
                @PathVariable Long id, @RequestBody @Valid EnrollmentRequestDTO enrollmentRequestDTO) {
            EnrollmentResponseDTO updatedEnrollment = enrollmentService.updateEnrollment(id, enrollmentRequestDTO);
            return ResponseEntity.ok(new ApiResponse<>(updatedEnrollment, HttpStatus.OK));
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<ApiResponse<String>> deleteEnrollment(@PathVariable Long id) {
            enrollmentService.deleteEnrollment(id);
            return ResponseEntity.ok(new ApiResponse<>("Enrollment deleted successfully", HttpStatus.OK));
        }
    }

