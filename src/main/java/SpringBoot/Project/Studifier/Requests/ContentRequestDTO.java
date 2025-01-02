package SpringBoot.Project.Studifier.Requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.URL;

public class ContentRequestDTO {
    @NotBlank(message = "Title is mandatory")
    @Size(min = 5, max = 100, message = "Title must be between 5 and 100 characters")
    private String title;

    @NotBlank(message = "Type is mandatory")
    private String type; // e.g., VIDEO, TEXT, QUIZ

    @NotBlank(message = "URL is mandatory")
    @URL(message = "URL must be valid")
    private String url;

    @NotNull(message = "Course ID is mandatory")
    private Long courseId;

    // Getters and setters
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }
}