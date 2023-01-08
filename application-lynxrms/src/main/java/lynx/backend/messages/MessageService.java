package lynx.backend.messages;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {

    @Autowired
    MessageRepository messageRepository;

    public void addMessage(Message message){
        messageRepository.save(message);
    }

    public void updateMessage(long id, Message message){
        messageRepository.save(message);
    }

    public void deleteMessage(long id){
        messageRepository.deleteById(id);
    }

    public Message getMessage(long id){
        return messageRepository.getById(id);
    }

    public List<Message> getAllMessages(){
        return messageRepository.findAll();
    }
}
