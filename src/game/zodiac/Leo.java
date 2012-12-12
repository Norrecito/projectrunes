/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package game.zodiac;

import game.element.Fire;
import java.awt.Image;
import resource.RM;

/**
 * Az "Oroszlán" csillagjegy osztálya 
 * 
 * @author Norrecito
 */
public class Leo extends AbstractZodiac {
    
    /*
     * A konstruktor
     */
    public Leo(){
        
        super();
        setZodiacName("Leo");
        //setZodiacDescription(RM.getZodiacDescription(getZodiacName()));
        setElement(new Fire()); //A csillagjegyhez tartozó elem beállítása
    }
    
    /*
     * Felülírjuk az ős algoritmusát, hogy a Csillagjegyhez megfelelő képet illessze majd be rajzoláskor
     */
    @Override
    protected Image createBackgroundImage() {
        return RM.getLeoImage();
    }
}
