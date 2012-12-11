/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

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
}
