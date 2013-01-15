/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import javax.swing.ImageIcon;
import resource.RM;

/**
 * A játékban szereplő avatarok
 * A játékos illetve nem játékos karakterek (ellenfelek) "profilképei" 
 *
 * @author Norrecito
 */
public enum Avatar {
    
    BARBARIAN1("Barbarian1"),
    WARRIOR1("Warrior1"),
    WIZARD1("Wizard1"),
    WIZARD2("Wizard2"),
    WIZARD3("Wizard3");
    
    /*
     * Az avatarhóz tartozó ikonkép
     */
    private ImageIcon icon;
    
    /*
     * Konstruktor
     */
    private Avatar(String iconName){
       
        this.icon = RM.getAvatarIcon(iconName);
        
    }
    
    /*
     * Visszaadja az avatarhóz tartozó ikonképet
     */
    public ImageIcon getIcon() {
        return icon;
    }
    
    
}
