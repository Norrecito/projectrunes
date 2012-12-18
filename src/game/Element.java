/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import javax.swing.ImageIcon;
import resource.RM;
import view.component.Visible;

/**
 * A játékban szereplő elemek
 * Minden Csillagjegy egy elembe tartozik
 * Tartalmazza az elemhez szükséges változókat és metódusokat
 * 
 * @author Norrecito
 */
public enum Element implements Visible {
    
    /*
     * Az elemek
     */
    AIR("Levegő","A levegő elem leírása","Air"),  //Levegő
    EARTH("Föld","A föld elem leírása","Earth"),  //Föld 
    FIRE("Tűz", "A tűz elem leírása","Fire"),     //Tűz
    WATER("Víz","A víz elem leírása","Water");    //Víz
    
    /*
     * Az elem neve
     */
    private final String name;
    
    /*
     * Az elem leírása
     */
    private final String description;
    
    /*
     * Az elem ikonja
     */
    private final ImageIcon icon;
    
    /*
     * Konstruktor
     */
    private Element(String name, String description, String iconName){
        
        this.name = name;
        this.description = description;
        this.icon = RM.getElementIcon(iconName);
        
    }
    
    
    
    /*
     * Visszaadja az elem nevét
     */
    @Override
    public String getName() {
        return name;
    }
    
    /*
     * Visszaadja az elem leírását
     */
    @Override
    public String getDescription() {
        return description;
    }
    
    /*
     * Visszaadja az elem ikonját
     */
    @Override
    public ImageIcon getIcon() {
        return icon;
    }
    
    
}
