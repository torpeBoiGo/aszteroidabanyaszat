package Skeleton;

import java.util.Vector;


/**
 * A gyozelem ellenorzesere szolgalo osztaly
 */
public class Gyozelem extends Epitheto {

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
    }
	
	/**
     * A gyozelem epithetove valasa utan fut le
     */
    @Override
    public Vector<Szallithato> Letrejon(Aszteroida a) {
        return new Vector<>();
    }
}
