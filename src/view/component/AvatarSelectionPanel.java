/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view.component;

import game.Avatar;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import resource.RM;

/**
 * A panel amin az avatar kép kiválasztása történik
 * 
 * @author Norrecito
 */
public class AvatarSelectionPanel extends JPanel {
    
    /*
     * A jelenleg kiválasztott avatar referenciája
     */
    private Avatar currentAvatar;
    
    /*
     * A jelenleg kiválasztott avatar sorszáma
     */
    private int index = 0;
    
    /*
     * Az avatarok listája
     */
    private Avatar[] Avatars = Avatar.values();
    
    /*
     * A gomb amivel az eggyel elötte lévő Avatarra tudunk váltani
     */
    private JButton btPrevious = new JButton("<<"){
        {
            addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    index--;
                    switchAvatar();
                }
            });
        }
    };
    
    /*
     * A gomb amivel a következő Avatarra tudunk váltani
     */
    private JButton btNext = new JButton(">>"){
        {
            addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    index++;
                    switchAvatar();
                }
            });
        }
    };
    
    /*
     * A címke amire az Avatar képe kerül
     */
    private JLabel lbAvatar = new JLabel(RM.getTestAvatarIcon());
    
    /*
     * A panel amire az Avatarok kerülnek
     */
    JPanel pnAvatar = new JPanel(){
        {
            setLayout(new BorderLayout());
            add(lbAvatar);
           
           
        }
        
    };
    
    /*
     * Konstruktor
     */
    public AvatarSelectionPanel(){
        
        initComponents(); //komponensek inicializálása
        initPanel(); //panel inicializálása
        switchAvatar(); //Betölti az első avatart a panelre
        
    }
    
    private void initComponents(){
        
        //Az avatar panel beállításai
        pnAvatar.setPreferredSize(new Dimension(150,150));
        pnAvatar.setBackground(Color.white);
        pnAvatar.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
        
        //Az Avatar címke beállításai
        lbAvatar.setBackground(Color.red);
        lbAvatar.setOpaque(true);
        
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
    
    private void switchAvatar(){
        
        if(index <0) index=Avatars.length-1;
        if(index >Avatars.length-1) index=0;
        
        lbAvatar.setIcon(Avatar.values()[index].getIcon());
        currentAvatar = Avatar.values()[index];
        
    }
    
    /*
     * Visszaadja a jelenleg kiválasztott avatart
     */
    public Avatar getCurrentAvatar() {
        return currentAvatar;
    }
    
    /*
     * Visszaállítja az avatarválasztót a kezdő állapotba 
     */
    public void reset(){
        index = 0;
        switchAvatar();
    }
    
    
}
