package SpringBoot.Project.Studifier.Models;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.URL;


import java.time.LocalDate;

@Entity
public class Content {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Title is mandatory")
    @Size(min = 5, max = 100, message = "Title must be between 5 and 100 characters")
    @Column(nullable = false)
    private String title;

    @NotBlank(message = "Type is mandatory")
    @Column(nullable = true)
    private String type; // e.g., VIDEO, TEXT, QUIZ

    @NotBlank(message = "URL is mandatory")
    @URL(message = "URL must be valid")
    @Column(nullable = false)
    private String url;

    @NotNull(message = "Creation date is mandatory")
    @PastOrPresent(message = "Creation date must be in the past or present")
    @Column(nullable = true)
    private LocalDate creationDate = LocalDate.now();

    @ManyToOne
    @JoinColumn(name = "course_id", nullable = false)
    private Course course;

    // Default constructor
    public Content() {}

    // Parameterized constructor
    public Content(String title, String type, String url, LocalDate creationDate, Course course) {
        this.title = title;
        this.type = type;
        this.url = url;
        this.creationDate = creationDate;
        this.course = course;
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

    public LocalDate getCreationDate() {
        return creationDate;
    }

    @PrePersist
    private void setDefaultCreationDate() {
        if (this.creationDate == null) {
            this.creationDate = LocalDate.now();
        }
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    // toString method
    @Override
    public String toString() {
        return "Content{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", type='" + type + '\'' +
                ", url='" + url + '\'' +
                ", creationDate=" + creationDate +
                ", course=" + course +
                '}';
    }
}
