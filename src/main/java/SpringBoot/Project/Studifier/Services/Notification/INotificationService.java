package SpringBoot.Project.Studifier.Services.Notification;


import SpringBoot.Project.Studifier.Models.Notification;
import java.util.List;

public interface INotificationService {
    List<Notification> getAllNotifications();
    Notification getNotificationById(Long id);
    Notification createNotification(Notification notification);
    Notification updateNotification(Long id, Notification notification);
    void deleteNotification(Long id);
}
