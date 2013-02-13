/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.awt.BorderLayout;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
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
    LIGHTNING("Villám", Element.AIR,SpellCategory.OFFENSIVE,SpellType.MISSILE,1, Rune.AIR1, Rune.AIR2),
    ELECTRICCHARGE("Elektromos töltés", Element.AIR,SpellCategory.DEFENSIVE,SpellType.BUFF,2, Rune.AIR1, Rune.AIR2),
    LIGHTNINGSPEAR("Villámlándzsa",Element.AIR,SpellCategory.OFFENSIVE,SpellType.CONJURE,3, Rune.AIR1, Rune.AIR2),
    BALLLIGHTNING("Gömbvillám",Element.AIR,SpellCategory.OFFENSIVE,SpellType.MISSILE,5, Rune.AIR2, Rune.WATER2),
    LIGHTNINGSHIELD("Villámpajzs", Element.AIR,SpellCategory.DEFENSIVE,SpellType.BUFF,7, Rune.AIR1, Rune.AIR2),
    ELECTRICSTORM("Elektromos vihar",Element.AIR,SpellCategory.OFFENSIVE,SpellType.AREA,10, Rune.AIR1, Rune.AIR2, Rune.WATER1, Rune.WATER2),
    SUNRAY("Napsugár",Element.AIR,SpellCategory.OFFENSIVE,SpellType.MISSILE,5, Rune.AIR1, Rune.AIR2),
    STARFALL("Csillaghullás",Element.AIR,SpellCategory.OFFENSIVE,SpellType.AREA,20, Rune.AIR1, Rune.AIR2, Rune.WATER1, Rune.WATER2),
    
    //Föld varázslatok
    SPINES("Tüskék", Element.EARTH,SpellCategory.OFFENSIVE,SpellType.MISSILE,1,Rune.EARTH1, Rune.EARTH2),
    HEAL("Gyógyítás",Element.EARTH,SpellCategory.DEFENSIVE,SpellType.CURE,2,Rune.EARTH1, Rune.EARTH2),
    SPINEWHIP("Tövis ostor",Element.EARTH,SpellCategory.OFFENSIVE,SpellType.CONJURE,3,Rune.EARTH1, Rune.EARTH2),
    QUICKSAND("Futóhomok",Element.EARTH,SpellCategory.OFFENSIVE,SpellType.AREA,5,Rune.EARTH2, Rune.WATER2),
    FLESHTOSTONE("Kővéváltoztatás",Element.EARTH,SpellCategory.DEFENSIVE,SpellType.DEBUFF,7,Rune.EARTH1, Rune.EARTH2),
    THORNS("Tövisek",Element.EARTH,SpellCategory.OFFENSIVE,SpellType.AREA,10,Rune.EARTH1, Rune.EARTH2, Rune.WATER1, Rune.WATER2),
    EARTHQUAKE("Földrengés",Element.EARTH,SpellCategory.OFFENSIVE,SpellType.AREA,15,Rune.EARTH1, Rune.AIR1, Rune.AIR2, Rune.WATER2),
    METEORSHOWER("Meteoreső",Element.EARTH,SpellCategory.OFFENSIVE,SpellType.AREA,20,Rune.EARTH1,Rune.EARTH2, Rune.AIR1, Rune.AIR2),
    
    //Tűz varázslatok:
    FLAMEARROW("Tűznyil",Element.FIRE,SpellCategory.OFFENSIVE,SpellType.MISSILE,1,Rune.FIRE1, Rune.FIRE2),
    RINGOFFIRE("Tűzgyűrű",Element.FIRE,SpellCategory.DEFENSIVE,SpellType.BUFF,2,Rune.FIRE1, Rune.FIRE2),
    FLAMESWORD("Tűzkard",Element.FIRE,SpellCategory.OFFENSIVE,SpellType.CONJURE,3,Rune.FIRE1, Rune.FIRE2),
    FIREBALL("Tűzgolyó",Element.FIRE,SpellCategory.OFFENSIVE,SpellType.MISSILE,5,Rune.AIR2, Rune.FIRE2),
    FLAMESHIELD("Tűzpajzs",Element.FIRE,SpellCategory.DEFENSIVE,SpellType.BUFF,7,Rune.FIRE1, Rune.FIRE2),
    FIRESTORM("Tűzvihar",Element.FIRE, SpellCategory.OFFENSIVE,SpellType.AREA,10,Rune.FIRE1, Rune.FIRE2, Rune.AIR1, Rune.AIR2),
    WILDFIRE("Futótűz",Element.FIRE, SpellCategory.OFFENSIVE,SpellType.AREA,15,Rune.FIRE1, Rune.FIRE2, Rune.EARTH1, Rune.EARTH2),
    LAVA("Láva folyam",Element.FIRE, SpellCategory.OFFENSIVE,SpellType.AREA,20,Rune.FIRE1, Rune.FIRE2, Rune.EARTH1, Rune.EARTH2),
    
    //Víz varázslatok
    ICESHARDS("Jégszilánkok", Element.WATER,SpellCategory.OFFENSIVE,SpellType.MISSILE,1,Rune.WATER1, Rune.WATER2),
    VAPORCOULD("Gőzfelhő", Element.WATER,SpellCategory.DEFENSIVE,SpellType.BUFF,2,Rune.WATER1, Rune.WATER2),
    ICEBOW("Jégíj", Element.WATER,SpellCategory.OFFENSIVE,SpellType.CONJURE,3,Rune.WATER1, Rune.WATER2),
    HOTSTEAM("Forró gőz", Element.WATER,SpellCategory.OFFENSIVE,SpellType.AREA,5,Rune.WATER2, Rune.FIRE2),
    FREEZE("Megfagyasztás", Element.WATER,SpellCategory.DEFENSIVE,SpellType.DEBUFF,7,Rune.WATER1, Rune.WATER2),
    BLIZZARD("Jégvihar", Element.WATER,SpellCategory.OFFENSIVE,SpellType.AREA,10,Rune.WATER1, Rune.WATER2,Rune.AIR1, Rune.AIR2),
    TORNADO("Tornádó", Element.WATER,SpellCategory.OFFENSIVE,SpellType.AREA,15,Rune.WATER1, Rune.WATER2,Rune.AIR1, Rune.AIR2),
    LAVINA("Lavina",Element.WATER,SpellCategory.OFFENSIVE,SpellType.AREA,20,Rune.WATER1, Rune.WATER2,Rune.AIR1, Rune.AIR2);
    
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
     * A varázslat típusa
     */
    private final SpellType TYPE;
    
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
     * Memorizálva van-e jelenleg az adott varázslat
     */
    private boolean memorized;
    
    /**
     * Konstruktor
     * @param name a varázslat neve
     * @param element az elem amibe a varázslat tartozik
     * @param level a varázslathóz szükséges karakterszint
     * @param runes  a varázslat használhatáhóz szükséges runák
     */
    private Spell(String name, Element element,SpellCategory category,SpellType type, int level, Rune ...runes){
        
        this.NAME = name;
        this.ELEMENT = element;
        this.CATEGORY = category;
        this.TYPE = type;
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
     * A varázslathóz szükséges rúnákat panelon visszaadó metódus első változata.
     * Egy átlátszó JPanelt ad vissza amin a rúnák sorba vannak feltéve JLabelként, az ikonjuk
     * a rúna "aktívált" képe, és a méretük 30x30 pixel.
     * @return a varázslathóz szükséges runákat panelen. 
     */
    public JPanel getRunesPanel(){
        return getRunesPanel(true,30);
    }
    
   /**
    * A varázslathóz szükséges rúnákat panelon visszaadó metódus második változata.
    * Itt már megadható, hogy az "inaktív" illetve az "aktív" ikonjait kapjuk-e vissza a rúnáknak,
    * továbbá, hogy mekkorák legyenek az ikonok.
    * @param activated az "aktivált" rúna ikonokokat adja-e vissza.
    * @param iconSize a rúna ikonok mérete.
    * @return a varázslathóz szükséges runákat panelen.
    */
    public JPanel getRunesPanel(boolean activated, int iconSize){
        JPanel pn = new JPanel();
        pn.setLayout(new BorderLayout());
        pn.setOpaque(false);
        Box box = Box.createHorizontalBox();
        for(int i=0; i<RUNES.size(); i++){
            
            Rune rune = RUNES.get(i);
            BufferedImage image = (activated) ? (BufferedImage) rune.getActivatedIcon().getImage() : (BufferedImage) rune.getIcon().getImage();
            BufferedImage scaledImage = Scalr.resize(image, iconSize);
            
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
    
    /**
     * @return a varázslat típusát 
     */
    public SpellType getTYPE() {
        return TYPE;
    }
    
    /**
     * @return a varázslat leírását 
     */
    public String getDescription() {
        return description;
    }
    
    /**
     * @return memorizálva van-e jelenleg a varázslat az aktuális hős számára 
     */
    public boolean isMemorized() {
        return DataManager.getSelectedHero().getSpells().contains(this);
    }
    
    /**
     * Beállítja a paraméterben alapján hogy memorizálva legyen-e a varázslat
     * @param memorized legyen-e memorizálva a varázslat
     */
    public void setMemorized(boolean memorized) {
        this.memorized = memorized;
    }
    
    
    
}
