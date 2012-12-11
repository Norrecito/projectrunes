/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view.component;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import resource.RM;

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
    private DefaultListModel listModel = new DefaultListModel(){
        {
            addElement(RM.getAquariusIcon());
            addElement(RM.getPiscesIcon());
        }
    };
    
    /*
     * A lista ami a csillagjegyeket tárolja
     */
    private JList lsZodiac = new JList(listModel);
    
    /*
     * A Scrollpane amire a lista kerül
     */
    private JScrollPane spZodiac = new JScrollPane(lsZodiac);
    
    /*
     * A TextPane amire a csillagjegyek leírása kerül
     */
    private JTextPane tpDescription = new JTextPane();
    
    /*
     * A Scrollpane amire a csillagjegyek leírása kerül
     */
    private JScrollPane spDescription = new JScrollPane(tpDescription);
    
    /*
     * A karakternévhez tartozó figyelő
     */
    private KeyListener btEnabler = new KeyAdapter() {
    @Override
            public void keyReleased(KeyEvent e) {
                checkName();
            }
   };
    
    /*
     * A gomb ami a főmenübe visszalépést szolgálja
     */
    private JButton btBack = new JButton("Vissza"){
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
     * A gomb ami a karakter létrehozását szolgálja
     */
    private JButton btCreate = new JButton("Létrehoz"){
        {
            setEnabled(false); //alapértelmezetten le van tiltva (feltételezi hogy a karakter neve még üres)
        }
    };
    
    /*
     * A panel amin a csillagjegyek közül lehet választani
     */
    private JPanel pnZodiac = new JPanel(){
        {
            //setLayout(new BoxLayout(pnZodiac, BoxLayout.PAGE_AXIS)); //Panel elrendezésének beállítása
            add(spZodiac); //A csillagjegyeket tároló lista scrollpane-jének hozzáadása a panelhez
        }
    };
    
    /*
     * A karakterhez tartozó leírást tartalmazó panel
     */
    private JPanel pnDescription = new JPanel(){
        {
            add(spDescription);
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
       
        //A komponensek méretének beállítása
        spZodiac.setMaximumSize(new Dimension(250, 80)); //A Scrollpane méretének beállítása
        spDescription.setMaximumSize(new Dimension(250, 80)); //A Scrollpane méretének beállítása
        tfName.setMaximumSize(new Dimension(150,25));
        pnDescription.setMaximumSize(new Dimension(250,80));
        
        //A komponensek elhelyezkedésének beállítása
        spZodiac.setAlignmentX(CENTER_ALIGNMENT);
        spDescription.setAlignmentX(CENTER_ALIGNMENT);
        lbName.setAlignmentX(Component.CENTER_ALIGNMENT);
        tfName.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        //A figyelő hozzáadása a karakternév mezőhőz
        tfName.addKeyListener(btEnabler); 
        
    }
    
    private void initPanel(){
        
        setLayout(new BorderLayout()); //A panel elrendezésének beállítása
        
        setBorder(new EmptyBorder(new Insets(40, 60, 40, 60)));
        
        Box top = Box.createHorizontalBox(); //A felső "doboz" létrehozása
        Box center = Box.createHorizontalBox(); //A középső "doboz" létrehozása
        Box bottom = Box.createHorizontalBox(); //Az alsó "doboz"
        
        //A felső "doboz" elemeinek hozzáadása
        top.add(lbName);
        top.add(Box.createRigidArea(new Dimension(0, 5)));
        top.add(tfName);
        top.add(Box.createRigidArea(new Dimension(0, 5)));
       
        //A középső "doboz" elemeinek hozzáadása
        center.add(spZodiac);
        center.add(Box.createRigidArea(new Dimension(10, 0)));
        center.add(spDescription);
        
        //Az alsó "doboz" elemeinek hozzáadása
        bottom.add(btBack);
        bottom.add(Box.createRigidArea(new Dimension(20, 0)));
        bottom.add(btCreate);
        
        //A "dobozok" hozzáadása a panelhez
        add(top, BorderLayout.NORTH);
        add(center, BorderLayout.CENTER);
        add(bottom, BorderLayout.SOUTH);
        
    }
    
    /*
     * Megvizsgálja hogy a karakter neve megfelel-e a követelményeknek
     */
    private void checkName(){
        
        int n = tfName.getText().length(); //Lekéri a karakter nevének hosszát
        btCreate.setEnabled(n >3); //A hossz alapján engedélyezi, illetve tiltja a gombot
        
    }
}
