/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.util.ArrayList;
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
    WIZARD3("Wizard3"),
    SKELETON1("Skeleton1",false),
    SKELETON2("Skeleton2",false),
    UNDEAD1("Undead1",false);
    
    /**
     * Az avatarhóz tartozó ikonkép
     */
    private final ImageIcon icon;
    
    /**
     * Választható-e a játékos számára az adott avatar
     */
    private final boolean choosable;
    
    /**
     * Az első konstruktor
     * @param iconName az ikon neve
     */
    private Avatar(String iconName){
       
        this(iconName,true);
        
    }
    
    /**
     * A második konstruktor
     * @param iconName az ikon neve
     * @param choosable választható-e a játékos számára
     */
    private Avatar(String iconName, boolean choosable){
       
        this.choosable = choosable;
        this.icon = RM.getAvatarIcon(iconName);
        
    }
    
    /**
     * Visszaadja az avatarhóz tartozó ikonképet
     */
    public ImageIcon getIcon() {
        return icon;
    }
    
    /**
     * @return a játékos számára választható avatarok listáját 
     */
    public static Avatar[] getChoosableAvatars(){
        
        ArrayList<Avatar> l = new ArrayList();
        for(Avatar a: values()){
           if(a.choosable) l.add(a); 
        }
        
        Avatar[] t = new Avatar[l.size()];
        l.toArray(t);
        
        return t;
        
    }
}
