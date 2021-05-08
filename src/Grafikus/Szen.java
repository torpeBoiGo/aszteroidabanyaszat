package Grafikus;

/**
 * A jatekban szereplo szen nyersanyag
 */
public class Szen extends Nyersanyag {
    /**
     * Kiirja a szen adatait a kimeneti nyelvnek megfeleloen, jelen esetben ures Stringgel ter vissza.
     */
    @Override
    public String toString() {
        return "";
    }

    /**
     * A szenhez ezt a szöveget kell kirajzolni a grafikára
     * @return A kért szöveg
     */
    @Override
    public String print() {
        return "Szen";
    }
}