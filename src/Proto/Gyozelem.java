package Proto;

import java.util.Vector;


/**
 * A gyozelem ellenorzesere szolgalo osztaly
 */
public class Gyozelem extends Epitheto {

	/**
	 *  A Gyozelem osztaly parameter nelkuli konstruktora, mely hozzaadja az alapanyagokhoz a jatek megnyeresehez szukseges anyagokat.
	 */
    public Gyozelem(){
        Hozzaad(new Vas());
        Hozzaad(new Vas());
        Hozzaad(new Vas());
        Hozzaad(new Vizjeg());
        Hozzaad(new Vizjeg());
        Hozzaad(new Vizjeg());
        Hozzaad(new Uran());
        Hozzaad(new Uran());
        Hozzaad(new Uran());
        Hozzaad(new Szen());
        Hozzaad(new Szen());
        Hozzaad(new Szen());

    }
	
	/**
     * A gyozelem vizsgalatahoz szukseges
     * @param a Az aszteroida, amin letrejon az objektum
     * @return amiket a telepes rakterbe kell tenni- itt null 
     */
    @Override
    public Vector<Szallithato> Letrejon(Aszteroida a) {
        return new Vector<>();
    }
}
