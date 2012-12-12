/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package game.element;

import resource.RM;

/**
 * A tűz elem osztálya
 * Ebből az osztályból származik le minden csillagjegy aminek az eleme tűz
 * 
 * @author Norrecito
 */
public class Fire extends AbstractElement {
    
    /*
     * Konstruktor
     */
    public Fire(){
      
      setElementName("Fire"); //Az elem nevének beállítása
      setElementImage(RM.getFireImage()); //Az elemhez tartozó kép beállítása
      setElementDescription(RM.getElementDescription(getElementName())); //Az elem leírásának beállítása
      
    }
}
