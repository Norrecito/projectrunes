/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

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
    
    LIGHTNING("Villám", Element.AIR,SpellCategory.OFFENSIVE,1, Rune.AIR1, Rune.AIR2),
    SPINES("Tüskék", Element.EARTH,SpellCategory.OFFENSIVE,1,Rune.EARTH1, Rune.EARTH2),
    FLAMEARROW("Tűznyil",Element.FIRE,SpellCategory.OFFENSIVE,1,Rune.FIRE1, Rune.FIRE2),
    FIRESTORM("Tűzvihar",Element.FIRE, SpellCategory.OFFENSIVE,25,Rune.FIRE1, Rune.FIRE2, Rune.AIR1, Rune.AIR2),
    ICESHARDS("Jégszilánkok", Element.WATER,SpellCategory.OFFENSIVE,1,Rune.WATER1, Rune.WATER2);
    
    
    /**
     * A varázslat neve
     */
    private final String NAME;
    
    /**
     * Az elem amibe a varázslat tartozik
     */
    private final Element ELEMENT;
    
    /**
     * A varázslat kategoriája
     */
    private final SpellCategory CATEGORY;
    
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
     * A varázslat ereje (százalékban)
     * Alapértelmezetten százszázalék, képességektől és külömbőző runák aktiválásakor változni fog
     */
    private int Power=100;
    
    /**
     * Konstruktor
     * @param name a varázslat neve
     * @param element az elem amibe a varázslat tartozik
     * @param level a varázslathóz szükséges karakterszint
     * @param runes  a varázslat használhatáhóz szükséges runák
     */
    private Spell(String name, Element element,SpellCategory category, int level, Rune ...runes){
        
        this.NAME = name;
        this.ELEMENT = element;
        this.CATEGORY = category;
        this.LEVEL = level;
        this.RUNES = Arrays.asList(runes);
        
    }
    
    /**
     * @return az elemet amibe a varázslat tartozik 
     */
    public Element getELEMENT() {
        return ELEMENT;
    }
    
    /**
     * @return a varázslat kategoriáját 
     */
    public SpellCategory getCATEGORY() {
        return CATEGORY;
    }
    
    /**
     * @return a varázslathóz szükséges karakterszintet 
     */
    public int getLEVEL() {
        return LEVEL;
    }
    
    /**
     * @return a varázslat nevét 
     */
    public String getNAME() {
        return NAME;
    }
    
    /**
     * @return a varázslathóz szükséges runák listáját 
     */
    public List<Rune> getRUNES() {
        return RUNES;
    }
    
    /**
     * @return a varázslat erejét 
     */
    public int getPower() {
        return Power;
    }
    
    /**
     * Beállítja a paraméterben megkapott érték alapján a varázslat erejét
     * @param Power a varázslat ereje 
     */
    public void setPower(int Power) {
        this.Power = Power;
    }
    
    
    
}
