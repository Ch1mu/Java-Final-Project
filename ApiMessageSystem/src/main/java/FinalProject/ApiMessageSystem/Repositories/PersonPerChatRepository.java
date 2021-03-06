package FinalProject.ApiMessageSystem.Repositories;

import FinalProject.ApiMessageSystem.Models.PersonPerChat;
import FinalProject.ApiMessageSystem.Models.UserPerson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonPerChatRepository extends JpaRepository<PersonPerChat, Long> {
    @Query(value = "SELECT * FROM person_per_chat ppc WHERE id_chat = :chatId AND username != :username",nativeQuery = true)
    public PersonPerChat getChatUserName(@Param("username") String username, @Param("chatId") long chatId);
    @Query(value = "SELECT *  FROM person_per_chat ppc WHERE id_chat = :chatId AND username = :username",nativeQuery = true)
    public PersonPerChat takeASinglePerson(@Param("chatId") long chatId, @Param("username") String username);
    @Query(value = "SELECT * FROM person_per_chat ppc WHERE id_chat = :chatId",nativeQuery = true)
    public List<PersonPerChat> getAllPersonsPerChat(@Param("chatId") long chatId);

}
