/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

/**
 * A varázslatok kategoriáit tároló enum
 * A játékban szereplő varázslatok két kategoriába sorolhatóak:
 * Defenzív (Védekező) és Offenzív(Támadó)
 * A kategoriákra legfőkébb azért van szükség mert a karakterek varázskönyvében
 * a varázslatok ezek szerint lesznek csoportosítva, illetve egyes képességek
 * kihatnak (pl. nővelik/csökkentik az erejüket) a külömbőző kategoriájú varázslatokra.
 * 
 * @pending az enum további kidolgozása
 * 
 * @author Norrecito
 */
public enum SpellCategory {
    
    DEFENSIVE,
    OFFENSIVE;
    
}
