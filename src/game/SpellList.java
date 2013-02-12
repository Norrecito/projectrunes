/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.util.ArrayList;

/**
 * A játékos illetve nem játékos karakterekhez tartozó, a jelenleg memorizált (harc közben használható) varázslatok listája. 
 * 
 * @author Norrecito
 */
public class SpellList extends ArrayList<Spell> {
    
    /**
     * Visszaadja az összes a listában szereplő varázslathóz szükséges rúnát listában.
     * @return a szükséges rúnák listáját.
     */
    public RuneList getRunes(){
        
        RuneList runes= new RuneList();
        
        for(int i=0; i<size();i++){
            runes.addAll(get(i).getRUNES());
        }
        return runes;    
    }
    
}
