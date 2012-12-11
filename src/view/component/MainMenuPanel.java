/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view.component;

import core.Main;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import resource.RM;

/**
 * A főmenü panelje 
 * 
 * @author Norrecito
 */
public class MainMenuPanel extends AbstractPanel {
   
    /*
     * A verziószámot tartalmazó cimke
     */
    JLabel lbVersion = new JLabel("verzió: "+Main.getVERSION());
    
    /*
     * Az "Új Játék" gomb deklarálása
     */
    JButton btNewGame = new JButton("Új Játék"){
        {
            addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    getFrame().switchPanel(CharacterCreationPanel.class);
                }
            });
        }
    };
    
    /*
     * A "Folytatás" gomb deklarálása
     */
    JButton btContinue = new JButton("Folytatás"){
        {
            setEnabled(false); //Alapértelmezetten le van tíltva
        }
    };
    
    /*
     * A "Kilépés" gomb deklarálása
     */
    JButton btExit = new JButton("Kilépés"){
        {
            addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    System.exit(1);
                }
            });
        }
    };
    
    /*
     * A konstruktor
     */
    public MainMenuPanel(){
        
        super();
        initComponents(); //A komponensek a inicializálása
        initPanel(); //A panel inicializálása
      
   }
    
    private void initComponents(){
        
        //Gombok átméretezése
        btNewGame.setMaximumSize(new Dimension(150,25));
        btContinue.setMaximumSize(new Dimension(150,25));
        btExit.setMaximumSize(new Dimension(150,25));
        
        //A komponensek igazításának beállítása
        btNewGame.setAlignmentX(Component.CENTER_ALIGNMENT);
        btContinue.setAlignmentX(Component.CENTER_ALIGNMENT);
        btExit.setAlignmentX(Component.CENTER_ALIGNMENT);
        lbVersion.setAlignmentX(Component.RIGHT_ALIGNMENT);
        
        //A fokusz letiltása a főmenü gombjainál
        btNewGame.setFocusable(false);
        btContinue.setFocusable(false);
        btExit.setFocusable(false);  
    }
    
    private void initPanel(){
        
        setLayout(new BorderLayout()); //A panel elrendezésének beállíátsa
            
        Box center = Box.createVerticalBox(); //A középső "doboz" deklarálása
        Box bottom = Box.createVerticalBox(); //Az alsó "doboz" deklarálása
            
        //A középső "doboz" elemeinek hozzáadása
        center.add(Box.createRigidArea(new Dimension(0, 200)));
        center.add(btNewGame);
        center.add(Box.createRigidArea(new Dimension(0, 5)));
        center.add(btContinue);
        center.add(Box.createRigidArea(new Dimension(0, 5)));
        center.add(btExit);
        center.add(Box.createRigidArea(new Dimension(0, 5)));
        
        //Az alsó "doboz" elemeinek hozzáadása
        bottom.add(lbVersion);
            
        add(center, BorderLayout.CENTER); //A középen lévő komponenseket tartalmazó "doboz" hozzáadása a panelhez
        add(bottom, BorderLayout.PAGE_END); //A képernyő alján lévő komponenseket tartalmazó "doboz" hozzáadása a panelhez  
    }
    
    /*
     * Visszadja a panel hátterét
     */
    @Override
    protected Image createBackgroundImage() {
        return RM.getMainmenuBackgroundImage();
    }
}
