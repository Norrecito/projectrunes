/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * A varázslatok tároló enum
 * Minden játékban szereplő varázslat egy elembe tartozik (Levegő, Föld, Tűz, Víz),
 * és csak az adott elemhez tartozó csillagjeggyel rendelkező karakerek használhatják őket.
 * A varázslatok alapvetően két kategoriába oszthatók: Defenzív (Védekező) illetve Offenzív (Támadó)
 * 
 * @author Norrecito
 */
public enum Spell {
    
    LIGHTNING("Villám", Element.AIR,1, new Rune[]{Rune.AIR1, Rune.AIR2}),
    SPINES("Tüskék", Element.EARTH,1,new Rune[]{Rune.EARTH1, Rune.EARTH2}),
    FLAMEARROW("Tűznyil",Element.FIRE,1,new Rune[]{Rune.FIRE1, Rune.FIRE2}),
    ICESHARDS("Jégszilánkok", Element.WATER,1,new Rune[]{Rune.WATER1, Rune.WATER2});
    
    /**
     * A varázslat neve
     */
    private final String NAME;
    
    /**
     * Az elem amibe a varázslat tartozik
     */
    private final Element ELEMENT;
    
    /**
     * A varázslat megnyitásáhóz szükséges karakterszint
     */
    private final int LEVEL;
    
    /**
     * A varázslat használatáhóz szükséges rúnák listája
     * (A varázslat csakis akkor használható, ha a karakter a szükséges rúnák közül mindegyikből legalább egyet birtokol)
     */
    private final List<Rune> RUNES;
    
    /**
     * Konstruktor
     * @param name a varázslat neve
     * @param element az elem amibe a varázslat tartozik
     * @param level a varázslathóz szükséges karakterszint
     * @param runes  a varázslat használhatáhóz szükséges runák
     */
    private Spell(String name, Element element, int level, Rune [] runes){
        
        this.NAME = name;
        this.ELEMENT = element;
        this.LEVEL = level;
        this.RUNES = new ArrayList<Rune>(Arrays.asList(runes));
        
    }
    
    
}
