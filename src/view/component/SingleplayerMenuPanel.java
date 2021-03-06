/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view.component;

import game.DataManager;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import resource.RM;

/**
 * Az egyjátékos mód főképernyője
 * Megjelenití az aktuális játékos karakter statisztikáját (varázserő, védelem, kritikus esély...)
 * Erről a képernyőről indithatunk új harcot, illetve válthatunk a képességeink között
 * 
 * @author Norrecito
 */
public class SingleplayerMenuPanel extends AbstractPanel {
    
    /*
     * A "Kampány" feliratot tartalmazó cimke
     */
    private final JLabel lbText = new JLabel("<html><h1 color='#FFFFFF'>Kampány</h1></html>");
    
    /*
     * A karakter nevét tartalmazó cimke
     */
    private final JLabel lbName = new JLabel("<html><h2>"+DataManager.getSelectedHero().getName()+"</h2></html>");
    
    /*
     * A karater csillagjegyét tartalmazó cimke
     */
    private final JLabel lbZodiac = new JLabel(DataManager.getSelectedHero().getZodiac().getName());
    
    /*
     * A karakterhez tartozó csillagjegy elemét tartalmazó cimke
     */
    private final JLabel lbElement = new JLabel(DataManager.getSelectedHero().getElement().getName());
    
    /*
     * A karakter szintjét tartalmazó cimke
     */
    private final JLabel lbLevel = new JLabel("Level: 2");
    
    /*
     * A karakter tapasztalati pontját tartalmazó cimke
     */
    private final JLabel lbXP = new JLabel("Tapasztalat: 230",RM.getExperienceIcon(),SwingConstants.LEFT);
    
    /*
     * A karakter pénzét tartalmazó cimke
     */
    private final JLabel lbGold = new JLabel("Arany: 0",RM.getGoldIcon(),SwingConstants.LEFT);
    
    /*
     * A karakter életpontjainak számát tartalmazó cimke
     */
    private final JLabel lbHP = new JLabel("Életterő: 20/20",RM.getLifeIcon(),SwingConstants.LEFT);
    
    /*
     * A karakter avatarját tartalmazó cimke
     */
    private final JLabel lbAvatar = new JLabel(DataManager.getSelectedHero().getAvatar().getIcon());
    
    /*
     * A karakter "Varázserejét" tartalmazó cimke
     */
    private final JLabel lbSpellpower = new JLabel("Varázserő: 100",RM.getSpellpowerIcon(),SwingConstants.LEFT);
    
    /*
     * A karakter "Ellenállását" tartalmazó cimke
     */
    private final JLabel lbResistance = new JLabel("Ellenállás: 100",RM.getResistanceIcon(),SwingConstants.LEFT);
    
    /*
     * A karakter "Kritikus esélyét" tartalmazó cimke
     */
    private final JLabel lbCritical = new JLabel("Kritikus: 100", RM.getCriticalIcon(), SwingConstants.LEFT);
    
