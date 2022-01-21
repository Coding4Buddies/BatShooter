/*
    Date: January 21, 2021 
    Created by: MinPen
    Purpose: Loading Screen of the Game
*/

package com.coding4buddies.batshooter;

import java.awt.*;
import javax.swing.*;

public class SplashScreen extends JFrame {
    
    // Initializing the variables needed in Splash Screen
    JProgressBar progressBar = new JProgressBar(0, 100);
    JLabel label = new JLabel("Loading...");
        
    // Setting up the Splash Screen
    public SplashScreen() {
       progressBar.setForeground(Color.RED);
       this.setUndecorated(true);
       this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       this.setSize(800, 500);
       this.setLocationRelativeTo(null);
       setBackground();
       addLoading();
    }
    
    // Method that Sets Image Background to the Splash Screen
    public void setBackground(){
        this.setContentPane(new JPanel() {
            @Override
            public void paintComponent(Graphics g) {
               Image i = new ImageIcon("res/image_splash.jpeg").getImage();			   
               super.paintComponent(g);
               g.drawImage(i, 0, 0, null);
            }
       });
    }
    
    // Method that insert the progress bar and label
    public void addLoading(){
        // Customize JLabel
        label.setFont(new Font("Arial", Font.PLAIN, 18));
        label.setForeground(Color.WHITE);
        label.setAlignmentX(Component.CENTER_ALIGNMENT);  
        
        progressBar.setMaximumSize(new Dimension(400,10));
        this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
        this.add(Box.createVerticalStrut(400));
        this.add(label);
        this.add(Box.createVerticalStrut(10));
        this.add(progressBar); 
    }
    
    // Method that makes the progress bar load
    public void iterate(){
        int i = 0;
        try {
            while(i <= 110){
                checkPercent(i);
                progressBar.setValue(i);
                //for animation
                Thread.sleep(50);//100 milliseconds
                i++;
            }
        } catch(Exception e){ }  
    }
    
    // Method that checks the percent in the Progress Bar
    public void checkPercent(int percent){
        if(percent == 110) {
            closeSplashScreen();
        }
    }
    
    // Method that dispose and close the Splash Screen
    public void closeSplashScreen(){
        this.dispose();
        System.exit(0);
    }
}
