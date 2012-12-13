/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import javax.swing.ImageIcon;
import resource.RM;
import view.component.Visible;

/**
 * A játékban szereplő elemek osztálya
 * Minden Csillagjegy egy elembe tartozik
 * Tartalmazza az elemhez szükséges változókat és metódusokat
 * 
 * @author Norrecito
 */
public enum Element implements Visible {
    
    /*
     * Az elemek
     */
    AIR("Air","A levegő elem leírása"),
    EARTH("Föld","A föld elem leírása"),
    FIRE("Tűz", "A tűz elem leírása"),
    WATER("Víz","A víz elem leírása");
    
    /*
     * Az elem neve
     */
    private String name="<element name>";
    
    /*
     * Az elem leírása
     */
    private String description="<element description>";
    
    /*
     * Az elem ikonja
     */
    private ImageIcon icon=new ImageIcon(RM.getAirImage());
    
    /*
     * Konstruktor
     */
    private Element(String name, String description){
        
        this.name = name;
        this.description = description;
        this.icon = RM.getElementIcon(name);
        
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
