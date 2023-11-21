package connectFour.view;

import connectFour.ControllerInterface;
import connectFour.Observer;
import connectFour.view.CircleButton;
import connectFour.model.ConnectFourGrid;
import connectFour.model.ConnectFourPiece;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ConnectFourGUI implements Observer{
    private ControllerInterface controller;
    private CircleButton[][] buttons;
    private ConnectFourGrid connectFour;
    private JLabel winnerLabel;
    private JPanel announcementPanel;
    private JPanel backgroundPanel;

    public ConnectFourGUI(ControllerInterface controller, ConnectFourGrid connectFour){
        this.controller = controller;
        this.connectFour = connectFour;
        this.connectFour.register(this);

        JFrame mainFrame = new JFrame("Connect Four");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        backgroundPanel = new JPanel();
        backgroundPanel.setBackground(new Color(1, 50, 32));

        JPanel buttonPanel = new JPanel(new GridLayout(6, 7,3,3));
        buttonPanel.setBackground(new Color(255, 255, 0));
        buttonPanel.setPreferredSize(new Dimension(470, 420));

        announcementPanel = new JPanel();
        announcementPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        announcementPanel.setBackground(new Color(1, 50, 32));

        buttons = new CircleButton[6][7];

        JButton newGameButton = new JButton("Start New Game");
        newGameButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                startNewGame();
            }
        });

        JButton winsButton = new JButton("Total Player Wins");

        winnerLabel = new JLabel(" ");
        winnerLabel.setFont(new Font("Serif", Font.BOLD, 24));
        winnerLabel.setForeground(Color.WHITE);
        announcementPanel.add(winnerLabel);

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

        backgroundPanel.add(announcementPanel, BorderLayout.NORTH);
        backgroundPanel.add(buttonPanel, BorderLayout.CENTER);
        backgroundPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JPanel optionsPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 5));
        optionsPanel.add(newGameButton);
        optionsPanel.add(winsButton);

        mainFrame.add(backgroundPanel, BorderLayout.CENTER);
        mainFrame.setPreferredSize(new Dimension(670, 570));
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

        if(this.connectFour.isGameOver()){
            for(int col = 0; col < 7; col++){
                for(int row = 0; row < 6; row++){
                    this.buttons[row][col].setEnabled(false);
                }
            }
            if(this.connectFour.getWinner()==null){
                winnerLabel.setText("Game Over - TIE");
            } else if(this.connectFour.getWinner() == ConnectFourPiece.R){
                winnerLabel.setText("Game Over - Red Player Wins!");
            }else{
                winnerLabel.setText("Game Over - Blue Player Wins!");
            }
        }
    }

    private void startNewGame(){

        winnerLabel.setText(" ");

        for(int col = 0; col < 7; col++){
            for(int row = 0; row < 6; row++){
                buttons[row][col].setEnabled(true);
            }
        }

        this.controller.resetGame();
    }
}