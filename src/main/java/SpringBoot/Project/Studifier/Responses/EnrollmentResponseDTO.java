package SpringBoot.Project.Studifier.Responses;

public class EnrollmentResponseDTO {
    private Long id;
    private String courseTitle;
    private String studentName;

    // Constructor
    public EnrollmentResponseDTO(Long id, String courseTitle, String studentName) {
        this.id = id;
        this.courseTitle = courseTitle;
        this.studentName = studentName;
    }

    // Getters
    public Long getId() {
        return id;
    }

    public String getCourseTitle() {
        return courseTitle;
    }

    public String getStudentName() {
        return studentName;
    }
}
