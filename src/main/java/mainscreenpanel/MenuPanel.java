/*
    Date: January 23, 2021 
    Created by: MinPen
    Purpose: Menu Panel (Consist of Play and Exit button) for the MainScreen Frame
*/

package mainscreenpanel;

import com.coding4buddies.batshooter.MainScreen;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;

public class MenuPanel extends JPanel {
    
   // Initialize Needed Variables 
   private MainScreen mainScreen;
   int width, height;

   // Setting up the Main Panel
   public MenuPanel(MainScreen mainScreen){
       this.mainScreen = mainScreen;
       width = this.mainScreen.getPreferredSize().width;
       height = this.mainScreen.getPreferredSize().height;
       initComponents();
   }
   
   // Method for initializing the needed components
   public void initComponents() {
       JLabel logo = new JLabel();
       JLabel play = new JLabel("PLAY");
       JLabel exit = new JLabel("EXIT");
              
       logo.setAlignmentX(Component.CENTER_ALIGNMENT); 
       logo.setIcon(new ImageIcon("res/logo.png"));
       
       buttonSetting(play);
       buttonSetting(exit);
       
       buttonClick(play);
       buttonClick(exit);
       
       this.add(Box.createVerticalStrut(350));
       this.add(logo);
       this.add(Box.createRigidArea(new Dimension(width, 0)));
       this.add(play);
       this.add(Box.createRigidArea(new Dimension(width, 10)));
       this.add(exit);
   }
   
   // Method for the settings of Play and Exit Button
   public void buttonSetting(JLabel label){
       Image button1 = new ImageIcon("res/button1.png").getImage().getScaledInstance(260, 90, Image.SCALE_SMOOTH);
       label.setAlignmentX(Component.CENTER_ALIGNMENT); 
       label.setHorizontalTextPosition(JLabel.CENTER);
       label.setCursor(new Cursor(Cursor.HAND_CURSOR));
       label.setIcon(new ImageIcon(button1));
       customFont(label);
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
        } catch (IOException e ) {
            e.printStackTrace();
        } catch(FontFormatException e) {
            e.printStackTrace();
        }
   }
   
   // Method for the Clicking the Buttons
   public void buttonClick(JLabel jlabel){
       jlabel.addMouseListener(new MouseAdapter() {
           @Override
           public void mousePressed(MouseEvent e) {
               if (jlabel.getText() == "PLAY") {
                   System.out.println("PLAY");
               } else if(jlabel.getText() == "EXIT") {
                   System.exit(0);
               }
           }
       });
   }
   
   
   @Override
   // Method for Changing the Background Image of the Panel
   protected void paintComponent(Graphics g) {
       super.paintComponent(g);
       Image i = new ImageIcon("res/main_screen.jpg").getImage();
       g.drawImage(i,0,0,width, height, null);
   }
}
