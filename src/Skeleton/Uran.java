package Skeleton;

/**
 * A jatekban szereplo uran nyersanyag
 */
public class Uran extends Nyersanyag implements Szallithato{
	
	int expozicio = 0;
	public Uran() {
	}
	public Uran(int expoz) {
		expozicio = expoz;
	}
	
    /**
     * fuggveny akkor hivodik, mikor az uranrol lekerul az utolso kulsoreteg is,
     * valamint  az  aszteroidaja  napkozelben  van. Ekkora az uran felrobban.
     *
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
    
    @Override
    public String toString() {
    	return "Expozicio: " + expozicio + ":int\n";
    }
}

