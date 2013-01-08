/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.util.ArrayList;
import java.util.List;
import view.component.IconPanel;

/**
 * A csillagjegyeket tároló lista
 * 
 * @author Norrecito
 */
public class ZodiacList extends ArrayList<Zodiac> {
     
    /*
     * a csillagjegyeket panelre teszi fel
     */
     public List<IconPanel> createPanels(){
         
         List<IconPanel> panels = new ArrayList<>();
         
         for (Zodiac z : this) {
            panels.add(new IconPanel(z));
         }
     return panels;
     }
    
}
