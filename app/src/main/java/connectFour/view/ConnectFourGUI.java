package connectFour.view;

import connectFour.ControllerInterface;
import connectFour.Observer;
import connectFour.view.*;
import connectFour.model.*;
import connectFour.controller.*;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ConnectFourGUI implements Observer{
    private ControllerInterface controller;
    private CircleButton[][] buttons;
    private ConnectFourGrid connectFour;
    private JLabel winnerLabel;
    private JLabel totalWinsLabel;
    private JPanel announcementPanel;
    private JPanel backgroundPanel;
    private JPanel totalWinsPanel;
    private JFrame mainFrame;

    public ConnectFourGUI(){
        startMenu();
    }

    private void startMenu(){
        mainFrame = new JFrame("Start Menu");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel menuPanel = new JPanel(new GridLayout(0, 1, 0, 20));
        menuPanel.setBackground(new Color(1, 50, 32));

        JPanel gameTitlePanel = new JPanel();
        gameTitlePanel.setBackground(new Color(1, 50, 32));

        JLabel gameTitle = new JLabel("Connect Four!");
        gameTitle.setFont(new Font("Monospace", Font.BOLD, 50));
        gameTitle.setForeground(Color.YELLOW);

        gameTitlePanel.add(gameTitle);

        JButton newGameButton = new JButton("Start New Game");
        startMenuButtons(newGameButton);
        newGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                showGameOptions();
            }
        });

        menuPanel.add(gameTitlePanel);
        menuPanel.add(newGameButton);

        mainFrame.add(menuPanel);
        mainFrame.setPreferredSize(new Dimension(600, 350));

        mainFrame.pack();
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setVisible(true);
    }

    private void showGameOptions() {
        mainFrame.dispose();
        
        connectFour = new ConnectFourGrid();

        JFrame playerOptionFrame = new JFrame("Start Menu");
        playerOptionFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel optionsPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        optionsPanel.setBackground(new Color(1, 50, 32));

        JLabel optionTitle = new JLabel("Select a game mode:");
        optionTitle.setFont(new Font("Monospace", Font.BOLD, 40));
        optionTitle.setForeground(Color.YELLOW);

        JButton playerVsPlayer = new JButton("Player vs. Player");
        JButton playerVsComp = new JButton("Player vs. Computer");

        startMenuButtons(playerVsPlayer);
        startMenuButtons(playerVsComp);

        playerVsPlayer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                showGame(new TwoPlayerController(connectFour));
                playerOptionFrame.dispose();
            }
        });

        playerVsComp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                showGame(new AutoPlayerController(connectFour, new NormalAutoPlayer(connectFour)));
                playerOptionFrame.dispose();
            }
        });

        optionsPanel.add(optionTitle);
        optionsPanel.add(playerVsPlayer);
        optionsPanel.add(playerVsComp);

        playerOptionFrame.add(optionsPanel);
        playerOptionFrame.setPreferredSize(new Dimension(600, 350));
        playerOptionFrame.pack();
        playerOptionFrame.setLocationRelativeTo(null);
        playerOptionFrame.setVisible(true);
    }

    private void startMenuButtons(JButton button){
        button.setPreferredSize(new Dimension(300, 70));
        button.setFont(new Font("Monospace", Font.BOLD, 20));
        button.setBackground(new Color(1, 80, 40));
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setBorderPainted(false);
        button.setMargin(new Insets(10, 20, 10, 20));
    }

    private void showGame(ControllerInterface controller){
        mainFrame.dispose();

        this.controller = controller;
        this.connectFour.register(this);

        JFrame gameFrame = new JFrame("Connect Four");
        gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        backgroundPanel = new JPanel();
        backgroundPanel.setBackground(new Color(1, 50, 40));

        JPanel buttonPanel = new JPanel(new GridLayout(6, 7,3,3));
        buttonPanel.setBackground(new Color(255, 255, 0));
        buttonPanel.setPreferredSize(new Dimension(500, 450));

        announcementPanel = new JPanel();
        announcementPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        announcementPanel.setBackground(new Color(1, 50, 40));

        buttons = new CircleButton[6][7];

        JButton newGameButton = new JButton("Start Over");

        newGameButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                startNewGame();
            }
        });

        JButton mainMenuButton = new JButton("Main Menu");
        mainMenuButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                controller.userQuit();
                new ConnectFourGUI();
                gameFrame.dispose();
            }
        });

        totalWinsLabel = new JLabel("Red Wins: "+controller.getRedWins()+"\nBlue Wins: "+controller.getYellowWins());
        totalWinsLabel.setForeground(Color.YELLOW);

        totalWinsPanel = new JPanel();
        totalWinsPanel.setBackground(new Color(1, 50, 32));
        totalWinsPanel.add(totalWinsLabel);

        winnerLabel = new JLabel(" ");
        winnerLabel.setFont(new Font("Monospace", Font.BOLD, 30));
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

        backgroundPanel.add(totalWinsPanel, BorderLayout.WEST);
        backgroundPanel.add(announcementPanel, BorderLayout.NORTH);
        backgroundPanel.add(buttonPanel, BorderLayout.CENTER);
        backgroundPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JPanel optionsPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 5));
        optionsPanel.add(newGameButton);
        optionsPanel.add(mainMenuButton);

        gameFrame.add(backgroundPanel, BorderLayout.CENTER);
        gameFrame.setPreferredSize(new Dimension(720, 630));
        gameFrame.add(optionsPanel, BorderLayout.SOUTH);

        gameFrame.addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e){
                controller.userQuit();
            }
        });

        gameFrame.pack();
        gameFrame.setLocationRelativeTo(null);
        gameFrame.setVisible(true);
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
                this.connectFour.recordWin();
                winnerLabel.setText("<html>Game Over - <font color='red'>RED</font> Player Wins!</html>");
            }else{
                this.connectFour.recordWin();
                winnerLabel.setText("<html>Game Over - <font color='blue'>BLUE</font> Player Wins!</html>");
            }

            updateTotalWins();
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

    private void updateTotalWins(){
        totalWinsLabel.setText("Red Wins: "+controller.getRedWins()+"\nBlue Wins: "+controller.getYellowWins());
    }
}