/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view.component;

import game.DataManager;
import game.Hero;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 * A "Folytatás" Panel
 * Itt választhatjuk ki a már korábban létrehozott karakterünket,
 * ha több karakter is van, akkor közülük választhatótunk, majd a "Tovább" gombra
 * kattintva folytathatjuk az állást.
 * 
 * @author Norrecito
 */
public class ContinuePanel extends AbstractPanel {
    
    /*
     * A jelenleg kiválasztott folytatandó karakter referenciája
     */
    private Hero selectedHero;
    
    /*
     * A "Folytatás" felirat fontja
     */
    private Font ftext = new Font("Algerian",Font.PLAIN, 20);
    
    /*
     * A panel tetején található "Folytatás" felirat
     */
    private final JLabel lbText = new JLabel("Folytatás");
    
    /*
     * A karakterek listájáhóz tartozó lista model
     */
    private DefaultListModel listmodel = new DefaultListModel();
    
    /*
     * A lista ami a karaktereket tárolja
     */
    private final JList lsHeroes = new JList(listmodel){
        {
            addListSelectionListener(new ListSelectionListener() {

                @Override
                public void valueChanged(ListSelectionEvent e) {
                    if(getSelectedValue() != null) setSelectedHero((CharacterlistPanel) getSelectedValue());
                    btNext.setEnabled(selectedHero != null); //Ha a kiválasztott hős nem "null" érték akkor engedélyezi a "Tovább" gombot
                }
            });
        }
    };
    
    /*
     * A ScrollPane amin a lista van (görgethetőség érdekében)
     */
    private final JScrollPane spHeroes = new JScrollPane(lsHeroes);
    
    /*
     * A "Vissza" gomb
     */
    private final JButton btBack = new JButton("Vissza"){
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
     * A "Törlés" gomb ami a kijelölt karakter törlésére szolgál
     */
    private final JButton btDelete = new JButton("Törlés");
    
    /*
     * A "Tovább" gomb
     */
    private final JButton btNext = new JButton("Tovább"){
        {
            setEnabled(false); //Alapértelmezetten le van tiltva (Nincs kijelőlve még karakter a listáról)
            
            addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    
                    DataManager.setSelectedHero(selectedHero);
                    getFrame().switchPanel(SingleplayerMenuPanel.class);
                }
            });
        }
    };
    
    /*
     * A felső panel (A "Folytatás" feliratot tárolja)
     */
    private final JPanel pnText = new JPanel(){
        {
            add(lbText);
        }
    };
    
    /*
     * A középső panel (A karakterlistát tárolja)
     */
    private final JPanel pnHeroes = new JPanel(){
        {
            add(spHeroes);
        }
    };
    
    /*
     * Az alsó panel (A gombokat tárolja)
     */
    private final JPanel pnButtons = new JPanel(){
        {
            setLayout(new FlowLayout());
            
            add(btBack);
            add(btDelete);
            add(btNext);
        }
    };
    
    /*
     * Konstruktor
     */
    public ContinuePanel(){
        
        initComponents(); //Komponensek inicializálása
        initPanel(); //A panel inicializálása
        setCharacterList(); //Karakterlista beállítása
    }

    private void initComponents() {
        
        //Betütípús (Font) beállítása
        lbText.setFont(ftext);
        
        //Átlátszóság beállítása
        pnText.setOpaque(false);
        pnHeroes.setOpaque(false);
        pnButtons.setOpaque(false);
        
        //Háttérszín beállítása
        lsHeroes.setBackground(Color.black);
        
        //Cellrenderer beállítása
        lsHeroes.setCellRenderer(new ImageListCellRenderer());
        
        //Méret beállítása
        spHeroes.setPreferredSize(new Dimension(300,320));
    }

    private void initPanel() {
        setLayout(new BorderLayout()); //Panel elrendezésének beállítása
        setBorder(new EmptyBorder(new Insets(20, 60, 20, 60))); //Margó beállítása
        
        //Az elemek hozzáadása
        add(pnText, BorderLayout.NORTH);
        add(pnHeroes, BorderLayout.CENTER);
        add(pnButtons, BorderLayout.SOUTH);
    }
    
    /*
     * Beállítja a karaktereket tároló listát
     */
    private void setCharacterList(){
        
        List<Hero> heroes = DataManager.getHeroes();
        
        for(int i =0; i<heroes.size(); i++){
            listmodel.addElement(new CharacterlistPanel(heroes.get(i)));
        }
        
    }
    
    /*
     * Beállítja a jelenleg kiválasztott karaktert
     */
    private void setSelectedHero(CharacterlistPanel panel){
        selectedHero = panel.getHero();
    }
    
    /*
     * A panel komponenseinek frissitése
     */
    @Override
    public void refresh(){
       listmodel.clear();
       setCharacterList();
       if(!listmodel.isEmpty()) lsHeroes.setSelectedIndex(0);
    }
    
}
