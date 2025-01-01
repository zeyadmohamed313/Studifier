package SpringBoot.Project.Studifier.Services.Message;


import SpringBoot.Project.Studifier.Models.Message;
import java.util.List;

public interface IMessageService {
    List<Message> getAllMessages();
    Message getMessageById(Long id);
    Message createMessage(Message message);
    Message updateMessage(Long id, Message message);
    void deleteMessage(Long id);
}
