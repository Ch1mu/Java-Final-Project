package FinalProject.MvcMessages.Controllers.Apis.MessagesApi.Ports;

import FinalProject.MvcMessages.Controllers.Apis.MessagesApi.Adapters.ChatAdapter;
import FinalProject.MvcMessages.Controllers.Apis.MessagesApi.Adapters.MessageAdapter;
import FinalProject.MvcMessages.Models.Chat;
import FinalProject.MvcMessages.Models.Message;
import FinalProject.MvcMessages.Models.PersonPerChat;
import FinalProject.MvcMessages.Models.UserPerson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class ChatPort {
    @Autowired
    ChatAdapter cA;

    //SAVE
    public void newChat(ArrayList<UserPerson> ups, String chatName)
    {
        cA.newChat(ups, chatName);
    }
    public void newGroup(ArrayList<UserPerson> ups, String chatName)
    {
        cA.newGroup(ups,chatName);
    }
    //GET ALL
    public ArrayList<Chat> getAll()
    {
        return cA.findAll();
    }


    //GET BY ID
    public Chat getById(long chatId)
    {
        return cA.getById(chatId);
    }

    //GET BY ALL CHATS BY USER
    public List<Chat> getChatsPerUser(String user) {
        return cA.getChatsPerUser(user);
    }
    //GET ALL USERS PER CHAT
    public List<PersonPerChat> getAllUsersPerChat(long chatId) {
        return cA.getAllUsersPerChat(chatId);
    }


    //DELETE
    public void delete(long chatId, String user) {
        cA.delete(chatId, user);
    }
    public void addPersonToGroup(UserPerson ups, long chatId)
    {
         cA.addPersonToGroup(ups, chatId);
    }
}
