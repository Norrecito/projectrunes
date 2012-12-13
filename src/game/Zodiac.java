/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import javax.swing.ImageIcon;
import resource.RM;
import view.component.Visible;

/**
 * A játékban szereplő csillagjegyek
 * Minden csillagjegy egy elembe tartozik (Tűz, Víz, Levegő, Föld)
 * Tartalmazza a csillagjegyhez szükséges változókat és metódusokat
 * 
 * @author Norrecito
 */
public enum Zodiac implements Visible {
    
    /*
     * A csillagjegyek
     */
    ARIES(Element.FIRE,"Kos","A Kos leírása","Aries"),                  //Kos
    TAURUS(Element.EARTH,"Bika","A Bika leírása","Taurus"),             //Bika 
    GEMINI(Element.AIR,"Ikrek","Az Ikrek leírása","Gemini"),            //Ikrek
    CANCER(Element.WATER,"Rák","A Rák leírása","Cancer"),               //Rák
    LEO(Element.FIRE,"Oroszlán","Az Oroszlán leírása","Leo"),           //Oroszlán
    VIRGO(Element.EARTH,"Szűz","A Szűz leírása","Virgo"),               //Szűz
    LIBRA(Element.AIR,"Mérleg","A Mérleg leírása","Libra"),             //Mérleg
    SCORPIO(Element.WATER,"Skorpió","A Skorpió leírása","Scorpio"),     //Skorpió
    SAGITTARIUS(Element.FIRE,"Nyilas","A Nyilas leírása","Sagittarius"),//Nyilas
    CAPRICORN(Element.EARTH,"Bak","A Bak leírása","Capricorn"),         //Bak
    AQUARIUS(Element.AIR,"Vízöntő","A Vízöntő leírása","Aquarius"),     //Vízöntő
    PISCES(Element.WATER,"Halak","A Halak leírása","Pisces");           //Halak
    
    /*
     * Az elem amibe a csillagjegy tartozik
     */
    private final Element element;
    
    /*
     * A csillagjegy neve
     */
    private final String name;
    
    /*
     * A csillagjegy leírása
     */
    private final String description;
    
    /*
     * A csillagjegy ikonképe
     */
    private final ImageIcon icon;
    
    /*
     * Konstruktor
     */
    private Zodiac(Element element,String name, String description, String iconname){
        
        this.element=element;
        this.name = name;
        this.description = description;
        this.icon =RM.getZodiacIcon(iconname);
        
    }

    /*
     * Visszaadja az elemet amibe a csillagjegy tartozik
     */
    public Element getElement() {
        return element;
    }
    
    /*
     * Visszaadja a csillagjegy nevét
     */
    @Override
    public String getName() {
        return name;
    }
    
    /*
     * Visszaadja a csillagjegy leírását
     */
    @Override
    public String getDescription() {
        return description;
    }
    
    /*
     * Visszaadja a csillagjegy ikonját
     */
    @Override
    public ImageIcon getIcon() {
        return icon;
    }
    
}
