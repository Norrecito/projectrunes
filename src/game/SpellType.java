/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.awt.Color;

/**
 * A varázslatok típusai
 * A játékban szereplő varázslatok több típusra sorolhatoak:
 * 
 * -MISSILE:Lövedék típusú varázslatok (pl.: tűzgolyó, jégszilánkok).
 * -CURE:   Gyógyítások illetve olyan varázslatok amik hatástalanítják az átkokat (pl.: Gyógyítás). 
 * -CONJURE:Különbőző tárgyak (például fegyverek) megidézése.
 * -BUFF:   Védekező varázslatok amik felerősítik a karakter bizonyos statisztikáit.
 * -DEBUFF: Olyan varázslatok amik az ellenséges karakter statisztikáit csökkentik.
 * -AREA:   Területre ható támadó varázslatok (pl.:tűzvihar, láva folyam)
 * 
 * A varázslatok típusokra bontása több célt is szolgál,
 * egyrészt bizonyos képességek külömbőző típusokat erősítenek fel (pl.: az íjjász csillagjegy minden lövédéktípusú varázslatra
 * bonuszt kap), másrészt pedig minden típus eltérő statisztikával fog rendelkezni (pl.: a lövedék típusu varázslatokkal szemben
 * kitérési lehetőséget kap a másik fél).
 * 
 * @pending az enum további kidolgozása a dokumentációnak megfelelően.
 * 
 * @author Norrecito
 */
public enum SpellType {
    
    MISSILE("Lövedék",new Color(184,134,11)),
    CURE("Gyógyítás",new Color(34,139,34)),
    CONJURE("Idézés",new Color(104,34,139)),
    BUFF("Erősítés",new Color(24,116,205)),
    DEBUFF("Gyengítés",new Color(139,0,0)),
    AREA("Területi",new Color(205,102,0));
    
    /**
     * A típus neve
     */
    private final String name;
    
    /**
     * A varázslattípus szine 
     */
    private final Color color;
    
    /**
     * Konstruktor
     * @param name a varázslattípus neve
     * @param c a varázslattípus szine
     */
    private SpellType(String name ,Color c){
        this.name = name;
        this.color = c;
    }
    
    /**
     * @return a varázslattípus szinét 
     */
    public Color getColor() {
        return color;
    }
    
    /**
     * @return varázslattípus nevét 
     */
    public String getName() {
        return name;
    }
    
}
