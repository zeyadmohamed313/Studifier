package SpringBoot.Project.Studifier.Requests;

import jakarta.validation.constraints.NotNull;

public class EnrollmentRequestDTO {
    @NotNull(message = "Course ID is required")
    private Long courseId;

    @NotNull(message = "Student ID is required")
    private Long studentId;

    // Getters and setters
    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }
}