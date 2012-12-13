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
    ARIES("Aries","A Kos leírása"),                     //Kos
    TAURUS("Taurus","A Bika leírása"),                  //Bika 
    GEMINI("Gemini","Az Ikrek leírása"),                //Ikrek
    CANCER("Cancer","A Rák leírása"),                   //Rák
    LEO("Leo","Az Oroszlán leírása"),                   //Oroszlán
    VIRGO("Virgo","A Szűz leírása"),                    //Szűz
    LIBRA("Libra","A Mérleg leírása"),                  //Mérleg
    SCORPIO("Scorpio","A Skorpió leírása"),             //Skorpió
    SAGITTARIUS("Sagittarius","A Nyilas leírása"),      //Nyilas
    CAPRICORN("Capricorn","A Bak leírása"),             //Bak
    AQUARIUS("Aquarius","A Vízöntő leírása"),           //Vízöntő
    PISCES("Pisces","A Halak leírása");                 //Halak
    
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
    private Zodiac(String name, String description){
        
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
