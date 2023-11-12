package connectFour.view;

import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;
import java.awt.event.*;

public class CircleButton extends JButton {
    
    public CircleButton(String label){
        super(label);

        setBackground(new Color(1, 50, 32));
        setFocusable(false);

        Dimension size = getPreferredSize();
        size.width = size.height = Math.max(size.width, size.height);
        setPreferredSize(size);
        setContentAreaFilled(false);
    }

    protected void paintComponent(Graphics g){
        if(getModel().isArmed()){
            g.setColor(new Color(1, 50, 32));
        } else {
            g.setColor(getBackground());
        }
        g.fillOval(getSize().width/6, getSize().height / 6, getSize().width*2/3, getSize().height*2/3);

        super.paintComponent(g);
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

