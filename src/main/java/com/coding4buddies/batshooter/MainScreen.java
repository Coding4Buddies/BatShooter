/*
    Date: January 22, 2021 
    Created by: MinPen
    Purpose: Main Frane of the Game when finishing the Splash Screen
*/

package com.coding4buddies.batshooter;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;
import mainscreenpanel.MenuPanel;

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
}
