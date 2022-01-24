/*
    Date: January 24, 2021 
    Created by: MinPen
    Purpose: Play Panel (Shoot the Bats that Move) for the MainScreen Frame
*/

package mainscreenpanel;

import com.coding4buddies.batshooter.MainScreen;
import bat.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;

public class PlayPanel extends JPanel{
    
   // Initialize Needed Variables 
   private MainScreen mainScreen;
   int width, height;
   private boolean isClick = false;
   LinkedList<Bat> batList = new LinkedList<>();

   
   // Setting Up the Panel
   public PlayPanel(MainScreen mainScreen) {
       this.mainScreen = mainScreen;
       width = this.mainScreen.getPreferredSize().width;
       height = this.mainScreen.getPreferredSize().height;
       addBats();
   }
   
   // Method that insert the bats in the LinkedList
   public void addBats(){
       for(int x = 0; x < 2; x++) {
            batList.add(new CoBat());
       }
   }
   
   @Override
   // Method where the bat graphics are moving
   public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        for(Bat bat: batList){
            bat.paint(g2d);
            move(bat);
            
            if(!isClick) {
                clickBat(bat);

                if (bat == batList.getLast()) {
                    isClick = true;
                }
            }
            
            try {
                Thread.sleep(10);
                repaint();
            } catch(Exception ex) { }
        }
        g2d.dispose();
    }
    
   // Method that facilitates on how the bat moves
    public void move(Bat bat){
        Point p = bat.getLocation();
        Point speed = bat.getSpeed();
        int height = bat.getImage().getHeight(null);
        int width = bat.getImage().getWidth(null);

        int vx = speed.x;
        int vy = speed.y;

        int x = p.x;
        int y = p.y;

        if (x + vx < 0 || x + width + vx >= getParent().getWidth()) {
            vx *= -1;
        }

        if (y + vy < 0 || y + height + vy >= getParent().getHeight() ) {
            vy *= -1;
        }

        x += vx;
        y += vy;

        bat.setSpeed(new Point(vx, vy));
        bat.setLocation(new Point(x, y));
    }
    
    // Method that executes when the bats are pressed
    public void clickBat(Bat bats) {
        isClick = false;
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if(bats != null && bats.getLocation() != null) {
                    Point me = e.getPoint();
                    Rectangle bounds = new Rectangle(bats.getLocation(), new Dimension(bats.getImage().getWidth(null), bats.getImage().getHeight(null)));
                    if (bounds.contains(me)) {
                        System.out.println("Get Hit");
                    }
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
