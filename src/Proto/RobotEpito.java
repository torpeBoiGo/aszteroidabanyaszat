package Proto;

import java.util.Vector;

/**
 * 
 * A robotepitest megvalosito osztaly.
 *
 */
public class RobotEpito extends Epitheto {
	

	static int builtNum= 1;
	
    /**
     * Konstruktor.
     */
	public RobotEpito() {
		Hozzaad(new Vas());
    	Hozzaad(new Szen());
    	Hozzaad(new Uran());
    }

	/**
	 * A robotot letrehozo fuggveny, a robotot az adott aszteroidara helyezi, visszareteresi erteke null.
	 *  @param  a - aszteroida ahol epitunk
	 *  @return Vector<Szallithato> - amiket a telepes rakterbe kell tenni- itt null  
	 */
    @Override
    public Vector<Szallithato> Letrejon(Aszteroida a) {

        Robot r = new Robot(a);
        Jatek.NamesMap.put("builtRobot" + builtNum++, r);
        return null;
    }
}
