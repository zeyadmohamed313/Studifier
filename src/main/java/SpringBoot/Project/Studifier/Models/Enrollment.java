package SpringBoot.Project.Studifier.Models;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Enrollment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)
    private User student;

    @ManyToOne
    @JoinColumn(name = "course_id", nullable = false)
    private Course course;

    @NotNull(message = "Enrollment date is mandatory")
    @PastOrPresent(message = "Enrollment date must be in the past or present")
    @Column(nullable = false)
    private LocalDate enrollmentDate;

    @NotNull(message = "Completion status is mandatory")
    private Boolean completed;

    @PositiveOrZero(message = "Progress percentage must be zero or a positive number")
    @Max(value = 100, message = "Progress percentage cannot exceed 100")
    @Column(nullable = false)
    private int progressPercentage;

    // Default constructor
    public Enrollment() {}

    // Parameterized constructor
    public Enrollment(User student, Course course, LocalDate enrollmentDate, Boolean completed, int progressPercentage) {
        this.student = student;
        this.course = course;
        this.enrollmentDate = enrollmentDate;
        this.completed = completed;
        this.progressPercentage = progressPercentage;
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getStudent() {
        return student;
    }

    public void setStudent(User student) {
        this.student = student;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public LocalDate getEnrollmentDate() {
        return enrollmentDate;
    }

    public void setEnrollmentDate(LocalDate enrollmentDate) {
        this.enrollmentDate = enrollmentDate;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }

    public int getProgressPercentage() {
        return progressPercentage;
    }

    public void setProgressPercentage(int progressPercentage) {
        this.progressPercentage = progressPercentage;
    }

    // toString method
    @Override
    public String toString() {
        return "Enrollment{" +
                "id=" + id +
                ", student=" + student +
                ", course=" + course +
                ", enrollmentDate=" + enrollmentDate +
                ", completed=" + completed +
                ", progressPercentage=" + progressPercentage +
                '}';
    }
}
