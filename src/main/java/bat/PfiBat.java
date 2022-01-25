/*
    Date: January 24, 2021 
    Created by: MinPen
    Purpose: Set Attributes for PfiBat (One of the Bat Varieties)
*/

package bat;

import java.awt.Color;
import java.awt.Image;
import java.awt.Point;
import javax.swing.ImageIcon;

public class PfiBat extends Bat {
    
   // Setting up in the Constructor
   public PfiBat() {
       super();
       this.setSpeed(new Point(1,1));
       this.setImage(new ImageIcon("res/bat/pfibat.gif").getImage());
       this.setHealth(100);
       this.setMax_health(100);
       this.setSound("res/sound/bat_sound.wav");
       this.setHealthBar(Color.RED);
   }
}
