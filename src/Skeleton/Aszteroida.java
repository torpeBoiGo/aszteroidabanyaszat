package Skeleton;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.StringJoiner;

/**
 * Az aszteroida mukodeseet megvalosito osztaly.
 */
public class Aszteroida implements Mezo, Leptetheto {


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
    private Nyersanyag mag;
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
        Palya.AddAszteroida(this);
    }

    //uj konstruktor
    public Aszteroida(int kulsoRetegek, boolean napkozelben) {
        Palya.AddAszteroida(this);

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


    /**
     * megmondja, hogy az aszeroida ureges-e
     *
     * @return true, ha ureges, false, ha van benne mag
     */
    public boolean UregesE() {
        return (mag == null);
    }

    /**
     * A sziklaretegek szamat adja vissza
     *
     * @return a retegek szama
     */
    public int GetKulsoRetegek() {
        return kulsoRetegek;
    }

    /**
     * Az aszteroida furasa
     */

    public void Fur() {
        if (kulsoRetegek > 0) kulsoRetegek--;
    }


    /**
     * Kiveszi a magban levo nyersanyagot es visszaadja azt
     *
     * @return a magban levo nyersanyag
     */
    public Nyersanyag Kinyer() {
        if (kulsoRetegek == 0) {
            Nyersanyag kinyert = mag;
            mag = null;
            return kinyert;
        } else {
            return null;
        }
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

        Palya.RemoveAszteroida(this);
        Jatek.NamesMap.remove(Jatek.getKeyByValue(Jatek.NamesMap, this));
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
       if (mag != null || kulsoRetegek != 0) {
    	   for (int i = hajok.size() - 1; i >= 0; i--)
    	   {
    		   hajok.get(i).Napvihar();
    	   }
       }
       
       
       //TODO: a szomszedos teleportkapukra meghivni a napvihart.
    }


    /**
     * Az aszteroida magjaba egy nyersanyag kerul.
     *
     * @param n A magba kerulo nyersanyag.
     * @return True vagy False aszerint, hogy sikeres-e a nyersanyag magba helyezese.
     */
    public boolean AddMag(Nyersanyag n) {
        if (kulsoRetegek != 0 || mag != null) return false;
        else {
            mag = n;
            return true;
        }
    }

    @Override
    public void Lepes() {
        if (napkozelben && kulsoRetegek == 0) {
        	
            if (mag != null) mag.Megfurva(this);
        }

    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Kulso retegek: ").append(kulsoRetegek).append(": int\n");
        if (mag == null) {
            sb.append("Nyersanyag: null\n");
        } else {
            sb.append("Nyersanyag: ").append(Jatek.getKeyByValue(Jatek.NamesMap, mag)).append(": ").append(mag.getClass().getSimpleName()).append("\n");
        }
        sb.append("Napkozelben: ").append(napkozelben).append(" :bool\n");

        sb.append("Hajok: ");
        StringJoiner lineJoiner = new StringJoiner(",");
        for (Hajo hajo : hajok) {
            lineJoiner.add(Jatek.getKeyByValue(Jatek.NamesMap, hajo) + ": " + hajo.getClass().getSimpleName());
        }
        sb.append(lineJoiner).append(" :hajok[0..*]").append("\n");
        lineJoiner = new StringJoiner(",");
        sb.append("Szomszedok: ");
        for (Mezo szomszed : szomszedok) {
            lineJoiner.add(Jatek.getKeyByValue(Jatek.NamesMap, szomszed) + ":" + szomszed.getClass().getSimpleName());
        }
        sb.append(lineJoiner).append(":mezo[0..*]").append("\n");
        return sb.toString();
    }

    public Nyersanyag getMag() {
        return mag;
    }
}
