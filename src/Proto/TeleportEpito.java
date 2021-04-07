package Proto;

import java.util.Vector;

/**
 * A teleportkapuk epiteset megvalosito osztaly.
 */
public class TeleportEpito extends Epitheto {
    /**
     * Konstruktor.
     */
    public TeleportEpito() {
    }

    /**
     * A teleportkapukat letrehozo fuggveny, a visszareteresi erteke a letrejott kapuk.
     *
     * @param a - aszteroida ahol epitunk
     * @return Vector<Szallithato> - amiket a telepes rakterbe kell tenni- itt ket teleportkapu
     */
    @Override
    public Vector<Szallithato> Letrejon(Aszteroida a) {
        Teleportkapu k1 = new Teleportkapu();
        Teleportkapu k2 = new Teleportkapu();
        k1.SetPar(k2);
        k2.SetPar(k1);
        Vector<Szallithato> kapuk = new Vector<>();
        kapuk.add(k1);
        kapuk.add(k2);

        return kapuk;
    }
}
