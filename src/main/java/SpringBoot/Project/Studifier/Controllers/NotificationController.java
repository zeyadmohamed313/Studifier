package SpringBoot.Project.Studifier.Controllers;
import SpringBoot.Project.Studifier.Helpers.ApiResponse;
import SpringBoot.Project.Studifier.Models.Course;
import SpringBoot.Project.Studifier.Models.Notification;
import SpringBoot.Project.Studifier.Services.Course.CourseService;
import SpringBoot.Project.Studifier.Services.Notification.NotificationService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notifications")
public class NotificationController {
    @Autowired
    private NotificationService notificationService;

    @GetMapping
    public ResponseEntity<ApiResponse<List<Notification>>> getAllNotifications() {
        return ResponseEntity.ok(new ApiResponse<>(true, "Notifications fetched successfully", notificationService.getAllNotifications()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Notification>> getNotificationById(@PathVariable Long id) {
        Notification notification = notificationService.getNotificationById(id);
        if (notification == null) throw new EntityNotFoundException("Notification with ID " + id + " not found");
        return ResponseEntity.ok(new ApiResponse<>(true, "Notification fetched successfully", notification));
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Notification>> createNotification(@RequestBody Notification notification) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new ApiResponse<>(true, "Notification created successfully", notificationService.createNotification(notification)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Notification>> updateNotification(@PathVariable Long id, @RequestBody Notification updatedNotification) {
        Notification notification = notificationService.updateNotification(id, updatedNotification);
        if (notification == null) throw new EntityNotFoundException("Notification with ID " + id + " not found");
        return ResponseEntity.ok(new ApiResponse<>(true, "Notification updated successfully", notification));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteNotification(@PathVariable Long id) {
        notificationService.deleteNotification(id);
        return ResponseEntity.ok(new ApiResponse<>(true, "Notification deleted successfully", null));
    }
}
