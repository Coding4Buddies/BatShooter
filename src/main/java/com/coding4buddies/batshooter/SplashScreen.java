/*
    Date: January 21, 2021 
    Created by: MinPen
    Purpose: Loading Screen of the Game
*/

package com.coding4buddies.batshooter;

import java.awt.*;
import java.util.Random;
import javax.swing.*;

public class SplashScreen extends JFrame {
    
    // Initializing the variables needed in Splash Screen
    JProgressBar progressBar = new JProgressBar(0, 200);
    JLabel label = new JLabel("Did you know that Baby bats are called pups!");
        
    // Setting up the Splash Screen
    public SplashScreen() {
       this.setUndecorated(true);
       this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       this.setSize(800, 500);
       this.setLocationRelativeTo(null);
       this.setIconImage(Toolkit.getDefaultToolkit().getImage("res/icon.png"));
       setBackground();
       addLoading();
       changeText();
    }
    
    // Method that Sets Image Background to the Splash Screen
    public void setBackground(){
        this.setContentPane(new JPanel() {
            @Override
            public void paintComponent(Graphics g) {
               Image i = new ImageIcon("res/image_splash.jpg").getImage();			   
               super.paintComponent(g);
               g.drawImage(i,0,0,null);
            }
       });
    }
    
    // Method that insert the progress bar and label
    public void addLoading(){

        // Customize JLabel
        label.setFont(new Font("Arial", Font.BOLD, 15));
        label.setForeground(Color.WHITE);
        label.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Customize JProgressBar
        progressBar.setMaximumSize(new Dimension(350,10));
        progressBar.setForeground(new Color(130, 192, 207));
        progressBar.setBackground(new Color(12, 24,68));
        progressBar.setBorderPainted(false);
        progressBar.setAlignmentX(Component.CENTER_ALIGNMENT);

        this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
        this.add(Box.createVerticalStrut(350));
        this.add(label);
        this.add(Box.createVerticalStrut(10));
        this.add(progressBar);
    }
    
    // Method that makes the progress bar load
    public void iterate(){
        int i = 0;
        try {
            while(i <= 210){
                checkPercent(i);
                progressBar.setValue(i);
                Thread.sleep(60);
                i++;
            }
        } catch(Exception e){
            e.printStackTrace();
        }
    }

    // Method that changes the text every 2 seconds
    public void changeText(){
        String[] facts = {
                "Did you know that bats can find their food in total darkness.",
                "Did you know that Pallid bats eat scorpions!",
                "Did you know that there are over 1,400 species of bats worldwide.",
                "Did you know that not all bats hibernate."
        };

       Timer t = new Timer(2000, e -> {
           Random rand = new Random();
           String get = facts[rand.nextInt(facts.length)];
           label.setText(get);
       });

       t.setRepeats(true);
       t.start();
    }
    
    // Method that checks the percent in the Progress Bar
    public void checkPercent(int percent){
        if(percent == 210) {
            openMainScreen();
            closeSplashScreen();
        }
    }
    
    // Method that dispose and close the Splash Screen
    public void closeSplashScreen(){
        this.dispose();
    }
    
    public void openMainScreen(){
        new MainScreen();
    }
}
