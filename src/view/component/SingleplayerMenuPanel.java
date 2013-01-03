/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view.component;

import game.DataManager;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import resource.RM;

/**
 * Az egyjátékos mód főképernyője
 * 
 * @author Norrecito
 */
public class SingleplayerMenuPanel extends AbstractPanel {
    
    /*
     * A "Kampány" feliratot tartalmazó cimke
     */
    private final JLabel lbText = new JLabel("<html><h1 color='#FFFFFF'>Kampány</h1></html>");
    
    /*
     * A karakter nevét tartalmazó cimke
     */
    private final JLabel lbName = new JLabel(DataManager.getSelectedHero().getName());
    
    /*
     * A karater csillagjegyét tartalmazó cimke
     */
    private final JLabel lbZodiac = new JLabel(DataManager.getSelectedHero().getZodiac().getName());
    
    /*
     * A karakterhez tartozó csillagjegy elemét tartalmazó cimke
     */
    private final JLabel lbElement = new JLabel(DataManager.getSelectedHero().getElement().getName());
    
    /*
     * A karakter szintjét tartalmazó cimke
     */
    private final JLabel lbLevel = new JLabel("<Level: 2>");
    
    /*
     * A karakter tapasztalati pontját tartalmazó cimke
     */
    private final JLabel lbXP = new JLabel("<XP: 230>");
    
    /*
     * A karakter pénzét tartalmazó cimke
     */
    private final JLabel lbGold = new JLabel("<Gold: 200>");
    
    /*
     * A karakter életpontjainak számát tartalmazó cimke
     */
    private final JLabel lbLife = new JLabel("<Életterő: 20/20>");
    
    /*
     * Az új harc indítására szolgáló gomb
     */
    private final JButton btNewFight = new JButton("Új harc", RM.getNewFightIcon());
    
    /*
     * A varázskönyv megnyítását szolgáló gomb
     */
    private final JButton btSpellBook = new JButton("Varázskönyv", RM.getSpellbookIcon());
    
    /*
     * A bolt megnyítását szolgáló gomb
     */
    private final JButton btShop = new JButton("Bolt",RM.getShopIcon()){
        {
            setEnabled(false); //alapértelmezetten le van tíltva (még nincs implementálva)
        }
    };
    
    /*
     * A főmenübe visszalépést szolgáló gomb
     */
    private final JButton btBack = new JButton("Vissza", RM.getBackIcon()){
        {
            addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    getFrame().switchPanel(MainMenuPanel.class);
                }
            });
        }
    };
    
    /*
     * A cimkét és menü gombokat tartalmazó panel
     */
    private final JPanel pnMenu = new JPanel(){
        {
            Box box = Box.createVerticalBox();
            
            box.add(lbText);
            box.add(btNewFight);
            box.add(btSpellBook);
            box.add(btShop);
            box.add(btBack);
            
            add(box);
        }
    };
    
    /*
     * A karakterhez kapcsolodó statisztikát mutató panel
     */
    private final JPanel pnStat = new JPanel(){
        {
            Box box = Box.createVerticalBox();
            
            box.add(lbName);
            box.add(Box.createRigidArea(new Dimension(0,15)));
            box.add(lbZodiac);
            box.add(lbElement);
            box.add(lbLevel);
            box.add(Box.createRigidArea(new Dimension(0,15)));
            box.add(lbXP);
            box.add(lbGold);
            box.add(lbLife);
            
            add(box);
        }
    };
    
    /*
     * Konstruktor
     */
    public SingleplayerMenuPanel(){
        
        initComponents(); //Komponensek inicializálása
        initPanel(); //Panel inicializálása
    }

    private void initComponents() {
        
        //Komponensek méretének beállítása
        Dimension btSize = new Dimension(150,50);
        btNewFight.setMaximumSize(btSize);
        btSpellBook.setMaximumSize(btSize);
        btShop.setMaximumSize(btSize);
        btBack.setMaximumSize(btSize);
        //pnStat.setPreferredSize(new Dimension(400,400));
        
        //Komponensek színének beállítása
        pnMenu.setBackground(Color.black);
        pnMenu.setOpaque(false);
        
        //Tooltip beállítása
        btShop.setToolTipText("A béta verzióig nem kerül implementálásra");
        
    }

    private void initPanel() {
        setLayout(new FlowLayout()); //Elrendezés beállítása
        setOpaque(false);
        
        add(pnMenu);
        add(pnStat);
    }
}
