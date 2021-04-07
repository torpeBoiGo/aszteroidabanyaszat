package Proto;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

/**
 * Az aszteroida mukodeseet megvalosito osztaly.
 */
public class Aszteroida implements Mezo{


    /**
     * Az aszteroidaval szomszedos aszteriodak
     */
    List<Mezo> szomszedok = new ArrayList<>();

    /**
     * A mag korul levo sziklaretegek szama
     */
    int kulsoRetegek;
    /**
     * Az aszteroida magjaban talalhato nyersanyag
     */
    Nyersanyag mag;
    /**
     * Az aszteroidan tartozkodo Hajok
     */
    List<Hajo> hajok = new ArrayList<>();
    /**
     * Napkozelben van-e az aszteroida?
     */
    boolean napkozelben;


    /**
     * Az aszteroida konstruktora
     */
    public Aszteroida() {
    }

    //uj konstruktor
    public Aszteroida(int kulsoRetegek, boolean napkozelben) {

        this.kulsoRetegek = kulsoRetegek;
        this.napkozelben = napkozelben;
    }

    /**
     * Beallitja az aszteroida magjat a parameterkent kapott nyersanyagra
     *
     * @param n az uj mag
     */
    public void SetMag(Nyersanyag n) {
        mag = n;
    }

    //addSzomszed

    public void addSzomszed(Mezo m) {
        szomszedok.add(m);
    }


    /**
     * Az aszteroida furasa
     */

    public void Fur() {
    }


    /**
     * Kiveszi a magban levo nyersanyagot es visszaadja azt
     *
     * @return a magban levo nyersanyag
     */
    public Nyersanyag Kinyer() {
        return null;
    }


    public boolean NapkozelbenE() {
        return napkozelben;
    }


    public List<Mezo> getSzomszedok() {
        return szomszedok;
    }


    /**
     * Egy szomszedot adunk az aszteroidahoz
     * A szomszedban is beallitja hogy ez az aszteroida szomszedja legyen
     *
     * @param m - az uj szomszed
     */
    public void AddSzomszed(Mezo m) {
        szomszedok.add(m);
    }

    /**
     * Ez a fuggyveny felel az aszteroida felrobbanasaert
     * A rajta levo hajok felrobbanak,
     * a szomszedos mezok eltavolitjak a szomszedjaik kozul
     */
    @Override
    public void Robban() {
        List<Hajo> hajo_temp = new ArrayList<>(hajok);
        for (Hajo hajo : hajo_temp) {
            hajo.Robbanas();
        }
        List<Mezo> szomszedok_temp = new ArrayList<>(szomszedok);
        for (Mezo mezo : szomszedok_temp) mezo.RemoveSzomszed(this);
    }

    /**
     * Eltavolitja a parameterkent kapott mezot a szomszedjai kozul
     *
     * @ param m az eltavolitando mezo
     */
    @Override
    public void RemoveSzomszed(Mezo m) {
        if (m != null) szomszedok.remove(m);
    }

    /**
     * Az aszteroidara egy Hajo erkezik.
     *
     * @param h - a hajo ami erkezik az aszteroidara
     */
    @Override
    public void HajoErkezik(Hajo h) {
        hajok.add(h);
        h.MezoBeallit(this);
    }

    /**
     * Az aszteroidarol lekerul egy Hajo.
     */
    @Override
    public void HajoElhagy(Hajo h) {
        hajok.remove(h);
    }

    /**
     * Az aszteroidat napvihar eri.
     */
    public void Napvihar() {
    }


    /**
     * Az aszteroida magjaba egy nyersanyag kerul.
     *
     * @param n A magba kerulo nyersanyag.
     * @return True vagy False aszerint, hogy sikeres-e a nyersanyag magba helyezese.
     */
    public boolean AddMag(Nyersanyag n) {
        return false;
    }

    @Override
    public String toString() {
        System.out.println("Kulso retegek: " + kulsoRetegek);
        System.out.println("Naplkozelben: " + napkozelben);

        System.out.print("Hajok: ");
        StringJoiner lineJoiner = new StringJoiner(",");
        for (Hajo hajo : hajok) {
            lineJoiner.add(Main.getKeyByValue(Main.NamesMap, hajo) + ": " + hajo.getClass().getSimpleName());
        }
        System.out.println(lineJoiner + ": hajo[0..*]");
        lineJoiner = new StringJoiner(",");
        System.out.print("NyersanyagRakter: ");
        for (Mezo szomszed : szomszedok) {
            lineJoiner.add(Main.getKeyByValue(Main.NamesMap, szomszed) + ": " + szomszed.getClass().getSimpleName());
        }
        System.out.println(lineJoiner + ": mezo[0..*]");
        return "TODO";
    }
}
