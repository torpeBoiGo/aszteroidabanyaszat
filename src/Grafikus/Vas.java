package Grafikus;

/**A jatekban szereplo vas nyersanyag*/
public class Vas extends Nyersanyag{
	/**
	 * Kiirja a vas adatait a kimeneti nyelvnek megfeleloen, jelen esetben ures Stringgel ter vissza.
	 */
	@Override 
    public String toString() {
    	return "";
    }
	/**
	 * A vashoz ezt a szöveget kell kirajzolni a grafikára
	 * @return A kért szöveg
	 */
	@Override
	public String print() {
		return "Vas";
	}
}
