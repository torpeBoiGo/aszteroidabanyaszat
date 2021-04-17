package Skeleton;

/**
 * Egy mezot ir le aminek szomszedai lehetnek es erkezhetnek ra hajok
 */
public interface Mezo {
    void Robban();
    void Napvihar();
    void RemoveSzomszed(Mezo m);

    /**
     * A mezore egy Hajo erkezik.
     * @param h A megerkezo Hajo.
     */
    void HajoErkezik(Hajo h);
    
    /**
     * A mezot elhagyja a Hajo.
     * @param h A mezorol lekerulo Hajo.
     */
    void HajoElhagy(Hajo h);
}