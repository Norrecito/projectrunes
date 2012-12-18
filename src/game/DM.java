/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.util.ArrayList;
import java.util.List;

/**
 * DM - Data Manager = Adat Menedzser
 * A játékkal kapcsolatos adatokat kezelő osztály
 * 
 * @author Norrecito
 */
public class DM {
   
    /*
     * A játékban szereplő összes elem
     */
    private static final Element [] ELEMENTS = {Element.AIR, Element.EARTH,Element.FIRE, Element.WATER};
    
    /*
     * A játékban szereplő összes csillagjegy
     */
    private static final Zodiac [] ZODIACS = {Zodiac.AQUARIUS, Zodiac.ARIES, Zodiac.CANCER, Zodiac.CAPRICORN,
                                              Zodiac.GEMINI, Zodiac.LEO, Zodiac.LIBRA, Zodiac.PISCES,
                                              Zodiac.SAGITTARIUS, Zodiac.SCORPIO, Zodiac.TAURUS, Zodiac.VIRGO};
    
    /*
     * Visszaadja a játékban szereplő elemek listáját
     */
    public static Element[] getELEMENTS() {
        return ELEMENTS;
    }
    
    /*
     * Visszaadja a játékban szereplő csillagjegyek listáját
     */
    public static Zodiac[] getZODIACS() {
        return ZODIACS;
    }
    
    /*
     * Visszaadja a játékban szereplő összes Levegő elemű csillagjegyet
     */
    public static Zodiac[] getAirZodiacs(){
        return getZodiacsByElement(Element.AIR);
    }
    
    /*
     * Visszaadja a játékban szereplő összes Föld elemű csillagjegyet
     */
    public static Zodiac[] getEarthZodiacs(){
        return getZodiacsByElement(Element.EARTH);
    }
    
    /*
     * Visszaadja a játékban szereplő összes Tűz elemű csillagjegyet
     */
    public static Zodiac[] getFireZodiacs(){
        return getZodiacsByElement(Element.FIRE);
    }
    
    /*
     * Visszaadja a játékban szereplő összes Víz elemű csillagjegyet
     */
    public static Zodiac[] getWaterZodiacs(){
        return getZodiacsByElement(Element.WATER);
    }
    
    /*
     * Visszaadja az összes paraméterben megadott elemű csillagjegyet
     */
    private static Zodiac[] getZodiacsByElement(Element element){
        
        List <Zodiac> z= new ArrayList();
        
        for (int i=0; i<ZODIACS.length; i++){
            if(ZODIACS[i].getElement().equals(element)) z.add(ZODIACS[i]); 
        }
        
        return (Zodiac[]) z.toArray();
    }
    
}
