/*
    Date: January 22, 2021 
    Created by: MinPen
    Purpose: Main Frane of the Game when finishing the Splash Screen
*/

package com.coding4buddies.batshooter;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;

import mainscreenpanel.MenuPanel;
import sharedmethods.Music;

public class MainScreen extends JFrame{
    
    // Initialize the needed variables
    private JPanel viewPanel;

    //Setting up the Frame
    public MainScreen(){
       viewPanel = new JPanel(new BorderLayout());
       
       this.setTitle("Bat Shooter v.1.0");
       this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
       this.setPreferredSize(new Dimension(1080, 720));
       this.add(viewPanel, BorderLayout.CENTER);
       showView(new MenuPanel(this));
       customCursor();
       new Music().backgroundMusic();
       this.setVisible(true);
       this.pack();
       this.setLocationRelativeTo(null);
       this.setResizable(false);
    }
    
    // Method for changing the JPanel inside of the Frame
    public void showView(JPanel jPanel){
        viewPanel.removeAll();
        viewPanel.add(jPanel, BorderLayout.CENTER);
        viewPanel.revalidate();
        viewPanel.repaint();
    }

    // Change Cursor
    public void customCursor(){
        setCursor(Toolkit.getDefaultToolkit().createCustomCursor(
                new ImageIcon("res/aim.png").getImage().getScaledInstance(45,45,Image.SCALE_DEFAULT),
                new Point(0,0),"custom cursor"));
    }
}
