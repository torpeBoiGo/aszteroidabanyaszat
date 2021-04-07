package Proto;

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
    }

	/**
	 * A robotot letrehozo fuggveny, a robotot az adott aszteroidara helyezi, visszareteresi erteke null.
	 *  @param a - aszteroida ahol epitunk
	 *  @return Vector<Szallithato> - amiket a telepes rakterbe kell tenni- itt null  
	 */
    @Override
    public Vector<Szallithato> Letrejon(Aszteroida a) {

        Robot r = new Robot(a);


        return null;
    }
}
