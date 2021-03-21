package Skeleton;

import java.util.Vector;

public class TeleportEpito extends Epitheto {
    public TeleportEpito() {
        SkeletonController.ObjectCreated(this);
    }

    @Override
    public Vector<Szallithato> Letrejon(Aszteroida a) {
        SkeletonController.FunctionCall(new Object() {
        }.getClass().getEnclosingMethod().getName(), this);
        Teleportkapu k1 = new Teleportkapu();
        Teleportkapu k2 = new Teleportkapu();
        k1.SetPar(k2);
        k2.SetPar(k1);
        Vector<Szallithato> kapuk = new Vector<>();
        kapuk.add(k1);
        kapuk.add(k2);

        SkeletonController.FunctionReturn();

        return kapuk;
    }
}
