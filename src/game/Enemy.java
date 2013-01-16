/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import view.component.Displayable;

/**
 * A játékban szereplő ellenfelek (nem játékos karakterek)
 * 
 * @author Norrecito
 */
public enum Enemy implements Displayable {
    
    SKELETON("Csontváz",Avatar.SKELETON1,5,15,5,30),
    SKELETONWARRIOR("Csontváz harcos",Avatar.SKELETON2,10,15,5,40),
    UNDEAD("Élőhalott",Avatar.UNDEAD1,2,20,5,50);
    
    /*
     * Az ellenfél neve
     */
    private String name;
    
    /*
     * Az ellenfél avatarja
     */
    private Avatar avatar;
    
    /*
     * Az ellenfél szintje
     */
    private int level;
    
    /*
     * Az ellenfél alapvető tulajdonságai
     */
    private int spellpower; //Varázserő
    private int resistance; //Ellenállás
    private int critical;    //Kritikus esély
    
    /*
     * Az ellenfél életpontjai
     */
    private int hp;
    
    /*
     * Konstruktor
     */
    private Enemy(String name ,Avatar avatar, int spellpower, int resistance, int critical, int hp){
        
        this.name = name;
        this.avatar = avatar;
        this.level = DataManager.getSelectedHero().getLevel();
        this.spellpower = spellpower;
        this.resistance = resistance;
        this.critical = critical;
        this.hp = hp;
        setStats();
        
    }
    
    /*
     * Tulajdonságok beállítása
     */
    private void setStats(){
        
        spellpower = spellpower + level;
        resistance = resistance + level;
        hp = hp + (level*5);
    }
    
    /*
     * Visszaadja az ellenfél nevét
     */
    @Override
    public String getName() {
        return name;
    }
    
    /*
     * Visszaadja az ellenfél avatar képét
     */
    @Override
    public Avatar getAvatar() {
        return avatar;
    }
    
    /*
     * Visszaadja az ellenfél szintjét
     */
    @Override
    public int getLevel() {
        return level;
    }
    
    /*
     * Visszaadja az ellenfél varázserejét
     */
    @Override
    public int getSpellpower() {
        return spellpower;
    }
    
    /*
     * Visszaadja az ellenfél ellenállását
     */
    @Override
    public int getResistance() {
        return resistance;
    }
    
    /*
     * Visszaadja az ellenfél kritikus esélyét
     */
    @Override
    public int getCritical() {
        return critical;
    }
    
    /*
     * Visszaadja az ellenfél életerő pontjait
     */
    @Override
    public int getHp() {
        return hp;
    }
    
}
