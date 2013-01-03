/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Játékos illetve nem játékos karakterek létrehozását/mentését fogja elvégezni
 * 
 * @author Norrecito
 */
public class DataManager {
    
    /*
     * A fájl ahova az új karakter mentésre kerül, illetve amiből kiolvassuk a már elmentett karaktereket
     */
    private static final File file = new File("Hero.ser");
    
    /*
     * A játékos karaktereket tároló lista
     */
    private static List<Hero> heroes = new ArrayList();
    
    /*
     * A jelenleg kiválasztott hős
     */
    private static Hero selectedHero;
    
    /*
     * Létrehoz egy új hőst a megadott paraméterek álltal
     */
    public static void createHero(String name, Avatar avatar, Zodiac zodiac){
        
        Hero hero = new Hero(name,avatar,zodiac); //Létrehozza az új hőst
        save(hero); //Elementi az új hőst fájlba
        setSelectedHero(hero); //Az újonnan létrehozott karakter lesz a kiválasztott karakter
    }
    
    /*
     * Visszaadja a hősők listáját
     */
    public static List<Hero> getHeroes(){
       return load(); 
    }
    
    /*
     * Elementi fájlba a paraméterként kapott hőst
     */
    private static void save(Hero hero){
        heroes.add(hero);
        
        try{
            
        FileOutputStream fos = new FileOutputStream(file, false);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(heroes);
        oos.flush();
        oos.close();
        fos.close();
        System.out.println("A karakter sikeresen elmentésre került!");
        
        }
        catch(Exception Ex){
            System.out.println("Hiba történt a karakter elmentése közben!");
            System.out.println(Ex);
        }
    }
    
    /*
     * Kiolvassa fájlból a karakterek listáját
     */
    private static List<Hero> load(){
        
        try{
        if(file.isFile()){
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream oin = new ObjectInputStream(fis);
            List<Hero> heroList = (List<Hero>) oin.readObject();
            System.out.println("Karakterlista betöltése sikeres!");
            return heroList;
        }
        }
        catch(Exception Ex){
            System.out.println("Hiba történt a karakterek kiolvasása közben!");
            System.out.println(Ex);
        }
        return null;
        
    }
    
    /*
     * Beállítja a jelenleg aktív karaktert
     */
    public static Hero getSelectedHero() {
        return selectedHero;
    }
    
    /*
     * Visszaadja a jelenleg aktív karaktert
     */
    public static void setSelectedHero(Hero selectedHero) {
        DataManager.selectedHero = selectedHero;
    }
    
    
    
}
