package SpringBoot.Project.Studifier.Repositories;

import SpringBoot.Project.Studifier.Models.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationRepository extends JpaRepository<Notification, Long> {
}
