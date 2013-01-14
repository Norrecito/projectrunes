/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package resource;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 * RM = Resource Manager - Az erőforrás kezelő osztály
 * 
 * @author Norrecito
 */
public class RM {
    
    /*
     * Visszaadja a program ikonját
     */
    public static Image getIconImage() {
        return getImage("icon.png");
    }
    
    /*
     * Visszaadja a program logoját
     */
    public static ImageIcon getLogoImage() {
        return getIcon("logo.jpg");
    }
    
    /*
     * Visszaadja a főmenü panel hátterét
     */
    public static Image getMainmenuBackgroundImage() {
        return getImage("background_mainmenu.jpg");
    }
    
    /*
     * Visszaadja a programhóz tartozó panelek alapértelmezett hátterét
     */
    public static Image getDefaultBackgroundImage() {
        return getImage("background_default.jpg");
    }
    
    /*
     * Visszaadja az aktív gomb ikonját
     */
    public static ImageIcon getActiveButtonIcon(){
       return getIcon("button_active.jpg");  
    }
    
    /*
     * Visszaadja az inaktív gomb ikonját
     */
    public static ImageIcon getDisabledButtonIcon(){
       return getIcon("button_disabled.jpg"); 
    }
    
    /*
     * Visszaadja a lenyomott gomb ikonját
     */
    public static ImageIcon getPressedButtonIcon(){
       return getIcon("button_pressed.jpg");  
    }
    
    /*
     * Visszaadja a "Vízöntő" ikonképét
     */
    public static ImageIcon getAquariusIcon(){
       return getIcon("zodiac_aquarius.jpg"); 
    }
    
    /*
     * Visszaadja a "Halak" ikonképét
     */
    public static ImageIcon getPiscesIcon(){
        return getIcon("zodiac_pisces.jpg");
    }
    
    /*
     * Visszaadja a "Kos" ikonképét
     */
    public static ImageIcon getAriesIcon(){
        return getIcon("zodiac_aries.png");
    }
    
    /*
     * Visszaadja a "Szűz" ikonképét
     */
    public static ImageIcon getVirgoIcon(){
        return getIcon("zodiac_virgo.png");
    }
    
    /*
     * Visszaadja az "Oroszlán ikonképét
     */
    public static ImageIcon getLeoIcon(){
        return getIcon("zodiac_leo.png");
    }
    
    /*
     * Visszadja az alapértelmezett Csillagjegy képet (Üres kő)
     */
    public static Image getDefaultZodiacImage(){
        return getImage("zodiac_default.png"); 
    }
    
    /*
     * Visszaadja az "Oroszlán" képét
     */
    public static Image getLeoImage(){
       return getImage("zodiac_leo.png"); 
    }
    
   
    /*
     * A visszaadja a "Levegő" elem képét
     */
    public static Image getAirImage(){
       return getImage("Air.png");  
    }
    
    /*
     * Visszaadja a "Föld" elem képét
     */
    public static Image getEarthImage(){
       return getImage("Earth.png");  
    }
    
    /*
     * Visszaadja a "Tűz" elem képét
     */
    public static Image getFireImage(){
       return getImage("Fire.png"); 
    }
    
    /*
     * Visszaadja a "Víz" elem képét
     */
    public static Image getWaterImage(){
       return getImage("Water.png"); 
    }
    
    /*
     * Visszaadja az "Új harc" ikonképét
     */
    public static ImageIcon getNewFightIcon(){
        return getIcon("newfight.png");
    }
    
    /*
     * Visszaadja a "Varázskönyv" ikonképét
     */
    public static ImageIcon getSpellbookIcon(){
        return getIcon("spellbook.png");
    }
    
    /*
     * Visszaadja a "Vissza" ikonképét
     */
    public static ImageIcon getBackIcon(){
      return getIcon("back.png");  
    }
    
