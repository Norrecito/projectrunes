/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view.component;

import game.BattleMaster;
import game.C;
import game.Rune;
import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JPanel;

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
     * A rúnákat tároló lista referenciája
     */
    ArrayList<Rune> Runes;
    
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
        createRunes();
        fillTable();
    }
    
    /*
     * Létrehozza a rúnákat
     */
    private void createRunes(){
        
        Runes = new ArrayList();
        
        for(int i=0; i<size*size; i++){
            Runes.add(Rune.values()[C.createRandom(0, Rune.values().length-1)]);
        }
        
    }
    
    /*
     * Feltölti a táblát rúnákkal a konstruktorban megadott méret alapján
     */
    private void fillTable(){
        
        //Teszt
        for(int i=0; i<size*size; i++){
         
         RunePanel panel = new RunePanel(Runes.get(i));
         panel.setBorder(BorderFactory.createLineBorder(Color.black));
         add(panel);
         
       }
        
    }
    
}
