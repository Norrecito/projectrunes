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
     * A karakter szintje
     */
    private int level = 1;
    
    /*
     * A karakter alapvető tulajdonságai
     */
    private int spellpower = 10; //Varázserő
    private int resistance = 10; //Ellenállás
    private int critical = 5;    //Kritikus esély
    
    /*
     * A karakter statisztikai értékei
     */
    private int hp = 30;
    private int xp = 0;
    private int gold = 0;
    
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
    
    /*
     * Visszaadja a karakter avatarját
     */
    public Avatar getAvatar() {
        return avatar;
    }
    
    /*
     * Visszaadja a karakter szintjét
     */
    public int getLevel() {
        return level;
    }
    
    /*
     * Visszaadja a karakter kritikus esélyét
     */
    public int getCritical() {
        return critical;
    }
    
    /*
     * Visszaadja a karakter ellenálását
     */
    public int getResistance() {
        return resistance;
    }
    
    /*
     * Visszaadja a karakter varázserejét
     */
    public int getSpellpower() {
        return spellpower;
    }
    
    /*
     * Visszaadja a karakter aranyának számát
     */
    public int getGold() {
        return gold;
    }
    
    /*
     * Visszaadja a karakter életerő pontjainak számát
     */
    public int getHp() {
        return hp;
    }
    
    /*
     * Visszaadja a karakter tapasztalatpontjainak számát
     */
    public int getXp() {
        return xp;
    }
    
    
    
}
