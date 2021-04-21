package Grafikus;

import java.util.Vector;

/**
 * 
 * A robot epitest megvalosito osztaly.
 *
 */
public class RobotEpito extends Epitheto {
	/**
	 * Segitsegevel teszunk kulonbseget az egyes letrejove robotok kozott.
	 */
	static int builtNum= 1;
	
    /**
     * Konstruktor, felveszi a robot epitesehez szukseges nyersanyagokat
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
