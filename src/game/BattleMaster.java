/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import view.component.Character;
import view.component.FightPanel;

/**
 * A harc irányításáért felelős osztály
 * 
 * @Pending az teljes osztály kidolgozása
 * 
 * @author Norrecito
 */
public class BattleMaster {
    
    /**
     * A harctábla referenciája
     */
    private static FightPanel fightpanel;
    
    /**
     * a harcban résztvevő hős referenciája
     */
    private static view.component.Character hero=DataManager.getSelectedHero();
    
    /**
     * a harcban részvevő ellenfél referenciája
     */
    private static view.component.Character enemy;
    
    /**
     * az éppen aktiv karakter referenciája
     */
    private static view.component.Character activeCharacter;
    
    /**
     * az eddig letelt körök száma
     */
    private static int turn=0;
    
    /**
     * elindítja a harcot
     */
    public static void start(){
        activeCharacter = hero;
        activeCharacter.movesUp();
    }
    
    /**
     * A paraméterben megkapott runát hozzáadja az éppen aktív karakter rúnalistájáhóz
     * @param r a rúnalistáhóz hozzáadandó rúna 
     */
    public static void addRune(Rune r){
        activeCharacter.addRune(r);
        System.out.println("Rúna "+r.getName()+" hozzáadva "+activeCharacter.getName()+ " számára");
        refreshSpellPanels(r);
    }
    
    /**
     * Beállítja a harcmesterhez tartozó harctáblát amire felügyelni fog
     * @param fightpanel a harctábla
     */
    public static void setFightpanel(FightPanel fightpanel) {
        BattleMaster.fightpanel = fightpanel;
    }
    
    /**
     * Beállítja az éppen aktív karaktert
     * @param activeCharacter az aktív karakter
     */
    public static void setActiveCharacter(Character activeCharacter) {
        BattleMaster.activeCharacter = activeCharacter;
    }
    
    /**
     * Beállítja az aktuális ellenfelet
     * @param enemy az ellenfél
     */
    public static void setEnemy(Character enemy) {
        BattleMaster.enemy = enemy;
    }
    
    /**
     * Beállítja az aktuális hőst (játékos karaktert)
     * @param hero a hős akit irányít a játékos
     */
    public static void setHero(Character hero) {
        BattleMaster.hero = hero;
    }
    
    /**
     * A következő körre lép
     */
    private static void nextTurn(){
        turn++;
    }
    
    /**
     * Visszaállít minden értéket a kezdőértékre
     */
    private static void reset(){
        
        hero = null;
        enemy = null;
        activeCharacter = null;
        turn=0;
        
    }
    
    /**
     * Visszaadja az éppen aktív karaktert.
     * @return az aktív karaktert.
     */
    public static Character getActiveCharacter() {
        return activeCharacter;
    }
    
    public static void refreshSpellPanels(Rune r){
        fightpanel.refreshSidePanels(r);
    }
    
    
    
}
