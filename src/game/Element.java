/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import org.imgscalr.Scalr;
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
    AIR("<HTMl><p color='#0B3861'>Levegő<p></HTML>",RM.getText("Air.html"),"Air", new Color(0,191,255)),  //Levegő
    EARTH("<HTMl><p color='#61380B'>Föld<p></HTML>",RM.getText("Earth.html"),"Earth", new Color(139,69,19)),  //Föld 
    FIRE("<HTMl><p color='#FF0000'>Tűz<p></HTML>", RM.getText("Fire.html"),"Fire", new Color(255,0,0)),     //Tűz
    WATER("<HTMl><p color='#0404B4'>Víz<p></HTML>",RM.getText("Water.html"),"Water", new Color(0,0,255));    //Víz
    
    /*
     * Az elem neve
     */
    private final String name;
    
    /**
     * Az elem színe
     */
    private final Color color;
    
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
    private Element(String name, String description, String iconName, Color color){
        
        this.name = name;
        this.description = description;
        this.icon = RM.getElementIcon(iconName);
        this.color = color;
        
    }
    
    /**
     * Visszaadja az adott elemhez tartozó csillagjegyek listáját
     */
    public ZodiacList getZodiacList(){
        ZodiacList l = new ZodiacList();
        
         for (Zodiac z : Zodiac.values()){
              if (z.getElement() == this) l.add(z);
         }
         return l;
    }
    
    /**
     * @return az adott elemhez tartozó varázslatok listája 
     */
    public List<Spell> getSpellList(){
        List<Spell> l = new ArrayList<Spell>();
        
        for(Spell s: Spell.values()){
            if(s.getELEMENT() == this) l.add(s);
        }
        
        return l;
    }
    
    /**
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
    
    /**
     * @return az elemhez tartozó szint 
     */
    public Color getColor() {
        return color;
    }
    
    /**
     * Visszaadja az elem ikonját a paraméterben megkapott méret alapján
     * @param iconSize az ikon mérete
     * @return az ikon képét.
     */
    @Override
    public ImageIcon getIcon(int iconSize) {
        
        BufferedImage image = (BufferedImage) getIcon().getImage();
        BufferedImage resizedImage = Scalr.resize(image, iconSize);
        ImageIcon resizedIcon = new ImageIcon(resizedImage);
        
        return resizedIcon;
    }
    
    
}
