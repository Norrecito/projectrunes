/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.util.Random;

/**
 * C - Calculator
 * A játékban lévő számításokat fogja elvégezni (Véletlen, Esély XY dologra)
 * 
 * @author Norrecito
 */
public class C {
    
    /*
     * Visszaad egy új véletlenszerü számot a paraméterben megadott
     * minimum illetve maximum értéknek megfelelően
     */
    public static int createRandom(int min, int max){
        
        Random rand = new Random();
        int randomnumber = rand.nextInt(max-min+1)+min;
        return randomnumber;
        
    }
    
}
