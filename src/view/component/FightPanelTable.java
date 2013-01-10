/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view.component;

import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import resource.RM;

/**
 * A harc panelhez tartozó rúnatábla
 * 
 * @author Norrecito
 */
public class FightPanelTable extends JPanel {
    
    /*
     * A tábla mérete (sor+oszlop)
     */
    private int size;
    
    /*
     * Konstruktor
     */
    public FightPanelTable(int size){
        this.size = size;
        initPanel(); //Panel inicializálása 
    }
    
    /*
     * Panel inicializálását végző metódus
     */
    private void initPanel() {
        setLayout(new GridLayout(size,size));
        fillTable();
    }
    
    /*
     * Feltölti a táblát rúnákkal a konstruktorban megadott méret alapján
     */
    private void fillTable(){
       for(int i=0; i<size*size; i++){
         
         JPanel TestRune = new JPanel();
         TestRune.setBorder(BorderFactory.createLineBorder(Color.black));
         TestRune.add(new JLabel(RM.getTestruneIcon()));
         add(TestRune);
         
       }
        
    }
    
}
