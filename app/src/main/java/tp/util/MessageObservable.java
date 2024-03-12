package tp.util;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Observable;
@Component
public class MessageObservable extends Observable {
    private ArrayList<String> messages = new ArrayList<>();

    // Ajouter un message à la liste et notifier les observateurs
    public void addMessage(String message) {
        messages.add(message);
        setChanged();
        notifyObservers(message);
    }

    // Obtenir la liste des messages
    public ArrayList<String> getMessages() {
        return messages;
    }
}
