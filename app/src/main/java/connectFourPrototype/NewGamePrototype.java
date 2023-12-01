package connectFourPrototype;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class NewGamePrototype {
    public static void main(String[] args) {
        JFrame mainFrame = new JFrame("Start New Game");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel backgroundPanel = new JPanel();
        backgroundPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        backgroundPanel.setBackground(new Color(1, 50, 32));

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));

        JButton autoPlayerButton = new JButton("Player vs. Bot");
        autoPlayerButton.setBackground(Color.white);

        JButton userButton = new JButton("Player vs. Player");
        userButton.setBackground(Color.white);

        autoPlayerButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        userButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        buttonPanel.setBorder(BorderFactory.createEmptyBorder(150, 50, 50, 50));

        buttonPanel.add(autoPlayerButton);
        buttonPanel.add(Box.createVerticalStrut(50));
        buttonPanel.add(userButton);
        buttonPanel.setBackground(new Color(1, 50, 32));

        backgroundPanel.add(buttonPanel, BorderLayout.CENTER);

        mainFrame.add(backgroundPanel, BorderLayout.CENTER);
        mainFrame.setPreferredSize(new Dimension(300, 500));
        mainFrame.pack();
        mainFrame.setVisible(true);
    }
}
