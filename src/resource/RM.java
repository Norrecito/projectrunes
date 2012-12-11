/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package resource;

import java.awt.Image;
import java.awt.image.BufferedImage;
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
        return getIcon("zodiac_aries.jpg");
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
}
