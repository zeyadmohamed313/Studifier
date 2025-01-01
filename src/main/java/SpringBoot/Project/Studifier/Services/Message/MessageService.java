package SpringBoot.Project.Studifier.Services.Message;


import SpringBoot.Project.Studifier.Repositories.MassegeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import SpringBoot.Project.Studifier.Models.Message;
import java.util.List;


@Service
public class MessageService implements IMessageService {
    @Autowired
    private MassegeRepository messageRepository;

    @Override
    public List<Message> getAllMessages() {
        return messageRepository.findAll();
    }

    @Override
    public Message getMessageById(Long id) {
        return messageRepository.findById(id).orElse(null);
    }

    @Override
    public Message createMessage(Message message) {
        return messageRepository.save(message);
    }

    @Override
    public Message updateMessage(Long id, Message message) {
        if(messageRepository.existsById(id)) {
            message.setId(id);
            return messageRepository.save(message);
        }
        return null;
    }

    @Override
    public void deleteMessage(Long id) {
        messageRepository.deleteById(id);
    }
}
