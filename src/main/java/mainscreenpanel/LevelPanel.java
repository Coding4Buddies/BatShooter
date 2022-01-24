/*
    Date: January 23, 2021 
    Created by: MinPen
    Purpose: Level Panel (Consist of 9 Levels) for the MainScreen Frame
*/

package mainscreenpanel;

import com.coding4buddies.batshooter.MainScreen;
import com.fasterxml.jackson.databind.ObjectMapper;
import gamedata.LevelSystem;
import java.awt.*;
import java.util.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;

public class LevelPanel extends JPanel{
    
   // Initialize Needed Variables 
   private MainScreen mainScreen;
   LevelSystem levelSystem;
   int width, height;
   
   // Setting up the Panel
   public LevelPanel(MainScreen mainScreen){
       this.mainScreen = mainScreen;
       levelSystem = new LevelSystem();
       width = this.mainScreen.getPreferredSize().width;
       height = this.mainScreen.getPreferredSize().height;
       initComponents();
   }
   
   // Method for initializing the needed components
   public void initComponents() {
       JLabel lvl_text = new JLabel();
       lvl_text.setIcon(new ImageIcon("res/select_level.png"));
       
       this.add(Box.createVerticalStrut(300));
       this.add(lvl_text);
       this.add(Box.createRigidArea(new Dimension(width, -80)));
       addLevel();
   } 
   
   // Method that inserts a level button (based on the data inside the JSON file) 
   public void addLevel(){
       Image button = new ImageIcon("res/button2.png").getImage().getScaledInstance(300, 100, Image.SCALE_SMOOTH);
       for(String level: levelSystem.getLevel().keySet()){
           JLabel lvl = new JLabel(level);
           lvl.setIcon(new ImageIcon(button));
           lvl.setAlignmentX(Component.CENTER_ALIGNMENT); 
           lvl.setHorizontalTextPosition(JLabel.CENTER);
           lvl.setForeground(Color.BLACK);
           lvl.setCursor(new Cursor(Cursor.HAND_CURSOR));
           customFont(lvl);
           clickLevel(lvl);
           this.add(lvl);
           this.add(Box.createVerticalStrut(130));
       }
   }
   
   // Method for clicking the level button
   public void clickLevel(JLabel jlabel){
       jlabel.addMouseListener(new MouseAdapter() {
           @Override
           public void mousePressed(MouseEvent e) {
               LinkedHashMap<String, Object> numBats = new ObjectMapper().convertValue(
                       levelSystem.getLevel().get(jlabel.getText()), LinkedHashMap.class);
               mainScreen.showView(new PlayPanel(mainScreen, numBats));
           }
       });
   }
   
   // Added Custom Font for the Buttons
   public void customFont(JLabel label) {
       try {
            //create the font to use. Specify the size!
            Font customFont = Font.createFont(Font.TRUETYPE_FONT, new File("res/LuckiestGuy.ttf")).deriveFont(30f);
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
       g.drawImage(i,0,0,width, height, null);
   }
   
}
