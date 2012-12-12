/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.CardLayout;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JPanel;
import resource.RM;
import view.component.AbstractPanel;
import view.component.MainMenuPanel;

/**
 *  A főmenü ablaka
 * 
 * @author Norrecito
 */
public class GameFrame extends JFrame {
    
    /*
     * A "kártya" panel elrendezés menedzsere
     */
    CardLayout cl = new CardLayout();
    
    /*
     * A panelek tároló panel deklarálása és a hozzá tartozó elrendezés menedzser átadása
     */
    JPanel cards = new JPanel(cl);
    
    /*
     * A cache referenciája
     */
    private final Map<Class<? extends AbstractPanel>, AbstractPanel> CACHE = new HashMap<>();
    
    /*
     * Az "előző" panel referenciája
     */
    private JPanel prevPanel;
    
    /*
     * Konstruktor
     */
    public GameFrame(){
        
        initWindow();     //Ablak inicialízálása
        
   }
    
    private void initWindow(){
        
        setTitle("Runes"); //Az ablak cimkéjének beállítása
        setIconImage(RM.getIconImage()); //Az ablak ikonjának beállítása
        
        add(cards); //a paneleket tároló "pakli" hozzáadása a kerethez
        switchPanel(MainMenuPanel.class); //A panel beállítása a főmenüre
        
        setVisible(true); //Legyen látható
        setDefaultCloseOperation(EXIT_ON_CLOSE); //Az X-re kattintva bezárodik a program
        setSize(640, 480); //Az ablak méretének beállítása (640*480)
        setLocationRelativeTo(null); //Az ablak középen jelenjen meg
        setResizable(false); //Nem lehet átméretezni
        
    }
    
    /*
     * Az ablakon lévő panelek cserélgetését elvégző metódus
     */
    public <P extends AbstractPanel> void switchPanel(Class<P> panelClass){
         AbstractPanel panel = CACHE.get(panelClass); // lekéri a cacheből a referenciát
         
         try { // ha nincs objektum
             
         if (panel == null) CACHE.put(panelClass, panel = panelClass.newInstance().setFrame(this)); // létrehozza és cache-be beteszi, hogy legközelebb ne legyen példányosítás
         //if (prevPanel != null) remove(prevPanel); // ha volt előző panel, azt leszedi az ablakról
         //add(panel); // a jelenlegi panelt hozzáadja az ablakhoz
         cards.add(panel.getClass().toString(), panel); //A panel hozzáadása a tárolóhóz
         cl.show(cards, panel.getClass().toString());
         System.out.println("Jelenlegi panel: "+panel.getClass().toString());
         System.out.println("Pakliban lévő komponensek száma: "+cards.getComponents().length);
         //prevPanel = panel; // az előző panel most már a jelenlegi panel
         } catch (Exception ex) {
         Logger.getLogger(GameFrame.class.getName()).log(Level.SEVERE, null, ex);
         }
    }
}
