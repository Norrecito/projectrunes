/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view.component;

import javax.swing.ImageIcon;

/**
 * A "Látható" interface
 * Olyan osztály implementálja aminek van látható felülete (képe, leírása, neve)
 * Jelenleg az Elem (Element) illetve a Csillgjegy (Zodiac) enum használja, később bővítésre kerül
 * 
 * @author Norrecito
 */
public interface Visible {
    
    /*
     * Visszaadja az elem nevét
     */
    public String getName();
    
    /*
     * Visszaadja az elem leírását
     */
    public String getDescription();
    
    /*
     * Visszaadja az elem ikonképét 
     */
    public ImageIcon getIcon();
    
}
