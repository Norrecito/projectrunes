/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.io.Serializable;

/**
 * A játékos által létrehozott "Hős" (Játékos karakter)
 * 
 * @author Norrecito
 */
public class Hero implements Serializable {
    
    /*
     * A karakter neve
     */
    private final String name;
    
    /*
     * A karakter avatarja
     */
    private final Avatar avatar;
    
    /*
     * A karakter csillagjegye
     */
    private final Zodiac zodiac;
    
    /*
     * Az elem amibe a karakter csillagjegye tartozik
     */
    private final Element element;
    
    /*
     * Konstruktor
     */
    public Hero(String name,Avatar avatar, Zodiac zodiac){
        
        this.name = name;
        this.avatar = avatar;
        this.zodiac = zodiac;
        this.element = zodiac.getElement();
    }
    
    /*
     * Visszaadja a karakter csillagjegyéhez tartozó elemet
     */
    public Element getElement() {
        return element;
    }
    
    /*
     * Visszaadja a karakter nevét
     */
    public String getName() {
        return name;
    }
    
    /*
     * Visszaadja a karakter csillagjegyét
     */
    public Zodiac getZodiac() {
        return zodiac;
    }
    
}
