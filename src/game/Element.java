/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import resource.RM;
import view.component.IconPanel;
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
     * Visszaadja az adott elemhez tartozó csillagjegyek listáját
     */
    public ZodiacList getZodiacList(){
        ZodiacList l = new ZodiacList();
        
         for (Zodiac z : Zodiac.values()){
              if (z.getElement() == this) l.add(z);
         }
         return l;
    }
    
    /*
     * Megjelenítő panelre teszi az elemet
     */
    public static List<IconPanel> createPanels() {
        List<IconPanel> l = new ArrayList<>();
        for (Element e : values()) {
            l.add(new IconPanel( e ));
        }
     return l;   
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
