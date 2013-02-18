/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view.component;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import javax.swing.*;
import org.imgscalr.Scalr;

/**
 * A panel amire az Elem illetve a Csillagjegy információi kerülnek (név, ikon, leírás) 
 * 
 * @author Norrecito
 */
public class InformationPanel extends JPanel {
    
    /**
     * A Visible inferface implementáló objektum referenciája
     */
    private Visible visible;
    
    /**
     * A nevet tartalmazó címke
     */
    private JLabel lbName = new JLabel();
    
    /**
     * A leírást tartalmazó címke
     */
    private JTextPane tpDescription = new JTextPane();
    
    /**
     * A leírás görgetőpanelja
     */
    private JScrollPane spDescrtion = new JScrollPane(tpDescription);
    
    /**
     * Konstruktor
     */
    public InformationPanel(){
        
        initComponents(); //Komponensek inicializálása
        initPanel(); //Panel inicializálása
        
    }
    
    /**
     * Visszaadja a panelen lévő Visible interface-t implementáló objektumot
     */
    public Visible getVisible() {
        return visible;
    }
    
    /**
     * Beállítja a panel megjelenését a paraméterként kapott elem szerint
     */
    public void setContent(Visible visible){
        this.visible = visible;
        
        BufferedImage image = (BufferedImage) visible.getIcon().getImage();
        BufferedImage scaledImage = Scalr.resize(image, 30);
        ImageIcon icon = new ImageIcon(scaledImage);
        
        lbName.setText(visible.getName());
        lbName.setIcon(icon);
        tpDescription.setText(visible.getDescription());
        tpDescription.setCaretPosition(0);
    }
    
    private void initPanel(){
        
        setLayout(new BorderLayout());
        add(lbName, BorderLayout.NORTH);
        add(spDescrtion, BorderLayout.CENTER);
        setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 3));
        setBackground(Color.black);
        setPreferredSize(new Dimension(100,150));
        
    }
    
    private void initComponents(){
        
        lbName.setForeground(Color.white);
        tpDescription.setForeground(Color.white);
        tpDescription.setBackground(Color.black);
        tpDescription.setEditable(false);
        tpDescription.setContentType("text/html");
    }
    
    /**
     * Visszaállítja a panelt az eredeti állapotába
     */
    public void reset(){
      lbName.setText("");  
      lbName.setIcon(null);
      lbName.revalidate();
      tpDescription.setText("");
    }
    
}
