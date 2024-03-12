package tp.view.component.map;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import org.springframework.stereotype.Component;
import tp.Personnage;
import tp.PersonnageSingleton;
import tp.services.WorldMapService;

@Component
public class PixelMap extends JPanel  implements KeyListener {
    private final Personnage personnage;
    private WorldMapService worldMapService;


    public PixelMap(WorldMapService worldMapService, PersonnageSingleton personnageSingleton) {
        addKeyListener(this);
        personnage = personnageSingleton.getInstance();
        this.worldMapService = worldMapService;
        this.setSize(500, 500);
        this.setPreferredSize(new Dimension(500, 500));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g1 = (Graphics2D) g;
        String asciiMap = worldMapService.getMap();
        int cellSize = 10; // Adjust cell size as needed
        int x = 0;
        int y = 0;
        for (int i = 0; i < asciiMap.length(); i++) {
            char c = asciiMap.charAt(i);
            if (c == '\n') {
                x = 0;
                y += cellSize;
                continue;
            }

            var color = getColorIndex(c);
            g1.setColor(color);
            g1.fillRect(x, y, cellSize, cellSize);
            x += cellSize;
        }
        // Draw player character
        g1.setColor(Color.YELLOW); // Change color to represent player character
        g1.fillRect(this.personnage.x * cellSize, personnage.y * cellSize, cellSize, cellSize);

    }

    private Color getColorIndex(char c) {
        if (c == 'A') return new Color(60, 150, 170);
        else if (c == 'D') return new Color(215, 235, 235);
        else if (c == 'G') return new Color(70, 175, 100);
        else if (c == 'J') return new Color(225, 215, 145);
        else if (c == 'M') return new Color(125, 105, 90);
        else if (c == 'P') return new Color(86, 71, 61);
        else return Color.white;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        switch (keyCode) {
            case KeyEvent.VK_UP:
                if (personnage.y > 0) personnage.y--;
                break;
            case KeyEvent.VK_DOWN:
                if (personnage.y < getHeight() / 10 - 1) personnage.y++;
                break;
            case KeyEvent.VK_LEFT:
                if (personnage.x > 0) personnage.x--;
                break;
            case KeyEvent.VK_RIGHT:
                if (personnage.x < getWidth() / 10 - 1) personnage.x++;
                break;
        }
        repaint(); // Redraw the panel after the player's position changes
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
