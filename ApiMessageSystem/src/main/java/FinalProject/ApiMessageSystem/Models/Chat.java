package FinalProject.ApiMessageSystem.Models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.catalina.User;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer"})
public class Chat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idChat;
    private String name;
    private boolean isGroup;
    public Chat(String name, boolean isGroup)
    {
        this.name = name;
        this.isGroup = isGroup;
        }

}
