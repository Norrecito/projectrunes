/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view.component;

import game.DataManager;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import resource.RM;

/**
 * A panel amin maga a harc folyik
 * 
 * @author Norrecito
 */
public class FightPanel extends AbstractPanel {
    
    /*
     * A játékos karakert és a hozzá tartozó információkat tároló panel
     */
    private SidePanel pnHero = new SidePanel(DataManager.getSelectedHero());
    
    /*
     * Az ellenfélt és a hozzá tartozó információkat tároló panel
     */
    private SidePanel pnEnemy = new SidePanel(DataManager.getSelectedHero());
    
    /*
     * A rúna tábla panelje
     */
    private JPanel pnFightTable = new JPanel(){
        {
            //Teszt
            setLayout(new GridLayout(8,8));
            
            for(int i =0; i<64; i++){
                
                   JPanel TestRune = new JPanel();
                   TestRune.setBorder(BorderFactory.createLineBorder(Color.black));
                   TestRune.add(new JLabel(RM.getTestruneIcon()));
                   add(TestRune);
            }
        }
    };
    
    /*
     * Konstruktor
     */
    public FightPanel(){
        
        initComponents(); //Komponensek inicialízálása
        initPanel(); //Panel inicialízálása
    }

    private void initComponents() {
        pnFightTable.setPreferredSize(new Dimension(400,400));
        pnFightTable.setOpaque(false);
    }

    private void initPanel() {
        setLayout(new BorderLayout()); //Panel elrendezésének beállítása
        
        add(pnHero, BorderLayout.WEST);
        add(pnFightTable, BorderLayout.CENTER);
        add(pnEnemy, BorderLayout.EAST);
    }
    
    
}