    /*
     * Visszaadja a "Bolt" ikonképét 
     */
    public static ImageIcon getShopIcon(){
      return getIcon("shop.png");   
    }
    
    /*
     * Visszaadja az "Arany" ikonképét
     */
    public static ImageIcon getGoldIcon(){
       return getIcon("gold.png");   
    }
    
    /*
     * Visszaadja az "Életpont" ikonképét
     */
    public static ImageIcon getLifeIcon(){
       return getIcon("life.png"); 
    }
    
    /*
     * Visszaadja a "Tapasztalat pont" ikonképét
     */
    public static ImageIcon getExperienceIcon(){
       return getIcon("experience.png"); 
    }
    
    /*
     * Visszaadja az "Ellenállás" ikonképét
     */
    public static ImageIcon getResistanceIcon(){
        return getIcon("resistance.png"); 
    }
    
    /*
     * Visszaadj a "Varázserő" ikonképét
     */
    public static ImageIcon getSpellpowerIcon(){
        return getIcon("spellpower.png"); 
    }
    
    /*
     * Visszaadja a "Kritikus esély" inkonképét
     */
    public  static ImageIcon getCriticalIcon(){
       return getIcon("critical.png"); 
    }
    
    /*
     * Visszaadja a paraméterben megkapott rúna ikonképét
     */
    public static ImageIcon getRuneIcon(String runeName){
        return getIcon(runeName+".png");
    }
    
    /*
     * Visszaadja a paraméterként kapott elem leírását
     */
    public static String getElementDescription(String elementName){
        return getText(elementName+".txt");
    }
    
    /*
     * Visszadja a paraméterként kapott elem ikonképét
     */
    public static ImageIcon getElementIcon(String elementName){
        return getIcon(elementName+".png");
    }
    
    /*
     * Visszaadja a paraméterként kapott csillagjegy leírását
     */
    public static String getZodiacDescription(String zodiacName){
        return getText(zodiacName+".txt");
    }
    
    /*
     * Visszaadja a paraméternek kapott csillagjegy képét
     */
    public static ImageIcon getZodiacIcon(String zodiacName){
        return getIcon(zodiacName+".png");
    }
    
    /*
     * Visszaadja a teszt avatar képet
     */
    public static ImageIcon getTestAvatarIcon(){
       return getIcon("avatar.jpg"); 
    }
    
    /*
     * Visszaad egy üres képesség ikont
     */
    public static ImageIcon getBlankSkillIcon(){
        return getIcon("blank_skill.png");
    }
    
    /*
     * Visszaadja a tesztrúna képét
     */
    public static ImageIcon getTestruneIcon(){
       return getIcon("testrune.png"); 
    }
    
    /*
     * Visszaadja a paraméterben megadott név alapján az adott avatar ikonképét
     */
    public static ImageIcon getAvatarIcon(String fileName){
        return getIcon(fileName+".png");
    }
    
    /*
     * Visszaadja azt az ikont aminek a nevét paraméterben megkapja
     */
    private static ImageIcon getIcon(String name) {
        return new ImageIcon(getImage(name));
    }
    
    /*
     * Visszaadja azt a képet aminek a nevét paraméterben megkapja 
     */
    private static BufferedImage getImage(String name) {
        try {
            BufferedImage img = ImageIO.read(getStream(name));
            return img;
        } catch (IOException ex) {
            Logger.getLogger(RM.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    /*
     * Visszaadja a fájl bemenő folyamát
     */
    private static InputStream getStream(String name) {
        return RM.class.getResourceAsStream(name);
    }
    
    /*
     * Visszaadja a szövegfájl tartalmát aminek a nevét paraméterben megkapja
     */
    private static String getText(String filename){
        
        String content="";
        
        try {
            BufferedReader in = new BufferedReader(new FileReader(filename));
            
            String line;
            
            while((line = in.readLine()) != null)
            {
                content = content + line;
            }
            
        } catch (IOException ex) {
            Logger.getLogger(RM.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return content;
    }
}
