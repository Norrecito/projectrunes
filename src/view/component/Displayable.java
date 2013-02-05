/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view.component;

import game.Avatar;

/**
 * A "Megjeleníthető" interface
 * A "Hős" illetve az "Ellenfél" implementálja
 * Azokat az attributumokat/objektumokat adja vissza amik a felhasználói felületen megjelennek mint a Hős/Ellenfél tulajdonságai
 * 
 * @author Norrecito
 */
public interface Displayable {
    
    /*
     * Visszaadja a nevet
     */
    public String getName();
    
    /*
     * Visszaadja az avatart
     */
    public Avatar getAvatar();
    
    /*
     * Visszaadja a szintet
     */
    public int getLevel();
    
    /*
     * Visszaadja a varázserőt
     */
    public int getSpellpower();
    
    /*
     * Visszaadja az ellenálást
     */
    public int getResistance();
    
    /*
     * Visszaadja a kritikus esélyt
     */
    public int getCritical();
    
    /*
     * Visszaadja az életerő pontot
     */
    public int getHp();
    
}