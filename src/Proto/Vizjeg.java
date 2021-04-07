package Proto;

/**
 * A jatekban szereplo vizjeg nyersanyag
 */
public class Vizjeg extends Nyersanyag {
    /**
     * fuggveny akkor hivodik, mikor a vizjegrol lekerul az utolso kulsoreteg is,
     * valamint  az  aszteroidaja  napkozelben  van. Ekkora a vizjeg elszublimal.
     *
     * @param a Az aszteroida, amin a v�zjeg van.
     */
    @Override
    public void Megfurva(Aszteroida a) {
        Nyersanyag kinyert = a.Kinyer();
    }
}
