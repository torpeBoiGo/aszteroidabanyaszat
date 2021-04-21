package Grafikus;

/**
 * 
 * A hajo mukodeset megvalosito osztaly, a Telepes es Robot ososztalya
 *
 */
abstract class Hajo{

    /**
     * A Hajo ezen az aszteroidan tartozkodik.
     */
    protected Aszteroida aszteroida;	
    
    /**
     * A hajo ezzel a fuggvennyel tud masik mezore lepni
     * @param uj_mezo - az uj mezo amire atmegy a hajo
     */
    public void Mozog(Mezo uj_mezo) {
        if((uj_mezo!=null) && (Palya.aszteroidak.get(Palya.aszteroidak.indexOf(aszteroida)).getSzomszedok().contains(uj_mezo))) {
            uj_mezo.HajoErkezik(this);
        }
    }

    /**
     * Hajot napvihar eri.
     */
    abstract public void Napvihar();

    /**
     * Hajo felrobban. Absztrakt.
     */
    abstract void Robbanas();

    /**
     * A Hajo lep egyet. Absztrakt
     */
    abstract void Lepes();

    /**
     * Hajo megsemmisul.
     */
     abstract void Meghal();

    /**
     * Hajo tetlen.
     */
    public void Tetlen() {
    }

    /**
     * Az aszteroida erteket allitja be a kapottra.
     * @param m Az uj mazo
     */
    public void MezoBeallit(Mezo m) {
        if (aszteroida != null)
            aszteroida.HajoElhagy(this);
        aszteroida = (Aszteroida) m;
    }

    
    /**
     * Ellenorzi a hajo mivel jarulhat hozza a gyozelemhez
     */
    abstract void NyerEllenoriz(Epitheto e);
}