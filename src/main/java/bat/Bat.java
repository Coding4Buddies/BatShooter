/*
    Date: January 24, 2021 
    Created by: MinPen
    Purpose: The Parent Class for the Variety of Bats
*/

package bat;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;


public class Bat {
    
    /**
     * Initialize the needed variables
     */
    private int w = 1080, h = 720;
    private Point location, speed;
    private Image image;
    private int health, max_health;
    private Color healthBar;
    
    /**
     * Default Constructor
     * Automatically set the location to random location within the screen
     */
    public Bat() { 
        this.location = new Point(random(w - 200), random(h - 200));
    }
    
    /**
     * Method for Generating Random Number
     */
    public int random(int i) {
        return (int) Math.round(Math.random() * i);
    }
    
    /**
     * @param location the location to set
     */
    public void setLocation(Point location) {
        this.location = location;
    }

    /**
     * @return the location
     */
    public Point getLocation() {
        return location;
    }

    /**
     * @return the speed
     */
    public Point getSpeed() {
        return speed;
    }

    /**
     * @param speed the speed to set
     */
    public void setSpeed(Point speed) {
        this.speed = speed;
    }

    /**
     * @return the image
     */
    public Image getImage() {
        return image;
    }

    /**
     * @param image the image to set
     */
    public void setImage(Image image) {
        this.image = image;
    }

    /**
     * @return the health
     */
    public int getHealth() {
        return health;
    }

    /**
     * @param health the health to set
     */
    public void setHealth(int health) {
        this.health = health;
    }
    
    /**
     * @return the max_health
     */
    public int getMax_health() {
        return max_health;
    }
    
     /**
     * @param max_health the max_health to set
     */
    public void setMax_health(int max_health) {
        this.max_health = max_health;
    }
    
    /**
     * @return the healthBar
     */
    public Color getHealthBar() {
        return healthBar;
    }

    /**
     * @param healthBar the healthBar to set
     */
    public void setHealthBar(Color healthBar) {
        this.healthBar = healthBar;
    }
    
    /**
     * Create Health Bar to Bat
     */
    public void createHealthBar(Graphics2D g, Bat bat) {
        Point p = bat.getLocation();
        g.setColor(getHealthBar());
        g.fillRect(p.x + 28, p.y + 145, (100 * bat.getHealth()) / bat.getMax_health(), 5);
        g.drawRect(p.x + 28, p.y + 145, 100, 5);
    }

    /**
     * Create the Bat Graphics
     */
    public void paint(Graphics2D g) {
        Point p = getLocation();
        if(p != null) {
            g.drawImage(getImage(), p.x, p.y, null);
            createHealthBar(g, this);
        }
    }
}
