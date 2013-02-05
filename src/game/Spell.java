/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.image.BufferedImage;
import java.util.Arrays;
import java.util.List;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import org.imgscalr.Scalr;

/**
 * A varázslatok tároló enum
 * Minden játékban szereplő varázslat egy elembe tartozik (Levegő, Föld, Tűz, Víz),
 * és csak az adott elemhez tartozó csillagjeggyel rendelkező karakerek használhatják őket.
 * A varázslatok alapvetően két kategoriába oszthatók: Defenzív (Védekező) illetve Offenzív (Támadó)
 * 
 * @author Norrecito
 */
public enum Spell {
    
    //Levegő varázslatok
    LIGHTNING("Villám", Element.AIR,SpellCategory.OFFENSIVE,1, Rune.AIR1, Rune.AIR2),
    ELECTRICCHARGE("Elektromos töltés", Element.AIR,SpellCategory.DEFENSIVE,2, Rune.AIR1, Rune.AIR2),
    LIGHTNINGSPEAR("Villámlándzsa",Element.AIR,SpellCategory.OFFENSIVE,3, Rune.AIR1, Rune.AIR2),
    BALLLIGHTNING("Gömbvillám",Element.AIR,SpellCategory.OFFENSIVE,5, Rune.AIR2, Rune.WATER2),
    LIGHTNINGSHIELD("Villámpajzs", Element.AIR,SpellCategory.DEFENSIVE,7, Rune.AIR1, Rune.AIR2),
    ELECTRICSTORM("Elektromos vihar",Element.AIR,SpellCategory.OFFENSIVE,10, Rune.AIR1, Rune.AIR2, Rune.WATER1, Rune.WATER2),
    SUNRAY("Napsugár",Element.AIR,SpellCategory.OFFENSIVE,5, Rune.AIR1, Rune.AIR2),
    STARFALL("Csillaghullás",Element.AIR,SpellCategory.OFFENSIVE,20, Rune.AIR1, Rune.AIR2, Rune.WATER1, Rune.WATER2),
    
    //Föld varázslatok
    SPINES("Tüskék", Element.EARTH,SpellCategory.OFFENSIVE,1,Rune.EARTH1, Rune.EARTH2),
    HEAL("Gyógyítás",Element.EARTH,SpellCategory.DEFENSIVE,2,Rune.EARTH1, Rune.EARTH2),
    SPINEWHIP("Tövis ostor",Element.EARTH,SpellCategory.OFFENSIVE,3,Rune.EARTH1, Rune.EARTH2),
    QUICKSAND("Futóhomok",Element.EARTH,SpellCategory.OFFENSIVE,5,Rune.EARTH2, Rune.WATER2),
    FLESHTOSTONE("Kővéváltoztatás",Element.EARTH,SpellCategory.DEFENSIVE,7,Rune.EARTH1, Rune.EARTH2),
    THORNS("Tövisek",Element.EARTH,SpellCategory.OFFENSIVE,10,Rune.EARTH1, Rune.EARTH2, Rune.WATER1, Rune.WATER2),
    EARTHQUAKE("Földrengés",Element.EARTH,SpellCategory.OFFENSIVE,15,Rune.EARTH1, Rune.AIR1, Rune.AIR2, Rune.WATER2),
    METEORSHOWER("Meteoreső",Element.EARTH,SpellCategory.OFFENSIVE,20,Rune.EARTH1,Rune.EARTH2, Rune.AIR1, Rune.AIR2),
    
    //Tűz varázslatok:
    FLAMEARROW("Tűznyil",Element.FIRE,SpellCategory.OFFENSIVE,1,Rune.FIRE1, Rune.FIRE2),
    RINGOFFIRE("Tűzgyűrű",Element.FIRE,SpellCategory.DEFENSIVE,2,Rune.FIRE1, Rune.FIRE2),
    FLAMESWORD("Tűzkard",Element.FIRE,SpellCategory.OFFENSIVE,3,Rune.FIRE1, Rune.FIRE2),
    FIREBALL("Tűzgolyó",Element.FIRE,SpellCategory.OFFENSIVE,5,Rune.AIR2, Rune.FIRE2),
    FLAMESHIELD("Tűzpajzs",Element.FIRE,SpellCategory.DEFENSIVE,7,Rune.FIRE1, Rune.FIRE2),
    FIRESTORM("Tűzvihar",Element.FIRE, SpellCategory.OFFENSIVE,10,Rune.FIRE1, Rune.FIRE2, Rune.AIR1, Rune.AIR2),
    WILDFIRE("Futótűz",Element.FIRE, SpellCategory.OFFENSIVE,15,Rune.FIRE1, Rune.FIRE2, Rune.EARTH1, Rune.EARTH2),
    LAVA("Láva folyam",Element.FIRE, SpellCategory.OFFENSIVE,20,Rune.FIRE1, Rune.FIRE2, Rune.EARTH1, Rune.EARTH2),
    