    /*
     * Az új harc indítására szolgáló gomb
     */
    private final JButton btNewFight = new JButton("Új harc", RM.getNewFightIcon()){
        {
            addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    getFrame().switchPanel(FightPanel.class);
                }
            });
        }
    };
    
    /*
     * A varázskönyv megnyítását szolgáló gomb
     */
    private final JButton btSpellBook = new JButton("Varázskönyv", RM.getSpellbookIcon()){
        {
            addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    getFrame().switchPanel(SpellbookPanel.class);
                }
            });
        }
    };
    
    /*
     * A bolt megnyítását szolgáló gomb
     */
    private final JButton btShop = new JButton("Bolt",RM.getShopIcon()){
        {
            setEnabled(false); //alapértelmezetten le van tíltva (még nincs implementálva)
        }
    };
    
    /*
     * A főmenübe visszalépést szolgáló gomb
     */
    private final JButton btBack = new JButton("Vissza", RM.getBackIcon()){
        {
            addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    getFrame().switchPanel(MainMenuPanel.class);
                }
            });
        }
    };
    
    /*
     * A cimkét és menü gombokat tartalmazó panel
     */
    private final JPanel pnMenu = new JPanel(){
        {
            Box box = Box.createVerticalBox();
            
            box.add(lbText);
            box.add(btNewFight);
            box.add(btSpellBook);
            box.add(btShop);
            box.add(btBack);
            
            add(box);
        }
    };
    
    /*
     * A karakterhez kapcsolodó statisztikák baloldali panele
     */
    private final JPanel pnStatLeft = new JPanel(){
        {
            Box box = Box.createVerticalBox();
            
            box.add(lbName);
            box.add(Box.createRigidArea(new Dimension(0,15)));
            box.add(lbSpellpower);
            box.add(lbResistance);
            box.add(lbCritical);
            box.add(Box.createRigidArea(new Dimension(0,15)));
            box.add(lbXP);
            box.add(lbGold);
            box.add(lbHP);
            
            add(box);
            setOpaque(false);
        }
    };
    
    /*
     * A karakterhez kapcsolodó statisztikák jobb oldali panele
     */
    private final JPanel pnStatRight = new JPanel(){
        {
          Box box = Box.createVerticalBox();
          box.add(lbAvatar);
          box.add(lbElement);
          box.add(lbZodiac);
          box.add(lbLevel);
          
          add(box);
          
        }  
    };
    
    private final TransparentPanel pnStats = new TransparentPanel(){
        {
            setLayout(new BorderLayout());
            add(pnStatLeft, BorderLayout.WEST);
            add(pnStatRight, BorderLayout.CENTER);
            //setOpaque(false);
        }  
    };
    
    /*
     * Konstruktor
     */
    public SingleplayerMenuPanel(){
        
        initComponents(); //Komponensek inicializálása
        initPanel(); //Panel inicializálása
    }

    private void initComponents() {
        
        //Komponensek méretének beállítása
        Dimension btSize = new Dimension(150,50);
        btNewFight.setMaximumSize(btSize);
        btSpellBook.setMaximumSize(btSize);
        btShop.setMaximumSize(btSize);
        btBack.setMaximumSize(btSize);
        //pnStats.setPreferredSize(new Dimension(350,200));
        
        //Komponensek színének beállítása
        pnMenu.setBackground(Color.black);
        pnMenu.setOpaque(false);
        
        //Tooltip beállítása
        btShop.setToolTipText("A béta verzióig nem kerül implementálásra");
        
    }

    private void initPanel() {
        
        setLayout(new GridBagLayout());
        Box box = Box.createHorizontalBox();
        
        box.add(Box.createRigidArea(new Dimension(0,30)));
        box.add(pnMenu);
        box.add(pnStats);
        
        add(box, new GridBagConstraints());
        
    }
    
    /*
     * Beállítja a címkék tartalmát
     */
    private void setContent(){
        
        lbAvatar.setIcon(DataManager.getSelectedHero().getAvatar().getIcon());
        lbText.setText("<html><h1 color='#FFFFFF'>Kampány</h1></html>");
        lbName.setText("<html><h2>"+DataManager.getSelectedHero().getName()+"</h2></html>");
        lbSpellpower.setText("Varázserő: "+String.valueOf(DataManager.getSelectedHero().getSpellpower()));
        lbResistance.setText("Ellenállás: "+String.valueOf(DataManager.getSelectedHero().getResistance()));
        lbCritical.setText("Kritikus: "+String.valueOf(DataManager.getSelectedHero().getCritical()));
        lbXP.setText("Tapasztalat: "+String.valueOf(DataManager.getSelectedHero().getXp()));
        lbGold.setText("Arany: "+String.valueOf(DataManager.getSelectedHero().getGold()));
        lbHP.setText("Élet: "+String.valueOf(DataManager.getSelectedHero().getHp()));
        lbLevel.setText("Szint: "+String.valueOf(DataManager.getSelectedHero().getLevel()));
        lbZodiac.setText(DataManager.getSelectedHero().getZodiac().getName());
        lbElement.setText(DataManager.getSelectedHero().getElement().getName());
        
    }
    
    /*
     * Frissiti a panel komponenseit
     */
    @Override
    public void refresh(){
      setContent();  
    }
}
