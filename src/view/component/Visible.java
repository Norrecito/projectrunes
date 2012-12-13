/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view.component;

import javax.swing.ImageIcon;

/**
 * A "Látható" interface
 * Minden osztály implementálja aminek van látható felülete (képe, leírása, neve)
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
