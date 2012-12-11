/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JPanel;
import resource.RM;

/**
 *  A főmenü ablaka
 * 
 * @author Norrecito
 */
public class GameFrame extends JFrame {
    
    /*
     * A cache referenciája
     */
    private final Map<Class<? extends JPanel>, JPanel> CACHE = new HashMap<>();
    
    /*
     * Az "előző" panel referenciája
     */
    private JPanel prevPanel;
    
    /*
     * Konstruktor
     */
    public GameFrame(){
        
        initComponents(); //Komponensek inicialízálása
        initWindow();     //Ablak inicialízálása
        
   }
    
    private void initComponents(){
        
      }
    
    private void initWindow(){
        
        setTitle("Runes"); //Az ablak cimkéjének beállítása
        setIconImage(RM.getIconImage()); //Az ablak ikonjának beállítása
        setVisible(true); //Legyen látható
        setDefaultCloseOperation(EXIT_ON_CLOSE); //Az X-re kattintva bezárodik a program
        setSize(640, 480); //Az ablak méretének beállítása (640*480)
        setLocationRelativeTo(null); //Az ablak középen jelenjen meg
        setResizable(false); //Nem lehet átméretezni
        
    }
    
    /*
     * Az ablakon lévő panelek cserélgetését elvégző metódus
     */
    public void switchPanel(JPanel pn){
      if(pn != null){
         add(pn); 
      }
    }
    
    public <P extends JPanel> void switchPanel(Class<P> panelClass){
        JPanel panel = CACHE.get(panelClass); // lekéri a cacheből a referenciát
        
        if (panel == null) { try { // ha nincs objektum
            panel = panelClass.newInstance(); // cache-be beteszi, hogy legközelebb ne legyen példányosítás
            CACHE.put(panelClass, panel); // cache-be beteszi, hogy legközelebb ne legyen példányosítás
            if (prevPanel != null) remove(prevPanel); // ha volt előző panel, azt leszedi az ablakról
            add(panel); // a jelenlegi panelt hozzáadja az ablakhoz
            prevPanel = panel; // az előző panel most már a jelenlegi panel
            
            } catch (Exception ex) {
                Logger.getLogger(GameFrame.class.getName()).log(Level.SEVERE, null, ex);
            } 
            }
    }
}
