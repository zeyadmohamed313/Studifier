package SpringBoot.Project.Studifier.Controllers;
import SpringBoot.Project.Studifier.Helpers.ApiResponse;
import SpringBoot.Project.Studifier.Models.Course;
import SpringBoot.Project.Studifier.Models.Message;
import SpringBoot.Project.Studifier.Services.Course.CourseService;
import SpringBoot.Project.Studifier.Services.Message.MessageService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/messages")
public class MessageController {
    @Autowired
    private MessageService messageService;

    @GetMapping
    public ResponseEntity<ApiResponse<List<Message>>> getAllMessages() {
        return ResponseEntity.ok(new ApiResponse<>(true, "Messages fetched successfully", messageService.getAllMessages()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Message>> getMessageById(@PathVariable Long id) {
        Message message = messageService.getMessageById(id);
        if (message == null) throw new EntityNotFoundException("Message with ID " + id + " not found");
        return ResponseEntity.ok(new ApiResponse<>(true, "Message fetched successfully", message));
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Message>> createMessage(@RequestBody Message message) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new ApiResponse<>(true, "Message created successfully", messageService.createMessage(message)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Message>> updateMessage(@PathVariable Long id, @RequestBody Message updatedMessage) {
        Message message = messageService.updateMessage(id, updatedMessage);
        if (message == null) throw new EntityNotFoundException("Message with ID " + id + " not found");
        return ResponseEntity.ok(new ApiResponse<>(true, "Message updated successfully", message));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteMessage(@PathVariable Long id) {
        messageService.deleteMessage(id);
        return ResponseEntity.ok(new ApiResponse<>(true, "Message deleted successfully", null));
    }
}
