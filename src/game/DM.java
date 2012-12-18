/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.util.ArrayList;
import view.component.IconPanel;

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
    private static final Element [] ELEMENTS = Element.values();
    
    /*
     * A játékban szereplő összes csillagjegy
     */
    private static final Zodiac [] ZODIACS =  Zodiac.values();
    
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
     * Visszaadja a játékban szereplő összes elemet megjelenítő panellel együtt
     */
    public static IconPanel[] getElementsOnPanel(){
        
        Element e[] =getELEMENTS();
        IconPanel p [] = new IconPanel [e.length];
        
        for(int i=0; i<e.length; i++){
            p[i] = new IconPanel(e[i]);
        }
        return p;
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
     * Visszaadja az összes paraméterben megadott elemű csillagjegyet megjelenítő panellel együtt
     */
    public static IconPanel[] getZodiacsByElementOnPanel (Element element){
        
        Zodiac z [] = getZodiacsByElement(element);
        IconPanel p [] = new IconPanel [z.length];
        
        for (int i=0; i<z.length; i++){
            p[i] = new IconPanel(z[i]);
        }
        return p;  
    }
    
    /*
     * Visszaadja az összes paraméterben megadott elemű csillagjegyet
     */
    public static Zodiac[] getZodiacsByElement(Element element){
        
        ArrayList <Zodiac> z= new ArrayList();
         
        
        for (int i=0; i<ZODIACS.length; i++){
            if(ZODIACS[i].getElement() == element) z.add(ZODIACS[i]); //System.out.println(z.get(i)); 
        }
        
        
        return (Zodiac[]) z.toArray();
         //return z.toArray(z);
    }
    
}
