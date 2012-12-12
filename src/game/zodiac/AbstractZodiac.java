/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package game.zodiac;

import game.element.AbstractElement;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.JPanel;
import resource.RM;

/**
 * Az absztrakt csillagjegy osztály
 * Minden csillagjegy ebből származik le
 * Tartalmazza az alapvető elemekhez kapcsolodó változokat és metódusokat
 * 
 * @author Norrecito
 */
public abstract class AbstractZodiac extends JPanel {
    
    /*
     * Az elem referenciája amibe a csillagjegy tartozik
     */
    private AbstractElement element;
    
    /*
     * A csillagjegyhez tartozó kép referenciája
     */
    private Image zodiacImage=RM.getDefaultZodiacImage();
    
    /*
     * A csillagjegy nevének referenciája
     */
    private String zodiacName;
    
    /*
     * A csillagjegy leírásának referenciája
     */
    private String zodiacDescription;
    
    /*
     * Konstruktor
     */
    public AbstractZodiac(){
        
        createBackgroundImage();
        Dimension size = new Dimension(zodiacImage.getWidth(null), zodiacImage.getHeight(null));
        setPreferredSize(size);
        setMinimumSize(size);
        setMaximumSize(size);
        setSize(size);
        setLayout(null);
    }
    
    /*
     * Visszadja a csillagjegyhez tartozó elemet
     */
    public AbstractElement getElement() {
        return element;
    }

    /*
     * Beállítja a csillagjegyhez tartozó elemet
     */
    public void setElement(AbstractElement element) {
        this.element = element;
    }
    
    /*
     * Visszadja a csillagjegy képét
     */
    public Image getZodiacImage() {
        return zodiacImage;
    }
    
    /*
     * Beállítja a csillagjegy képét
     */
    public void setZodiacImage(Image zodiacImage) {
        this.zodiacImage = zodiacImage;
    }

    /*
     * Visszadja a csillagjegy leírását
     */
    public String getZodiacDescription() {
        return zodiacDescription;
    }
    
    /*
     * Beállítja a csillagjegy leírását
     */
    public void setZodiacDescription(String zodiacDescription) {
        this.zodiacDescription = zodiacDescription;
    }
    
    /*
     * Visszaadja a csillagjegy nevét
     */
    public String getZodiacName() {
        return zodiacName;
    }
    
    /*
     * Beállítja a csillagjegy nevét
     */
    public void setZodiacName(String zodiacName) {
        this.zodiacName = zodiacName;
    }
    
    /*
     * Visszadja a panel hátterét
     */
    protected Image createBackgroundImage() {
        return RM.getDefaultZodiacImage();
    }
    
    /*
     * A "paintComponent" metódus felülírása, hogy kirajzolja a képet a panel háttereként
     */
    @Override
    public void paintComponent(Graphics g) {
    g.drawImage(zodiacImage, 0, 0, null);
    }
    
    
}
