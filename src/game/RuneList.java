/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.util.ArrayList;
import java.util.Collection;

/**
 * A rúnákat tároló lista
 * 
 * @author Norrecito
 */
public class RuneList extends ArrayList<Rune> {
    
    /**
     * Az első konstruktor
     * paramétere nincs, és az ős konstruktorát hívja.
     */
    public RuneList(){
        super();
    }
    
    /**
     * A második konstruktor
     * ugyanúgy az ős konstruktorára hivatkozik mint az első, de itt paraméterként
     * elvár egy kollekciót.
     * @param c a kollekció.
     */
    public RuneList(Collection<? extends Rune> c){
        super(c);
    }
    
    /**
     * Visszaadja, hogy a paraméterként megkapott rúnából hány darab van a listában
     * 
     * @param r rúna amiből szeretnénk megszámolni hány darab van a listában
     * @return hány darab van a paraméterben megkapott runából a listában
     */
    public int getCount(Rune r){
        int count=0;
        for (Rune o : this) {
            if (o == r) count++;
        }
        return count;
    }
    
}
