package connectFour.view;

import java.awt.*;
import javax.swing.*;

public class CircleButton extends JButton {
    
    public CircleButton(String label){
        super(label);

        setBackground(new Color(1, 50, 40));
        setFocusable(false);

        Dimension size = getPreferredSize();
        size.width = size.height = Math.max(size.width, size.height);
        setPreferredSize(size);
        setContentAreaFilled(false);
    }

    protected void paintComponent(Graphics g){
        super.paintComponent(g);

        if(getModel().isArmed()){
            g.setColor(new Color(1, 50, 40));
        } else {
            g.setColor(getBackground());
        }
        g.fillOval(getSize().width/6, getSize().height / 6, getSize().width*2/3, getSize().height*2/3);
    }

    protected void paintBorder(Graphics g){
        g.setColor(Color.black);
        g.drawOval(getSize().width/6, getSize().height / 6, getSize().width*2/3, getSize().height*2/3);
    }

    public void setColor(Color color){
        setBackground(color);
        repaint();
    }
}

