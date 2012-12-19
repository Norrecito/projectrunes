/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view.component;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * A panel amire az Elem illetve a Csillagjegy információi kerülnek (név, icon, leírás) 
 * 
 * @author Norrecito
 */
public class InformationPanel extends JPanel {
    
    /*
     * A Visible inferface implementáló objektum referenciája
     */
    private Visible visible;
    
    /*
     * A nevet tartalmazó címke
     */
    private JLabel lbName = new JLabel();
    
    /*
     * A leírást tartalmazó címke
     */
    private JLabel lbDescription = new JLabel();
    
    
    /*
     * Konstruktor
     */
    public InformationPanel(){
        
        initComponents(); //Komponensek inicializálása
        initPanel(); //Panel inicializálása
        
    }
    
    /*
     * Visszaadja a panelen lévő Visible interface-t implementáló objektumot
     */
    public Visible getVisible() {
        return visible;
    }
    
    /*
     * Beállítja a panel megjelenését a paraméterként kapott elem szerint
     */
    public void setContent(Visible visible){
        this.visible = visible;
        lbName.setText(visible.getName());
        lbName.setIcon(visible.getIcon());
        lbDescription.setText(visible.getDescription());
    }
    
    private void initPanel(){
        
        setLayout(new BorderLayout());
        add(lbName, BorderLayout.NORTH);
        add(lbDescription, BorderLayout.CENTER);
        setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 3));
        setBackground(Color.black);
        setPreferredSize(new Dimension(100,150));
        
    }
    
    private void initComponents(){
        
        lbName.setForeground(Color.white);
        lbDescription.setForeground(Color.white);
    }
    
}
