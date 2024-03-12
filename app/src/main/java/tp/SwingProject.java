package tp;

import com.formdev.flatlaf.FlatLightLaf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

import javax.swing.*;
import javax.swing.plaf.basic.BasicButtonListener;

@ComponentScan("tp")
public class SwingProject extends JFrame {



    public static void main(String[] args) {
        FlatLightLaf.setup();
        var context = new AnnotationConfigApplicationContext(SwingProject.class);
        SwingUtilities.invokeLater(() -> {

            var swingProject = context.getBean(App.class);

            swingProject.setVisible(true);
        });
    }


}
