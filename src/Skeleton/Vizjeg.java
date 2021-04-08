package Skeleton;

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
        Main.NamesMap.remove(Main.getKeyByValue(Main.NamesMap, this));
    }
    
    @Override 
    public String toString() {
    	return "";
    }
}
