package Grafikus;

/**
 * A jatekban szereplo vizjeg nyersanyag
 */
public class Vizjeg extends Nyersanyag {
	/**
     * fuggveny akkor hivodik, mikor a vizjegrol lekerul az utolso kulsoreteg is,
     * valamint  az  aszteroidaja  napkozelben  van. Ekkora a vizjeg elszublimal.
     *
     * @param a Az aszteroida, amin a vizjeg van.
     */
    @Override
    public void Megfurva(Aszteroida a) {
        Nyersanyag kinyert = a.Kinyer();
        MainGUI.NamesMap.remove(MainGUI.getKeyByValue(MainGUI.NamesMap, this));
    }

    @Override
    public String print() {
        return "Vizjeg";
    }

    /**
     * Kiirja a vizjeg adatait a kimeneti nyelvnek megfeleloen,jelen esetben ures Stringgel ter vissza.
     */
    @Override 
    public String toString() {
    	return "";
    }
}
