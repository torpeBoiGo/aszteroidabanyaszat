package Proto;

/**
 * A jatekban szereplo uran nyersanyag
 */
public class Uran extends Nyersanyag implements Szallithato{
	/**
	 * Az uran expozicios szamat tarolja, 
	 * azt, hogy hanyszor volt mar teljesen atfurt aszteroidában napkozelben, 
	 * ha ez meghaladja a kettot, felrobban. 
	 * Alapertelmezett erteke 0.
	 */
	int expozicio = 0;
	
	/**
	 * Konstruktor
	 */
	public Uran() {
	}
	
	/**
	 * Az uran osztaly konstruktora melyben megadhato, hogy mennyi az expozicios szama.
	 * @param expoz
	 */
	public Uran(int expoz) {
		expozicio = expoz;
	}
	
    /**
     * fuggveny akkor hivodik, mikor az uranrol lekerul az utolso kulsoreteg is,
     * valamint  az  aszteroidaja  napkozelben  van. Ekkora az expozicios szama no.
     * Ha az expozicios szama nagyobb, mint ketto, akkor felrobban.
     * @param a Az aszteroida, amin az uran van.
     */
    @Override
    public void Megfurva(Aszteroida a) {
    	expozicio++;
    	
    	if(expozicio > 2) {
    		a.Robban();
    		Jatek.NamesMap.remove(Jatek.getKeyByValue(Jatek.NamesMap, this));
    	}
    		
    }
    
    /**
     * Visszater az uran tulajdonságait tartalmazo Stringgel: expozicios szama, a kimeneti nyelvnek megfelelõ formában
     */
    @Override
    public String toString() {
    	return "Expozicio: " + expozicio + ":int\n";
    }
}

