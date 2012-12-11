/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view.component;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 * A karakterkreálló panel
 * 
 * @author Norrecito
 */
public class CharacterCreationPanel extends AbstractPanel {
    
    /*
     * A "Név" feliratot tartalmazó cimke
     */
    private JLabel lbName = new JLabel("Név: ");
    
    /*
     * A karakter nevének beírására szolgáló szövegmező
     */
    private JTextField tfName = new JTextField();
    
    /*
     * A lista modellje
     */
    private DefaultListModel listModel = new DefaultListModel();
    
    /*
     * A lista ami a csillagjegyeket tárolja
     */
    private JList lsZodiac = new JList(listModel);
    
    /*
     * A Scrollpane amire a lista kerül
     */
    private JScrollPane jpZodiac = new JScrollPane(lsZodiac);
    
    /*
     * A TextPane amire a csillagjegyek leírása kerül
     */
    private JTextPane tpDescription = new JTextPane();
    
    /*
     * A Scrollpane amire a csillagjegyek leírása kerül
     */
    private JScrollPane jpDescription = new JScrollPane(tpDescription);
    
    /*
     * A gomb ami a főmenübe visszalépést szolgálja
     */
    private JButton btBack = new JButton("Vissza"){
        {
            addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    
                }
            });
        }
    };
    
    /*
     * A panel amin a csillagjegyek közül lehet választani
     */
    private JPanel pnZodiac = new JPanel(){
        {
            setLayout(new BoxLayout(pnZodiac, BoxLayout.PAGE_AXIS)); //Panel elrendezésének beállítása
            add(jpZodiac); //A csillagjegyeket tároló lista scrollpane-jének hozzáadása a panelhez
        }
    };
    
    /*
     * A karakterhez tartozó leírást tartalmazó panel
     */
    private JPanel pnDescription = new JPanel(){
        {
            add(jpDescription);
        }
    };
    
    /*
     * Konstruktor
     */
    public CharacterCreationPanel(){
        super();
        initComponents(); //A komponensek a inicializálása
        initPanel(); //A panel inicializálása
    }
    
    private void initComponents(){
       
        jpZodiac.setPreferredSize(new Dimension(250, 80)); //A Scrollpane méretének beállítása
        jpDescription.setPreferredSize(new Dimension(250, 80)); //A Scrollpane méretének beállítása
        
    }
    
    private void initPanel(){
        
    }
}
