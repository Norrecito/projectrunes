/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package game.zodiac;

import game.element.Fire;
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
        
        setZodiacName("Leo");
        setZodiacDescription(RM.getZodiacDescription(getZodiacName()));
        setElement(new Fire()); //A csillagjegyhez tartozó elem beállítása
    }
}
