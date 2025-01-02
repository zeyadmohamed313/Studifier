package SpringBoot.Project.Studifier.Responses;


public class CourseResponseDTO {
    private Long id;
    private String title;
    private String description;
    private String instructorName;

    // Default constructor
    public CourseResponseDTO() {}

    // Parameterized constructor
    public CourseResponseDTO(Long id, String title, String description, String instructorName) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.instructorName = instructorName;
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getInstructorName() {
        return instructorName;
    }

    public void setInstructorName(String instructorName) {
        this.instructorName = instructorName;
    }
}

