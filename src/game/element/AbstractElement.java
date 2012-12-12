/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package game.element;

import java.awt.Image;

/**
 * Az Absztrakt elem osztály
 * Minden elem osztály belőle származik le
 * Tartalmazza az alapvető elemekhez kapcsolodó változokat és metódusokat
 * 
 * @author Norrecito
 */
public abstract class AbstractElement {
    
    /*
     * Az elem neve
     */
    private String elementName;
    
    /*
     * Az elem leírása
     */
    private String elementDescription;
    
    /*
     * Az elemhez tartozó kép
     */
    private Image elementImage;
    
    /*
     * Visszadja az elem leírását
     */
    public String getElementDescription() {
        return elementDescription;
    }
    
    /*
     * Beállítja az elem leírását
     */
    public void setElementDescription(String elementDescription) {
        this.elementDescription = elementDescription;
    }
    
    /*
     * Visszaadja az elem nevét
     */
    public String getElementName() {
        return elementName;
    }
    
    /*
     * Beállítja az elem nevét
     */
    public void setElementName(String ElementName) {
        this.elementName = ElementName;
    }
    
    /*
     * Visszaadja az elem képét
     */
    public Image getElementImage() {
        return elementImage;
    }
    
    /*
     * Beállítja az elem képét
     */
    public void setElementImage(Image elementImage) {
        this.elementImage = elementImage;
    }
    
}
