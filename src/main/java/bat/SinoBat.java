/*
    Date: January 24, 2021 
    Created by: MinPen
    Purpose: Set Attributes for SinoBat (One of the Bat Varieties)
*/

package bat;

import java.awt.Color;
import java.awt.Point;
import javax.swing.ImageIcon;

public class SinoBat extends Bat{

    // Setting up in the Constructor
    public SinoBat() {
       super();
       this.setSpeed(new Point(3,3));
       this.setImage(new ImageIcon("res/bat/sinobat.gif").getImage());
       this.setHealth(250);
       this.setMax_health(250);
       this.setHealthBar(Color.RED);
   }
}
