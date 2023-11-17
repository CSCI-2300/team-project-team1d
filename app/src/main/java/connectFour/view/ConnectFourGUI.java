package connectFour.view;

import connectFour.ControllerInterface;
import connectFour.Observer;
import connectFour.view.CircleButton;
import connectFour.model.ConnectFourGrid;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ConnectFourGUI implements Observer
{
    private ControllerInterface controller;
    private CircleButton[][] buttons;
    private ConnectFourGrid connectFour;

    public ConnectFourGUI(ControllerInterface controller, ConnectFourGrid connectFour){
        this.controller = controller;
        this.connectFour = connectFour;
        this.connectFour.register(this);

        JFrame mainFrame = new JFrame("Connect Four");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel backgroundPanel = new JPanel();
        backgroundPanel.setBackground(new Color(1, 50, 32));

        JPanel buttonPanel = new JPanel(new GridLayout(6, 7,3,3));
        buttonPanel.setBackground(new Color(255, 255, 0));
        buttonPanel.setPreferredSize(new Dimension(450, 400));

        buttons = new CircleButton[6][7];

        JButton newGameButton = new JButton("Start New Game");

        JButton winsButton = new JButton("Total Player Wins");

        for (int i = 0; i < 42; i++) {
            CircleButton playerButton = new CircleButton(" ");
            int col = i % 7;

            playerButton.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent e)
                {
                    int clickedColumn = col;
                    controller.userPressed(clickedColumn);
                }
            });
            buttons[i / 7][col] = playerButton;

            buttonPanel.add(playerButton);
        }
        
        backgroundPanel.add(buttonPanel, BorderLayout.CENTER);
        backgroundPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JPanel optionsPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 5));
        optionsPanel.add(newGameButton);
        optionsPanel.add(winsButton);

        mainFrame.add(backgroundPanel, BorderLayout.CENTER);
        mainFrame.setPreferredSize(new Dimension(650, 520));
        mainFrame.add(optionsPanel, BorderLayout.SOUTH);
        mainFrame.pack();
        mainFrame.setVisible(true);
    }

    @Override
    public void update(){
        for(int col = 0; col < 7; col++){
            for(int row = 0; row < 6; row++){
                CircleButton button = buttons[row][col];
                int player = controller.getPlayerColor(row, col);
                if(player != 0){
                    button.setColor(player == 1 ? Color.RED : Color.BLUE);
                } else {
                    button.setColor(new Color(1, 50, 32));
                }
            }
        }
    }
}