/*
    Date: January 24, 2021 
    Created by: MinPen
    Purpose: Set Attributes for SputBat (One of the Bat Varieties)
*/

package bat;

import java.awt.Color;
import java.awt.Point;
import javax.swing.ImageIcon;

public class SputBat extends Bat{

    // Setting up in the Constructor
    public SputBat() {
       super();
       this.setSpeed(new Point(2,3));
       this.setImage(new ImageIcon("res/bat/sputbat.gif").getImage());
       this.setHealth(150);
       this.setMax_health(150);
       this.setSound("res/sound/bat_sound.wav");
       this.setHealthBar(Color.RED);
   }
}
