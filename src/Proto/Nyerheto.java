package Proto;

import java.util.Vector;

/**
 * A nyerhetoseget vizsgalo epitheto osztaly
 */
public class Nyerheto extends Epitheto {
	/**
	 * A Nyerheto osztaly parameter nelkuli konstruktora, mely hozzaadja az alapanyagokhoz a jatek megnyeresehez szukseges anyagokat.
	 */
    public Nyerheto(){
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
     * A nyerhetoseg vizsgalatahoz szukseges
     * @param a Az aszteroida, amin letrejon az objektum
     * @return amiket a telepes rakterbe kell tenni- itt null 
     */
    @Override
    public Vector<Szallithato> Letrejon(Aszteroida a) {
        return new Vector<>();
    }
}
