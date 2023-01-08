package lynx.backend.messages;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    private String sender;
    private String recipient;
    private Date date;
    private String Subject;
    @Lob
    private String remarks;

    protected Message() {
    }

    public Message(long id, String sender, String recipient, Date dateSent,
                   String subject, String remarks) {
        this.id = id;
        this.sender = sender;
        this.recipient = recipient;
        this.date = dateSent;
        Subject = subject;
        this.remarks = remarks;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getSubject() {
        return Subject;
    }

    public void setSubject(String subject) {
        Subject = subject;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Message message = (Message) o;
        return id == message.id && Objects.equals(sender, message.sender) && Objects.equals(recipient, message.recipient) && Objects.equals(date, message.date) && Objects.equals(Subject, message.Subject) && Objects.equals(remarks, message.remarks);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, sender, recipient, date, Subject, remarks);
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", sender='" + sender + '\'' +
                ", recipient='" + recipient + '\'' +
                ", dateSent=" + date +
                ", Subject='" + Subject + '\'' +
                ", remarks='" + remarks + '\'' +
                '}';
    }
}
