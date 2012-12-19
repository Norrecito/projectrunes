/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view.component;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import resource.RM;

/**
 * A panel amin az avatar kiválasztása történik
 * 
 * @author Norrecito
 */
public class AvatarSelectionPanel extends JPanel {
    
    /*
     * A gomb amivel az eggyel elötte lévő Avatarra tudunk váltani
     */
    JButton btPrevious = new JButton("<<");
    
    /*
     * A gomb amivel a következő Avatarra tudunk váltani
     */
    JButton btNext = new JButton(">>");
    
    /*
     * A címke amire az Avatar képe kerül
     */
    private JLabel lbAvatar = new JLabel(RM.getTestAvatarIcon());
    
    /*
     * A panel amire az Avatarok kerülnek
     */
    JPanel pnAvatar = new JPanel(){
        {
           add(lbAvatar);
           setPreferredSize(getPreferredSize());
        }
        
    };
    
    /*
     * Konstruktor
     */
    public AvatarSelectionPanel(){
        
        initComponents(); //komponensek inicializálása
        initPanel(); //panel inicializálása
        
    }
    
    private void initComponents(){
        
        //Az avatar panel beállításai
        pnAvatar.setPreferredSize(new Dimension(50,50));
        pnAvatar.setBackground(Color.white);
        
        //Gombok beállításai
        btPrevious.setFocusable(false);
        btNext.setFocusable(false);
        btPrevious.setForeground(Color.white);
        btNext.setForeground(Color.white);
        btPrevious.setBackground(Color.darkGray);
        btNext.setBackground(Color.darkGray);
        
    }
    
    private void initPanel(){
        
        setLayout(new BorderLayout()); //Panel elrendezésének beállítása
        setPreferredSize(new Dimension(100,100));//Panel méretének beállítása
        
        //Elemek hozzáadása a panelhez
        add(btPrevious, BorderLayout.WEST);
        add(pnAvatar, BorderLayout.CENTER);
        add(btNext, BorderLayout.EAST);
        
    }
    
}
