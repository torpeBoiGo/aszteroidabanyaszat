package Proto;

/**
 * A jatekban szereplo uran nyersanyag
 */
public class Uran extends Nyersanyag {
	
	int expozicio = 0;
	
    /**
     * fuggveny akkor hivodik, mikor az uranrol lekerul az utolso kulsoreteg is,
     * valamint  az  aszteroidaja  napkozelben  van. Ekkora az uran felrobban.
     *
     * @param a Az aszteroida, amin az uran van.
     */
    @Override
    public void Megfurva(Aszteroida a) {
        a.Robban();
    }
    
    public void Show() {
    	System.out.println("Expozicio: " + expozicio);
	}
}

