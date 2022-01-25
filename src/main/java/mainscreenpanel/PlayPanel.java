/*
    Date: January 24, 2021
    Created by: MinPen
    Purpose: Play Panel (Shoot the Bats that Move) for the MainScreen Frame
*/

package mainscreenpanel;

import bat.*;
import com.coding4buddies.batshooter.MainScreen;
import weapon.Weapon;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.stream.IntStream;

public class PlayPanel extends JPanel{

    // Initialize Needed Variables
    LinkedList<Bat> batList = new LinkedList<>();
    LinkedHashMap<String, Object> batReference;
    Weapon weapon = new Weapon();
    MainScreen mainScreen;
    private boolean isClick = false;
    int width, height;

    // Setting Up the Panel
    public PlayPanel(MainScreen gameFrame, LinkedHashMap<String, Object> batReference){
        this.mainScreen = gameFrame;
        this.batReference = batReference;
        width = gameFrame.getPreferredSize().width;
        height = gameFrame.getPreferredSize().height;
        addBats();
    }

    // Method that insert the bats in the LinkedList based on the JSON file
    public void addBats(){
        IntStream.range(0, Integer.parseInt((String) batReference.get("PfiBat"))).forEach(i -> batList.add(new PfiBat()));
        IntStream.range(0, Integer.parseInt((String) batReference.get("SputBat"))).forEach(i -> batList.add(new SputBat()));
        IntStream.range(0, Integer.parseInt((String) batReference.get("ModernBat"))).forEach(i -> batList.add(new ModernBat()));
        IntStream.range(0, Integer.parseInt((String) batReference.get("SinoBat"))).forEach(i -> batList.add(new SinoBat()));
        IntStream.range(0, Integer.parseInt((String) batReference.get("CoBat"))).forEach(i -> batList.add(new CoBat()));
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
            repaint();
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
                        weapon.fire(bats);
                        if(bats.getHealth() <= 0){
                            batList.remove(bats);
                        }
                        finishGame();
                    }
                }
            }
        });
    }

    // Method that executes when the bats are all killed
    public void finishGame(){
        if (batList.isEmpty())
            mainScreen.showView(new CongratsPanel(mainScreen));
    }

    @Override
    // Method for Changing the Background Image of the Panel
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Image i = new ImageIcon((String) batReference.get("BgImage")).getImage();
        g.drawImage(i,0,0, width, height, null);
    }
}
