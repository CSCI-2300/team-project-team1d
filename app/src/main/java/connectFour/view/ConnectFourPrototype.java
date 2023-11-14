package connectFour.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ConnectFourPrototype extends JButton{
    private CircleButton[][] buttons;
    private Color currentPlayerColor;

    public ConnectFourPrototype(){
        JFrame mainFrame = new JFrame("Connect Four");
    }
    public static void main(String[] args) {
        JFrame mainFrame = new JFrame("Connect Four");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel backgroundPanel = new JPanel();
        backgroundPanel.setBackground(new Color(1, 50, 32));

        JPanel buttonPanel = new JPanel(new GridLayout(6, 7,3,3));
        buttonPanel.setBackground(new Color(255, 255, 0));
        buttonPanel.setPreferredSize(new Dimension(450, 400));

        JButton newGameButton = new JButton("Start New Game");

        JButton autoPlayerButton = new JButton("Player vs. Bot");

        JButton userButton = new JButton("Player vs. Player");

        JButton winsButton = new JButton("Total Player Wins");

        for (int i = 0; i < 42; i++) {
            CircleButton playerButton = new CircleButton(" ");
            playerButton.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e){
                    CircleButton buttonClicked = (CircleButton) e.getSource();
                    buttonClicked.setColor(Color.blue);
                    buttonClicked.setEnabled(false);
                }
            });
            if((i==39) || (i == 40) || (i == 41)){
                playerButton.setColor(Color.red);
                playerButton.setEnabled(false);
            }
            buttonPanel.add(playerButton);
        }
        
        backgroundPanel.add(buttonPanel, BorderLayout.CENTER);
        backgroundPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JPanel optionsPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 5));
        optionsPanel.add(newGameButton);
        //optionsPanel.add(autoPlayerButton);
        //optionsPanel.add(userButton);
        optionsPanel.add(winsButton);

        mainFrame.add(backgroundPanel, BorderLayout.CENTER);
        mainFrame.setPreferredSize(new Dimension(650, 520));
        mainFrame.add(optionsPanel, BorderLayout.SOUTH);
        mainFrame.pack();
        mainFrame.setVisible(true);
    }

}
