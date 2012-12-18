/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view.component;

import java.awt.BorderLayout;
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
    public InformationPanel(Visible visible){
        
        this.visible = visible;
        lbName.setText(visible.getName());
        lbName.setIcon(visible.getIcon());
        lbDescription.setText(visible.getDescription());
        
        setLayout(new BorderLayout());
        add(lbName, BorderLayout.NORTH);
        add(lbDescription, BorderLayout.CENTER);
        
    }
    
    /*
     * Visszaadja a panelen lévő Visible interface-t implementáló objektumot
     */
    public Visible getVisible() {
        return visible;
    }
    
}
