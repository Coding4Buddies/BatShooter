/*
    Date: January 24, 2021 
    Created by: MinPen
    Purpose: Set Attributes for ModernBat (One of the Bat Varieties)
*/

package bat;

import java.awt.Color;
import java.awt.Point;
import javax.swing.ImageIcon;

public class ModernBat extends Bat{
    
    // Setting up in the Constructor
    public ModernBat() {
       super();
       this.setSpeed(new Point(3,2));
       this.setImage(new ImageIcon("res/bat/modernbat.gif").getImage());
       this.setHealth(200);
       this.setMax_health(200);
       this.setHealthBar(Color.RED);
   }
}
