package Proto;

/**
 * A jatekban szereplo nyersanyagok ososztalya
 */
public abstract class Nyersanyag implements Szallithato{
    /**
     * Konstruktor
     */
    public Nyersanyag() {
    }

    /**
     * A nyersanyag megsemmisulesert felel
     */
    public void Megsemmisul() {
    }

    /**
     * A fuggveny, akkor hivodik meg,
     * mikor a nyersanyagrol lekerul az utolso kulsoreteg is,
     * valamint az aszteroidaja napkozelben  van
     *
     * @param a Az aszteroida, amin a nyersanyag van
     */
    public void Megfurva(Aszteroida a) {
    }

    /**
     * A  fuggveny  megvizsgalja, hogy a parameterkent kapott nyersanyag
     * azonos vagy kompatibilis-e a nyersanyaggal
     *
     * @param ny Az osszehasonlitando nyersanyag
     * @return igaz, ha a ket nyersanyag azonos tipusu, egyebkent hamis
     */
    public boolean KompatibilisE(Nyersanyag ny) {
                return false;
    }
}
