package SpringBoot.Project.Studifier.Responses;

public class QuizResponseDTO {
    private Long id;
    private String title;
    private String courseTitle;

    // Constructor
    public QuizResponseDTO(Long id, String title, String courseTitle) {
        this.id = id;
        this.title = title;
        this.courseTitle = courseTitle;
    }

    // Getters
    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getCourseTitle() {
        return courseTitle;
    }
}