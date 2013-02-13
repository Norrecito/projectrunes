/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view.component;

import game.Rune;
import game.RuneList;
import java.awt.BorderLayout;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import org.imgscalr.Scalr;

/**
 * A varázslat követelményeinek ikonjait megjelenítő panel. 
 * 
 * @author Norrecito
 */
public class RuneListPanel extends JPanel {
    
    /**
     * A követelmények (rúnák) listája
     */
    private RuneList runes;
    
    /**
     * A követelmények (szükséges rúnák) ikonképeit tároló lista.
     */
    private List<JLabel> icons = new ArrayList();
    
    /**
     * Konstruktor
     * Egy listát vár ami az adott varázslathóz szükséges rúnákat tartalmazza.
     * @param l a szükséges rúnák listája.
     */
    public RuneListPanel(List<Rune> l, boolean activated, int iconSize){
        
        runes = new RuneList(l);
        setLayout(new BorderLayout());
        setOpaque(false);
        createIcons(activated, iconSize);
       }
    
    /**
     * Lekreálja a követelményben szereplő rúnák ikonjait a megadott paramétereknek megfelelően és hozzáadja őket a panelhez.
     * @param activated az "aktivált" vagy az "inaktív" rúnák képeit rakja fel
     * @param iconSize az ikonok mérete
     */
    private void createIcons(boolean activated, int iconSize) {
        
        Box box = Box.createHorizontalBox();
        for(int i=0; i<runes.size(); i++){
            
            Rune rune = runes.get(i);
            BufferedImage image = (activated) ? (BufferedImage) rune.getActivatedIcon().getImage() : (BufferedImage) rune.getIcon().getImage();
            BufferedImage scaledImage = Scalr.resize(image, iconSize);
            
            JLabel label = new JLabel(new ImageIcon(scaledImage));
            icons.add(label);
            box.add(label);
            
        }
        add(box);
    }
    
    /**
     * Visszaadja a varázslathóz szükséges rúnák ikonképeit egy JLabeleket tartalmazó listában.
     * @return a varázslatokhóz szükséges rúnák ikonképeinek listája.
     */
    public List<JLabel> getIcons() {
        return icons;
    }

    
    
}
