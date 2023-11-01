package view.connectFourPrototype;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class InitialStatePrototype {
    public static void main(String[] args) {
        JFrame mainFrame = new JFrame("Start New Game");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel backgroundPanel = new JPanel();
        backgroundPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        backgroundPanel.setBackground(new Color(1, 50, 32));

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));

        JPanel titlePanel = new JPanel();
        titlePanel.setBackground(new Color(1, 50, 32));

        JButton newGameButton = new JButton("Start New Game");
        newGameButton.setBackground(Color.white);

        JButton playerWinsButton = new JButton("Total Player Wins");
        playerWinsButton.setBackground(Color.white);

        newGameButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        playerWinsButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        buttonPanel.setBorder(BorderFactory.createEmptyBorder(100, 50, 50, 50));

        JLabel gameTitle = new JLabel("Connect Four");
        gameTitle.setAlignmentX(Component.CENTER_ALIGNMENT);
        gameTitle.setForeground(Color.WHITE);
        gameTitle.setFont(new Font("Serif", 5, 35));
        titlePanel.add(gameTitle);

        buttonPanel.add(newGameButton);
        buttonPanel.add(Box.createVerticalStrut(50));
        buttonPanel.add(playerWinsButton);
        buttonPanel.setBackground(new Color(1, 50, 32));

        backgroundPanel.add(titlePanel, BorderLayout.NORTH);
        backgroundPanel.add(buttonPanel, BorderLayout.CENTER);

        mainFrame.add(backgroundPanel, BorderLayout.CENTER);
        mainFrame.setPreferredSize(new Dimension(350, 500));
        mainFrame.pack();
        mainFrame.setVisible(true);
    }
}