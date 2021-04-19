package Skeleton;

import java.util.Vector;

/**
 * A nyerhetoseg epithetove valasa utan fut le
 */
public class Nyerheto extends Epitheto {

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

    @Override
    public Vector<Szallithato> Letrejon(Aszteroida a) {
        return new Vector<>();
    }
}
