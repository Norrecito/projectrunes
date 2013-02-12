/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view.component;

import game.BattleMaster;
import game.DataManager;
import game.Enemy;
import java.awt.BorderLayout;
import java.awt.Dimension;

/**
 * A panel amin maga a harc folyik
 * 
 * @author Norrecito
 */
public class FightPanel extends AbstractPanel {
    
    /**
     * a harcban résztvevő hős
     */
    private view.component.Character hero=DataManager.getSelectedHero();
    
    /**
     * a harcban résztvevő ellenfél
     */
    private view.component.Character enemy;
    
    /*
     * A rúnatábla méretéhez (sor, oszlop) tartozó változó
     */
    private int tableSize;
    
    /*
     * A játékos karakert és a hozzá tartozó információkat tároló panel
     */
    private SidePanel pnHero = new SidePanel(DataManager.getSelectedHero());
    
    /*
     * Az ellenfélt és a hozzá tartozó információkat tároló panel
     */
    private SidePanel pnEnemy = new SidePanel(Enemy.SKELETON);
    
    /*
     * A rúna tábla panelje
     */
    private FightPanelTable pnFightTable;
    
    /*
     * Az első konstruktor
     * Nem vár paramétert, és a standart beállításokkal hozza létre a rúnatáblát
     * 8*8 (64 elemű) tábla
     */
    public FightPanel(){
        this(8);
    }
    
    /*
     * A második konstruktor
     * Paraméterben megadható neki a rúnatábla mérete, ez alapján hozza létre
     */
    public FightPanel(int tableSize){
      
        this.tableSize = tableSize;
        
        enemy = pnEnemy.getCharacter();
        pnFightTable = new FightPanelTable(tableSize);
        initComponents(); //Komponensek inicialízálása
        initPanel(); //Panel inicialízálása
        BattleMaster.start();
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
