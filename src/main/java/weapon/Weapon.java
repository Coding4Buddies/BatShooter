/*
    Date: January 25, 2021
    Created by: Jookie262
    Purpose: Weapon Class for Killing Bats
*/

package weapon;

import bat.Bat;

public class Weapon {

    /**
     * Initialize the needed variables
     */
    private int damage;

    /**
     * Default Constructor with default damage of 15
     */
    public Weapon() {
        this.damage = 20;
    }

    /**
     * Getter for the damage
     */
    public int getDamage() {
        return damage;
    }

    /**
     * Method for lowering the health of bats being hit
     */
    public void fire(Bat bat) {
        bat.setHealth(bat.getHealth() - getDamage());
    }
}
