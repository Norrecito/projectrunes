/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

import view.GameFrame;
import view.component.MainMenuPanel;

/**
 * A program indító osztálya
 * 
 * @author Norrecito
 */
public class Main {
    
    /*
     * A program verziószáma
     */
    private static String VERSION="0.1";
    
    /*
     * A játék ablak referenciája
     */
    private static GameFrame GAME_FRAME;
    
    /*
     * A főmenü panel
     */
    private static MainMenuPanel MAIN_MENU_PANEL= new MainMenuPanel();
    
    /*
     * Visszaadja a program verziószámát
     */
    public static String getVERSION() {
        return VERSION;
    }
    
    /*
     * A Main metódus
     */
    public static void main(String[] args) {
        GAME_FRAME = new GameFrame();
        GAME_FRAME.switchPanel(MAIN_MENU_PANEL);
    }
}
