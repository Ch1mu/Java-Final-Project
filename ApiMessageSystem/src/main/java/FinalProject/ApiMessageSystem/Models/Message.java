package FinalProject.ApiMessageSystem.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.sql.Date;
import java.sql.Timestamp;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idMessage;
    @NotEmpty
    private String content;
    private Timestamp date;

    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "username")
    private UserPerson uP;

    public Message(String content)
    {
        this.content = content;
        this.date = new java.sql.Timestamp(new java.util.Date().getTime());
    }

}
