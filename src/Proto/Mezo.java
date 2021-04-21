package Proto;

/**
 * Egy mezot ir le aminek szomszedai lehetnek es erkezhetnek ra hajok
 */
public interface Mezo {
	/**
	 * A mezo felrobban
	 */
    void Robban();
    
    /**
     * A mezo viselkedeset irja le, ha napvihar eri.
     * @param center Megadja, hogy a mezo a napvihar kozeppontjaban van-e.
     */
    void Napvihar(boolean center);
    
    /**
     * A mezo szomszedjai kozul egyet eltavolit.
     * @param m az eltavolitando szomszed
     */
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