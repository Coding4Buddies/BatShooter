/*
    Date: January 24, 2021 
    Created by: MinPen
    Purpose: Set Attributes for CoBat (One of the Bat Varieties))
*/

package bat;

import java.awt.Color;
import java.awt.Point;
import javax.swing.ImageIcon;

public class CoBat extends Bat{
    
    // Setting up in the Constructor
    public CoBat() {
       super();
       this.setSpeed(new Point(25,25));
       this.setImage(new ImageIcon("res/bat/cobat.gif").getImage());
       this.setHealth(500);
       this.setMax_health(500);
       this.setHealthBar(Color.RED);
   }
    
}
