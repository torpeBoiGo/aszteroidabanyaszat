package Skeleton;

import java.util.Vector;

/**
 * 
 * A robotepitest megvalosito osztaly.
 *
 */
public class RobotEpito extends Epitheto {
    /**
     * Konstruktor.
     */
	public RobotEpito() {
        SkeletonController.ObjectCreated(this);
    }

	/**
	 * A robotot letrehozo fuggveny, a robotot az adott aszteroidara helyezi, visszareteresi erteke null.
	 *  @param a - aszteroida ahol epitunk
	 *  @return Vector<Szallithato> - amiket a telepes rakterbe kell tenni- itt null  
	 */
    @Override
    public Vector<Szallithato> Letrejon(Aszteroida a) {
        SkeletonController.FunctionCall(new Object() {
        }.getClass().getEnclosingMethod().getName(), this);

        Robot r = new Robot(a);

        SkeletonController.FunctionReturn();

        return null;
    }
}
