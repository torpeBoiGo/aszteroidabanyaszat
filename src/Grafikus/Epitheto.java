package Grafikus;

import java.util.ArrayList;
import java.util.Vector;


/**
 * Absztrakt osztaly epitheto objektumok megvalositasara 
 */
public abstract class Epitheto {
	/**
	 *  Tarolja, hogy az egyes epitheto objektumokhoz milyen nyersanyagok kellenek.
	 */
	ArrayList<Nyersanyag> alapanyagok = new ArrayList<>();
	
	/**
     * Ellenorzi, hogy a parameterul kapott nyersanyag kell-e az adott dolog epitesehez.
     * @param n - A nyersanyag amit hozzaadunk a szukseges nyersanyagok listajhoz
     */
    public void Hozzaad(Nyersanyag n) {
    	alapanyagok.add(n);
    }
    
    /**
     * Ellenorzi, hogy a parameterul kapott nyersanyag kell-e az adott dolog epitesehez.
     * @param n A nyersanyag, amirol el kell donteni, hogy kell-e az epiteshez.
     * @return True vagy False aszerint, hogy az adott nyersanyag kell-e az epiteshez, vagy nem.
     */
    public boolean KellE(Nyersanyag n) {


		for (Nyersanyag ny : alapanyagok) {
		    if(n!= null){
				if (n.KompatibilisE(ny)) {
					alapanyagok.remove(ny);
					return true;
				}
		    }
		}

    	return false;
    }
    
    /**
     * Ellenorzi, hogy a KellE fuggvenyben megkapott nyersanyagok felhasznalasaval megepitheto-e az adott dolog.
     * @return True vagy False aszerint, hogy az adott dolog megepitheto-e, vagy sem.
     */
    public boolean EpithetoE() {
    	if(!alapanyagok.isEmpty()) {
    		Reset();
    		return false;
    	}return true;
    }
    
    /**
     * Reset-eli az epitheto objektum tartalmat, ami a KellE fuggveny meghivasai miatt nem lenne hasznalhato egy ujabb epiteshez.
     */
    public void Reset() {
    	alapanyagok.clear();
    }
    
    /**
     * Letrehozza a megadott aszteroidan a megfelelo dolgokat (robotot vagy teleportkapukat).
     * @param a Az aszteroida, ahol az epites tortenik (a robot epitesenel lenyeges).
     * @return A letrejott dolgok (a teleportepitesnel lenyeges).
     */
    public abstract Vector<Szallithato> Letrejon(Aszteroida a);


}
