/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Játékos illetve nem játékos karakterek létrehozását illetve a játékos karakterek mentését végzi
 * Az összes játékos karakter egy szerializálható objektumként (List) egy fájlba kerül mentésre (Hero.ser)
 * A "Folytatás" lehetőséget választva a főmenüből a karakterlista szintén innen kerül kiolvasásra
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
    private static List<Hero> heroes = load();
    
    /*
     * A jelenleg kiválasztott hős
     */
    private static Hero selectedHero;
    
    /*
     * Létrehoz egy új hőst a megadott paraméterek álltal
     */
    public static void createHero(String name, Avatar avatar, Zodiac zodiac){
        
        Hero hero = new Hero(name,avatar,zodiac); //Létrehozza az új hőst
        heroes.add(hero); //hozzáadja az új hőst a hősők listájáhóz
        save(); //Elementi a hősők listáját fájlba
        setSelectedHero(hero); //Az újonnan létrehozott karakter lesz a kiválasztott karakter
    }
    
    /*
     * Kitörli a játékos karaktert a paraméterben megkapott index alapján
     * (Ugyan a hőst is megkaphatná mint objektumot az Arraylist remove(Object o) metódusáshóz
     *  viszont ebben az esetben nem lehetne két ugyanolyan nevü karakter, ezért döntöttem
     *  az index mellett)
     */
    public static void deleteHero(int index){
       heroes.remove(index); //Kitörli a paraméterben megkapott hőst a listából
       save(); //Elementi a hősők listáját fájéba
    }
    
    /*
     * Visszaadja a hősők listáját
     */
    public static List<Hero> getHeroes(){
       return load(); 
    }
    
    /*
     * Elementi fájlba a hősők listáját
     */
    private static void save(){
        
        try{
            
        FileOutputStream fos = new FileOutputStream(file, false);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(heroes);
        oos.flush();
        oos.close();
        fos.close();
        System.out.println("A karakterlista sikeresen elmentésre került!");
        
        
        }
        catch(Exception Ex){
            System.out.println("Hiba történt a karakterlista elmentése közben!");
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
            fis.close();
            oin.close();
            return heroList;
        }
        }
        catch(Exception Ex){
            System.out.println("Hiba történt a karakterek kiolvasása közben!");
            System.out.println(Ex);
        }
        return new ArrayList<Hero>();
        
    }
    
    /*
     * Visszaadja hogy létezik-e a hősők listáját tároló fájl
     */
    public static boolean isSavefileExists(){
        return file.exists();
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
