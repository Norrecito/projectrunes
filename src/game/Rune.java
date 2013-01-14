/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import javax.swing.ImageIcon;
import resource.RM;

/**
 * A játékban szereplő rúnák
 * Elemek szerint vannak felosztva (Levegő, Föld, Tűz, Víz)
 * Jelenleg a rúnatáblán fognak megjeleni (saját paneljükön) mint a harc fő részei,
 * ugyanis kompinálásukkal különbőző varázslatokat tudunk majd használni.
 * 
 * @author Norrecito
 */
public enum Rune {
    
    AIR1("Air1", Element.AIR),          //Levegő 1 Rúna
    AIR2("Air2", Element.AIR),          //Levegő 2 Rúna
    EARTH1("Earth1", Element.EARTH),    //Föld 1 Rúna
    EARTH2("Earth2", Element.EARTH),    //Föld 2 Rúna
    FIRE1("Fire1", Element.FIRE),       //Tűz 1 Rúna
    FIRE2("Fire2", Element.FIRE),       //Tűz 2 Rúna
    WATER1("Water1", Element.WATER),    //Víz 1 Rúna
    WATER2("Water2", Element.WATER);    //Víz 2 Rúna
    
    /*
     * A rúna neve
     */
    private String name;
    
    /*
     * A rúna eleme
     */
    private Element element;
    
    /*
     * A rúna ikonképe
     */
    private ImageIcon Icon;
    
    /*
     * A rúna "aktivált" állapotának ikonképe
     */
    private ImageIcon activatedIcon;
    
    /*
     * Konstruktor
     */
    private Rune(String name, Element element){
        
        this.name = name;
        this.element = element;
        Icon = RM.getRuneIcon(name);
        
    }
    
    /*
     * Visszaadja a Rúna ikonját
     */
    public ImageIcon getIcon() {
        return Icon;
    }
    
    /*
     * Visszaadja a Rúna "aktivált" állapotú ikonját
     */
    public ImageIcon getActivatedIcon() {
        return activatedIcon;
    }
    
    /*
     * Visszaadja az elemet amibe a rúna tartozik
     */
    public Element getElement() {
        return element;
    }
    
    /*
     * Visszaadja a rúna nevét
     */
    public String getName() {
        return name;
    }
    
    
}
