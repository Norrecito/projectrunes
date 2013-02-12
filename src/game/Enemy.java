/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.util.Arrays;
import java.util.List;
import view.component.Character;

/**
 * A játékban szereplő ellenfelek (nem játékos karakterek)
 * 
 * @author Norrecito
 */
public enum Enemy implements Character {
    
    SKELETON("Csontváz",Avatar.SKELETON1,5,15,5,30, Spell.FREEZE, Spell.BLIZZARD, Spell.ICEBOW, Spell.ICESHARDS),
    SKELETONWARRIOR("Csontváz harcos",Avatar.SKELETON2,10,15,5,40, Spell.ELECTRICCHARGE, Spell.ELECTRICSTORM, Spell.LIGHTNING, Spell.LIGHTNINGSPEAR),
    UNDEAD("Élőhalott",Avatar.UNDEAD1,2,20,5,50);
    
    /**
     * Az ellenfél neve
     */
    private String name;
    
    /**
     * Az ellenfél avatarja
     */
    private Avatar avatar;
    
    /**
     * Az ellenfél szintje
     */
    private int level;
    
    /**
     * Az ellenfél alapvető tulajdonságai
     */
    private int spellpower; //Varázserő
    private int resistance; //Ellenállás
    private int critical;    //Kritikus esély
    
    /**
     * Az ellenfél életpontjai
     */
    private int hp;
    
    /**
     * Az ellenfél varázslatainak listája
     */
    private List<Spell> spells;
    
    /**
     * Az ellenfél runáinak a listája
     */
    private RuneList runes;
    
    /**
     * Az ellenfél lépéspontjainak száma (alapértelmezetten 0)
     */
    private int moves=0;
    
    /**
     * Konstruktor
     * @param name az ellenfél neve
     * @param avatar az ellenfél avatar képe
     * @param spellpower az ellenfél varázsereje
     * @param resistance az ellenfél ellenállása
     * @param critical az ellenfél kritikus esélye
     * @param hp az ellenfél életerő pontjai
     * @param spells az ellenfél varázslatai
     */
    private Enemy(String name ,Avatar avatar, int spellpower, int resistance, int critical, int hp, Spell ...spells){
        
        this.name = name;
        this.avatar = avatar;
        this.level = DataManager.getSelectedHero().getLevel();
        this.spellpower = spellpower;
        this.resistance = resistance;
        this.critical = critical;
        this.hp = hp;
        this.spells = Arrays.asList(spells);
        setStats();
        
    }
    
    /**
     * Tulajdonságok beállítása
     */
    private void setStats(){
        
        spellpower = spellpower + level;
        resistance = resistance + level;
        hp = hp + (level*5);
    }
    
    /**
     * Visszaadja az ellenfél nevét
     */
    @Override
    public String getName() {
        return name;
    }
    
    /**
     * Visszaadja az ellenfél avatar képét
     */
    @Override
    public Avatar getAvatar() {
        return avatar;
    }
    
    /**
     * Visszaadja az ellenfél szintjét
     */
    @Override
    public int getLevel() {
        return level;
    }
    
    /**
     * Visszaadja az ellenfél varázserejét
     */
    @Override
    public int getSpellpower() {
        return spellpower;
    }
    
    /**
     * Visszaadja az ellenfél ellenállását
     */
    @Override
    public int getResistance() {
        return resistance;
    }
    
    /**
     * Visszaadja az ellenfél kritikus esélyét
     */
    @Override
    public int getCritical() {
        return critical;
    }
    
    /**
     * Visszaadja az ellenfél életerő pontjait
     */
    @Override
    public int getHp() {
        return hp;
    }
    
    /**
     * @return a karakter lépéspontjainak számát 
     */
    @Override
    public int getMoves() {
        return moves;
    }
    
    /**
     * Eggyel növeli a karakter lépéspontjait
     */
    @Override
    public void movesUp() {
        moves = moves + 1;
    }
    
    /**
     * Eggyel csökkenti a karakter lépéspontjait
     */
    @Override
    public void movesDown() {
        moves = moves - 1;
    }
    
    /**
     * Hozzáadja a paraméterben kapott rúnát a karakter rúnalistájáhóz
     * @param r a hozzáadandó rúna
     */
    @Override
    public void addRune(Rune r) {
        runes.add(r);
    }

    @Override
    public List<Spell> getSpells() {
        return spells;
    }
    
}
