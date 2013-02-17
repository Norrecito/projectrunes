/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view.component;

import game.Avatar;
import game.Rune;
import game.RuneList;
import game.Spell;
import java.util.List;

/**
 * A "Megjeleníthető" interface
 * A "Hős" illetve az "Ellenfél" implementálja
 * Azokat az attributumokat/objektumokat adja vissza amik a felhasználói felületen megjelennek mint a Hős/Ellenfél tulajdonságai
 * 
 * @author Norrecito
 */
public interface Character {
    
    /**
     * Visszaadja a nevet
     */
    public String getName();
    
    /**
     * Visszaadja az avatart
     */
    public Avatar getAvatar();
    
    /**
     * Visszaadja a szintet
     */
    public int getLevel();
    
    /**
     * Visszaadja a varázserőt
     */
    public int getSpellpower();
    
    /**
     * Visszaadja az ellenálást
     */
    public int getResistance();
    
    /**
     * Visszaadja a kritikus esélyt
     */
    public int getCritical();
    
    /**
     * Visszaadja az életerő pontot
     */
    public int getHp();
    
    /**
     * Visszaadja a karakter lépéseinek számát
     */
    public int getMoves();
    
    /**
     * Visszaadja a karakter varázslatait
     */
    public List<Spell> getSpells();
    
    /**
     * Visszaadja a karakter jelenleg birtokolt rúnáinak a listáját.
     */
    public RuneList getRunes();
    
    /**
     * eggyel növeli a karakter lépéspontjainak számát
     */
    public void movesUp();
    
    /**
     * egyel csökenti a karakter lépéspontjainak számát
     */
    public void movesDown();
    
    /**
     * hozzáadja a paraméterben kapott runát a karakter rúnalistájáhóz
     */
    public void addRune(Rune r);
    
}
