/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.util.ArrayList;

/**
 * A rúnákat tároló lista
 * 
 * @author Norrecito
 */
public class RuneList extends ArrayList<Rune> {
    
    /**
     * Visszaadja, hogy a paraméterként megkapott rúnából hány darab van a listában
     * 
     * @param r rúna amiből szeretnénk megszámolni hány darab van a listában
     * @return hány darab van a paraméterben megkapott runából a listában
     */
    public int getCount(Rune r){
        int count=0;
        
        for(int i=0; i<this.size(); i++){
            if(this.get(i) == r) count++;
        }
        return count;
    }
    
}
