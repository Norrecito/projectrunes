/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view.component;

import game.DataManager;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.text.StyledDocument;

/**
 * A karakterkreálló panel
 * 
 * @author Norrecito
 */
public class CharacterCreationPanel extends AbstractPanel {
    
    /*
     * Az "Új karakter létrehozása" felirat fontja
     */
    Font ftext = new Font("Algerian",Font.PLAIN, 20);
    
    /*
     * Az "Új karakter létrehozása" felirat címkéje
     */
    private JLabel lbText = new JLabel("Új karakter létrehozása");
    
    /*
     * A "Név" feliratot tartalmazó cimke
     */
    private JLabel lbName = new JLabel("Név: ");
    
    /*
     * A karakter nevének beírására szolgáló szövegmező
     */
    private JTextField tfName = new JTextField();
    
    /*
     * A TextPane amire a csillagjegyek leírása kerül
     */
    private JTextPane tpDescription = new JTextPane();
    
    /*
     * A TextPane-hez tartozó dokumentum
     */
    StyledDocument doc=tpDescription.getStyledDocument();
    
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
                checkCorrect();
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
            
            addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    createNewCharater();
                    getFrame().switchPanel(SingleplayerMenuPanel.class);
                }
            });
        }
    };
    
    /*
     * A panel amin az Avatar kiválasztása történik
     */
    private AvatarSelectionPanel pnAvatarSelection = new AvatarSelectionPanel();
    
    /*
     * Az Elemmel kapcsolatos informáciokat megjelenítő panel
     */
    private InformationPanel ipElement = new InformationPanel();
    
    /*
     * A Csillagjeggyel kapcsolatos információkat megjelenítő panel
     */
    private InformationPanel ipZodiac = new InformationPanel();
    
    /*
     * A panel amin az Elem illetve a Csillagjegy választás történik
     */
    private SelectionPanel pnSelection = new SelectionPanel(ipElement,ipZodiac){
        {
            getLsZodiac().addListSelectionListener(new ListSelectionListener() {

                @Override
                public void valueChanged(ListSelectionEvent e) {
                    checkCorrect();
                }
            });
        }
    };
    
    /*
     * A bal oldali panel (Avatarválasztó, illetve az Elem és Csillagjegy kiválasztása)
     */
    private JPanel pnLeft = new JPanel(){
        {
            setLayout(new BorderLayout());
            add(pnAvatarSelection, BorderLayout.CENTER);
            add(pnSelection, BorderLayout.SOUTH);
        }
    };
    
    /*
     * A panel amire az Elem illetve a Csillagjegy információi kerülnek
     */
    private JPanel pnRight = new JPanel(){
        {
          setOpaque(false);
          setLayout(new BorderLayout()); //Panel elrendezésének beállítása
          add(ipElement, BorderLayout.NORTH);
          add(ipZodiac, BorderLayout.SOUTH);
          
        }
        
        
    };
    
    /*
     * Konstruktor
     */
    public CharacterCreationPanel(){
        
        super(); //Ős konstruktor hívása
        initComponents(); //A komponensek a inicializálása
        initPanel(); //A panel inicializálása
        
    }
    
    private void initComponents(){
       
        //A komponensek méretének beállítása
        pnLeft.setMaximumSize(new Dimension(300,300));
        pnRight.setMaximumSize(new Dimension(450,300));
        spDescription.setMaximumSize(new Dimension(320, 280)); //A Scrollpane méretének beállítása
        tfName.setMaximumSize(new Dimension(150,25));
        
        //A komponensek elhelyezkedésének beállítása
        spDescription.setAlignmentX(Component.CENTER_ALIGNMENT);
        lbText.setAlignmentX(Component.CENTER_ALIGNMENT);
        lbName.setAlignmentX(Component.CENTER_ALIGNMENT);
        tfName.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        //Komponensek színének beállítása
        tpDescription.setBackground(Color.gray);
        lbName.setForeground(Color.white);
        
        //Betütípus (Font) beállítása
        lbText.setFont(ftext);
        
        //A figyelő hozzáadása a karakternév mezőhőz
        tfName.addKeyListener(btEnabler);
        
        //A csillagjegyek leírását tartalmazó TextPane szerkeszthetőségének letíltása
        tpDescription.setEditable(false);
        
        //A lista elrendezésének beállítása
       
        
    }
    
    private void initPanel(){
        
        setLayout(new BorderLayout()); //A panel elrendezésének beállítása
        
        setBorder(new EmptyBorder(new Insets(20, 60, 20, 60))); //Margó beállítása
        
        Box top = Box.createVerticalBox(); //A felső "doboz" létrehozása
        Box center = Box.createHorizontalBox(); //A középső "doboz" létrehozása
        Box bottom = Box.createHorizontalBox(); //Az alsó "doboz"
        
        //A felső "doboz" elemeinek hozzáadása
        top.add(lbText);
        top.add(Box.createRigidArea(new Dimension(0, 20)));
        top.add(lbName);
        top.add(Box.createRigidArea(new Dimension(5, 0)));
        top.add(tfName);
        top.add(Box.createRigidArea(new Dimension(5, 0)));
        
        //A középső "doboz" elemeinek hozzáadása
        center.add(pnLeft);
        center.add(Box.createRigidArea(new Dimension(10, 0)));
        center.add(pnRight);
        
        //Az alsó "doboz" elemeinek hozzáadása
        bottom.add(btBack);
        bottom.add(Box.createHorizontalGlue());
        bottom.add(btCreate);
        
        //A "dobozok" hozzáadása a panelhez
        add(top, BorderLayout.NORTH);
        add(center, BorderLayout.CENTER);
        add(bottom, BorderLayout.SOUTH);
        
    }
    
    /*
     * Megvizsgálja hogy a karakter neve megfelel-e a követelményeknek
     */
    private void checkCorrect(){
        
        int n = tfName.getText().length(); //Lekéri a karakter nevének hosszát
        btCreate.setEnabled(n >3 && pnSelection.getCurrentZodiac() != null); //A feltételek alapján tiltja illetve engedélyezi a gombot
        
    }
    
    /*
     * Létrehozza az új karaktert
     */
    private void createNewCharater(){
       DataManager.createHero(tfName.getText(), pnAvatarSelection.getCurrentAvatar(), pnSelection.getCurrentZodiac()); 
    }
    
    /*
     * Frissiti a panelen lévő komponenseket
     */
    @Override
    public void refresh(){
        
        tfName.setText("");
        pnAvatarSelection.reset();
        pnSelection.reset();
        
    }
    
}
