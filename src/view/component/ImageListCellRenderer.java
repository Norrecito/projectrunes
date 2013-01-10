
package view.component;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListCellRenderer;

public class ImageListCellRenderer implements ListCellRenderer {
  /**
   * From http://java.sun.com/javase/6/docs/api/javax/swing/ListCellRenderer.html:
   * 
   * Return a component that has been configured to display the specified value. 
   * That component's paint method is then called to "render" the cell. 
   * If it is necessary to compute the dimensions of a list because the list cells do not have a fixed size, 
   * this method is called to generate a component on which getPreferredSize can be invoked. 
   * 
   * jlist - the jlist we're painting
   * value - the value returned by list.getModel().getElementAt(index).
   * cellIndex - the cell index
   * isSelected - true if the specified cell is currently selected
   * cellHasFocus - true if the cell has focus
   */
  
  /*
   * A panel háttérszíne
   */
  private Color backgroundColor;
  
  /*
   * A kiválasztás színe
   */
  private Color selectedColor;
  
  /*
   * Az első konstruktor
   * Nem vár paramétert, a standart színeket használja (fekete háttér, szürke kijelőlés)
   */
  public ImageListCellRenderer(){
      this(Color.black, Color.gray);
  }
  
  /*
   * A második konstruktor
   * Két paramétert vár, a panel háttérszínét, illetve a színt amilyenre a panel háttere
   * át lesz színezve ha az ki van jelőlve
   */
    public ImageListCellRenderer(Color backgroundColor, Color selectedColor){
        this.backgroundColor = backgroundColor;
        this.selectedColor = selectedColor;
    }
    
  @Override
  public Component getListCellRendererComponent(JList jlist, 
                                                Object value, 
                                                int cellIndex, 
                                                boolean isSelected, 
                                                boolean cellHasFocus)
  {
    if (value instanceof JPanel)
    {
      Component component = (Component) value;
      component.setForeground (Color.white);
      component.setBackground (isSelected ? selectedColor : backgroundColor);
      return component;
    }
    else
    {
      // TODO - I get one String here when the JList is first rendered; proper way to deal with this?
      //System.out.println("Got something besides a JPanel: " + value.getClass().getCanonicalName());
      return new JLabel("???");
    }
  }  
}
