package tp.view.component;

import org.springframework.stereotype.Component;
import tp.util.MessageService;

import javax.swing.*;
import java.awt.*;

@Component
public class Events extends JPanel {

    public Events(MessageService messageService) {

        JTextPane jTextPane = new JTextPane();
setLayout(new BorderLayout());
        jTextPane.setEditable(false); // Empêcher l'édition du texte
        setPreferredSize(new Dimension(300, 0)); // Taille par défaut
        setBorder(BorderFactory.createLineBorder(Color.BLACK)); // Bordure
        jTextPane.setContentType("text/html");
        this.add(new JScrollPane(jTextPane));
        messageService.addObserver((o, arg) -> {
            if (arg instanceof String) {
                String message = (String) arg;
                jTextPane.setText(messageService.getMessages().stream().map(s -> s + "<br>").reduce("", String::concat));
                scrollRectToVisible(new Rectangle(0,this.getBounds(null).height,1,1));
            }
        });
    }
}
