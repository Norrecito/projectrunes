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
    ARIES(Element.FIRE,"Aries","A Kos leírása"),                     //Kos
    TAURUS(Element.EARTH,"Taurus","A Bika leírása"),                  //Bika 
    GEMINI(Element.AIR,"Gemini","Az Ikrek leírása"),                //Ikrek
    CANCER(Element.WATER,"Cancer","A Rák leírása"),                   //Rák
    LEO(Element.FIRE,"Leo","Az Oroszlán leírása"),                   //Oroszlán
    VIRGO(Element.EARTH,"Virgo","A Szűz leírása"),                    //Szűz
    LIBRA(Element.AIR,"Libra","A Mérleg leírása"),                  //Mérleg
    SCORPIO(Element.WATER,"Scorpio","A Skorpió leírása"),             //Skorpió
    SAGITTARIUS(Element.FIRE,"Sagittarius","A Nyilas leírása"),      //Nyilas
    CAPRICORN(Element.EARTH,"Capricorn","A Bak leírása"),             //Bak
    AQUARIUS(Element.AIR,"Aquarius","A Vízöntő leírása"),           //Vízöntő
    PISCES(Element.WATER,"Pisces","A Halak leírása");                 //Halak
    
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
    private Zodiac(Element element,String name, String description){
        
        this.element=element;
        this.name = name;
        this.description = description;
        this.icon =RM.getZodiacIcon(name);
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
