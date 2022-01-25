/*
    Date: January 25, 2021
    Created by: MinPen
    Purpose: Congrats Panel (When finishes the game) for the MainScreen Frame
*/

package mainscreenpanel;

import com.coding4buddies.batshooter.MainScreen;
import sharedmethods.Music;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;

public class CongratsPanel extends JPanel{
    
    // Initialize Needed Variables
    MainScreen mainScreen;
    int width, height;

    // Setting Up the Panel
    public CongratsPanel(MainScreen gameFrame) {
        this.mainScreen = gameFrame;
        width = gameFrame.getPreferredSize().width;
        height = gameFrame.getPreferredSize().height;
        new Music().shootEffect(this);
        initComponents();
    }

    // Method for initializing the needed components
    public void initComponents() {
        JLabel congrats = new JLabel();
        JLabel play_again = new JLabel("PLAY AGAIN?");
        JLabel back_menu = new JLabel("BACK TO MENU");

        congrats.setIcon(new ImageIcon("res/congrats.png"));

        buttonSetting(play_again);
        buttonSetting(back_menu);

        buttonClick(play_again);
        buttonClick(back_menu);

        this.add(Box.createVerticalStrut(570));
        this.add(congrats);
        this.add(Box.createRigidArea(new Dimension(width, -220)));
        this.add(play_again);
        this.add(Box.createRigidArea(new Dimension(width, 10)));
        this.add(back_menu);
    }

    // Method for the settings of Play and Exit Button
    public void buttonSetting(JLabel label){
        Image button1 = new ImageIcon("res/button1.png").getImage().getScaledInstance(260, 90, Image.SCALE_SMOOTH);
        label.setForeground(Color.BLACK);
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        label.setHorizontalTextPosition(JLabel.CENTER);
        label.setIcon(new ImageIcon(button1));
        customFont(label);
    }

    // Method for clicking the level button
    public void buttonClick(JLabel jlabel){
        jlabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (jlabel.getText().equals("PLAY AGAIN?")) {
                    mainScreen.showView(new LevelPanel(mainScreen));
                } else if(jlabel.getText().equals("BACK TO MENU")) {
                    mainScreen.showView(new MenuPanel(mainScreen));
                }
            }
        });
    }

    // Added Custom Font for the Buttons
    public void customFont(JLabel label) {
        try {
            //create the font to use. Specify the size!
            Font customFont = Font.createFont(Font.TRUETYPE_FONT, new File("res/LuckiestGuy.ttf")).deriveFont(25f);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            //register the font
            ge.registerFont(customFont);
            label.setFont(customFont);
        } catch (IOException | FontFormatException e ) {
            e.printStackTrace();
        }
    }

    @Override
    // Method for Changing the Background Image of the Panel
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Image i = new ImageIcon("res/main_screen.jpg").getImage();
        g.drawImage(i,0,0, width, height, null);
    }

}