    //Víz varázslatok
    ICESHARDS("Jégszilánkok", Element.WATER,SpellCategory.OFFENSIVE,1,Rune.WATER1, Rune.WATER2),
    VAPORCOULD("Gőzfelhő", Element.WATER,SpellCategory.DEFENSIVE,2,Rune.WATER1, Rune.WATER2),
    ICEBOW("Jégíj", Element.WATER,SpellCategory.OFFENSIVE,3,Rune.WATER1, Rune.WATER2),
    HOTSTEAM("Forró gőz", Element.WATER,SpellCategory.OFFENSIVE,5,Rune.WATER2, Rune.FIRE2),
    FREEZE("Megfagyasztás", Element.WATER,SpellCategory.DEFENSIVE,7,Rune.WATER1, Rune.WATER2),
    BLIZZARD("Jégvihar", Element.WATER,SpellCategory.OFFENSIVE,10,Rune.WATER1, Rune.WATER2,Rune.AIR1, Rune.AIR2),
    TORNADO("Tornádó", Element.WATER,SpellCategory.OFFENSIVE,15,Rune.WATER1, Rune.WATER2,Rune.AIR1, Rune.AIR2),
    LAVINA("Lavina",Element.WATER,SpellCategory.OFFENSIVE,20,Rune.WATER1, Rune.WATER2,Rune.AIR1, Rune.AIR2);
    
    /**
     * A varázslat neve
     */
    private final String NAME;
    
    /**
     * Az elem amibe a varázslat tartozik
     */
    private final Element ELEMENT;
    
    /**
     * A varázslat kategoriája
     */
    private final SpellCategory CATEGORY;
    
    /**
     * A varázslat megnyitásáhóz szükséges karakterszint
     */
    private final int LEVEL;
    
    /**
     * A varázslat használatáhóz szükséges rúnák listája
     * (A varázslat csakis akkor használható, ha a karakter a szükséges rúnák közül mindegyikből legalább egyet birtokol)
     */
    private final List<Rune> RUNES;
    
    /**
     * A varázslat ereje (százalékban)
     * Alapértelmezetten százszázalék, képességektől és külömbőző runák aktiválásakor változni fog
     */
    private int Power=100;
    
    /**
     * A varázslat leírása
     * Egyenlőre nincs implementálva
     */
    private String description="<varázslat leírása>";
    
    /**
     * Konstruktor
     * @param name a varázslat neve
     * @param element az elem amibe a varázslat tartozik
     * @param level a varázslathóz szükséges karakterszint
     * @param runes  a varázslat használhatáhóz szükséges runák
     */
    private Spell(String name, Element element,SpellCategory category, int level, Rune ...runes){
        
        this.NAME = name;
        this.ELEMENT = element;
        this.CATEGORY = category;
        this.LEVEL = level;
        this.RUNES = Arrays.asList(runes);
        
    }
    
    /**
     * @return az elemet amibe a varázslat tartozik 
     */
    public Element getELEMENT() {
        return ELEMENT;
    }
    
    /**
     * @return a varázslat kategoriáját 
     */
    public SpellCategory getCATEGORY() {
        return CATEGORY;
    }
    
    /**
     * @return a varázslathóz szükséges karakterszintet 
     */
    public int getLEVEL() {
        return LEVEL;
    }
    
    /**
     * @return a varázslat nevét 
     */
    public String getNAME() {
        return NAME;
    }
    
    /**
     * @return a varázslathóz szükséges runák listáját 
     */
    public List<Rune> getRUNES() {
        return RUNES;
    }
    
    /**
     * @return a varázslathóz szükséges runákat panelen 
     */
    public JPanel getRUNESOnPanel(){
        JPanel pn = new JPanel();
        pn.setLayout(new BorderLayout());
        pn.setOpaque(false);
        Box box = Box.createHorizontalBox();
        for(int i=0; i<RUNES.size(); i++){
            
            Rune rune = RUNES.get(i);
            BufferedImage image = (BufferedImage) rune.getActivatedIcon().getImage();
            BufferedImage scaledImage = Scalr.resize(image, 25);
            
            box.add(new JLabel(new ImageIcon(scaledImage)));
            
        }
        pn.add(box);
        return pn;
    }
    
    /**
     * @return a varázslat erejét 
     */
    public int getPower() {
        return Power;
    }
    
    /**
     * Beállítja a paraméterben megkapott érték alapján a varázslat erejét
     * @param Power a varázslat ereje 
     */
    public void setPower(int Power) {
        this.Power = Power;
    }
    
    
    
}
