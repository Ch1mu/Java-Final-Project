package FinalProject.MvcMessages.Models.Security;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SecurityUser {
    private String username;
    private String password;
}
