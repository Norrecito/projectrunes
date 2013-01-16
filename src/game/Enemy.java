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
    
    SKELETON("Csontváz",Avatar.SKELETON1),
    SKELETONWARRIOR("Csontváz harcos",Avatar.SKELETON2),
    UNDEAD("Élőhalott",Avatar.UNDEAD1);
    
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
    private int spellpower = 5; //Varázserő
    private int resistance = 20; //Ellenállás
    private int critical = 10;    //Kritikus esély
    
    /*
     * Az ellenfél életpontjai
     */
    private int hp = 30;
    
    /*
     * Konstruktor
     */
    private Enemy(String name ,Avatar avatar){
        
        this.name = name;
        this.avatar = avatar;
        this.level = DataManager.getSelectedHero().getLevel();
        setStats();
        
    }
    
    /*
     * Tulajdonságok beállítása beállítása
     */
    private void setStats(){
        
        spellpower = spellpower + level;
        resistance = resistance + level;
        critical = critical + level;
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
