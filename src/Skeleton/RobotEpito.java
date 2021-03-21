package Skeleton;

import java.util.Vector;

public class RobotEpito extends Epitheto {
    public RobotEpito() {
        SkeletonController.ObjectCreated(this);
    }

    @Override
    public Vector<Szallithato> Letrejon(Aszteroida a) {
        SkeletonController.FunctionCall(new Object() {
        }.getClass().getEnclosingMethod().getName(), this);

        //TODO ez mi a fasz?
        Robot r = new Robot(a);

        SkeletonController.FunctionReturn();

        return null;
    }
}
