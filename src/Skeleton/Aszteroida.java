package Skeleton;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

/**
 * Az aszteroida mukodeseet megvalosito osztaly.
 */
public class Aszteroida implements Mezo, Showable{


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
        SkeletonController.ObjectCreated(this);
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
     * @return true, ha ureges, false, ha van benne mag
     */
    public boolean UregesE() {
    	return (mag == null);
    }
    
    /**
     * A sziklaretegek szamat adja vissza
     * @return a retegek szama
     */
    public int GetKulsoRetegek() {
    	return kulsoRetegek;
    }


    //uj konstruktor
    public Aszteroida( int kulsoRetegek, boolean napkozelben) {

        this.kulsoRetegek = kulsoRetegek;
        this.napkozelben = napkozelben;
    }

    //addSzomszed

    public void addSzomszed(Mezo m){
        szomszedok.add(m);
    }


    /**
     * Az aszteroida furasa
     */

    public void Fur() {
        SkeletonController.FunctionCall(new Object() {
        }.getClass().getEnclosingMethod().getName(), this);
        this.kulsoRetegek--;
        
        int napkozeli = SkeletonController.AskForInput("Napkozelben van az aszteroida?", new ArrayList<String>() {{
            add("igen");
            add("nem");
        }});
        switch (napkozeli) {
            case 0:
                System.out.println("kilepes");
                return;
            case 1:
                System.out.println("napkozelben van az aszteroida");
                break;
            case 2:
                System.out.println("nincs napkozelben az aszteroida");
                break;
            default:
                System.out.println("Rossz bemenet");
                break;
        }

        int atfurva = SkeletonController.AskForInput("Teljesen at van furva az aszteroida?", new ArrayList<String>() {{
            add("igen");
            add("nem");
        }});

        switch (atfurva) {
            case 0:
                System.out.println("kilepes");
                return;
            case 1:
                System.out.println("teljesen at van furva az aszteroida");
                break;
            case 2:
                System.out.println("nincs teljesen atfurva az aszteroida");
                break;
            default:
                System.out.println("Rossz bemenet");
                break;
        }

        if (napkozeli == 1 & atfurva == 1 && mag != null) mag.Megfurva(this);
        SkeletonController.FunctionReturn();
    }


    /**
     * Kiveszi a magban levo nyersanyagot es visszaadja azt
     *
     * @return a magban levo nyersanyag
     */
    public Nyersanyag Kinyer() {
        SkeletonController.FunctionCall(new Object() {
        }.getClass().getEnclosingMethod().getName(), this);
        int kinyerheto = SkeletonController.AskForInput("Kinyerheto az aszteroida magja?", new ArrayList<String>() {{
            add("igen");
            add("nem");
        }});

        switch (kinyerheto) {
            case 0:
                System.out.println("kilepes");
                break;
            case 1:
                System.out.println("a mag kinyerheto");
                Nyersanyag kinyert = mag;
                mag = null;
                SkeletonController.FunctionReturn();
                return kinyert;
            case 2:
                System.out.println("a mag nem nyerheto ki");
                break;
            default:
                System.out.println("Rossz bemenet");
                break;
        }
        SkeletonController.FunctionReturn();
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
        SkeletonController.FunctionCall(new Object() {
        }.getClass().getEnclosingMethod().getName(), this);
        szomszedok.add(m);
        SkeletonController.FunctionReturn();
    }

    /**
     * Ez a fuggyveny felel az aszteroida felrobbanasaert
     * A rajta levo hajok felrobbanak,
     * a szomszedos mezok eltavolitjak a szomszedjaik kozul
     */
    @Override
    public void Robban() {
        SkeletonController.FunctionCall(new Object() {
        }.getClass().getEnclosingMethod().getName(), this);
        List<Hajo> hajo_temp = new ArrayList<>(hajok);
        for (Hajo hajo : hajo_temp) {
            hajo.Robbanas();
        }
        List<Mezo> szomszedok_temp = new ArrayList<>(szomszedok);
        for (Mezo mezo : szomszedok_temp) mezo.RemoveSzomszed(this);
        SkeletonController.FunctionReturn();
    }

    /**
     * Eltavolitja a parameterkent kapott mezot a szomszedjai kozul
     *
     * @ param m az eltavolitando mezo
     */
    @Override
    public void RemoveSzomszed(Mezo m) {
        SkeletonController.FunctionCall(new Object() {
        }.getClass().getEnclosingMethod().getName(), this);
        if (m != null) szomszedok.remove(m);
        SkeletonController.FunctionReturn();
    }

    /**
     * Az aszteroidara egy Hajo erkezik.
     *
     * @param h - a hajo ami erkezik az aszteroidara
     */
    @Override
    public void HajoErkezik(Hajo h) {
        SkeletonController.FunctionCall(new Object() {
        }.getClass().getEnclosingMethod().getName(), this);

        hajok.add(h);
        h.MezoBeallit(this);

        SkeletonController.FunctionReturn();
    }

    /**
     * Az aszteroidarol lekerul egy Hajo.
     */
    @Override
    public void HajoElhagy(Hajo h) {
        SkeletonController.FunctionCall(new Object() {
        }.getClass().getEnclosingMethod().getName(), this);
        hajok.remove(h);
        SkeletonController.FunctionReturn();
    }

    /**
     * Az aszteroidat napvihar eri.
     */
    public void Napvihar() {
        SkeletonController.FunctionCall(new Object() {
        }.getClass().getEnclosingMethod().getName(), this);

        int levanfurva = SkeletonController.AskForInput("Az aszteroida le van furva(kulso retegeinek szama 0)? ", new ArrayList<String>() {{
            add("igen");
            add("nem");
        }});

        if (levanfurva == 0) {
            System.out.println("kilepes");
        } else {
            int vanmagja = SkeletonController.AskForInput("Az aszteroidaban talalhato mag? ", new ArrayList<String>() {{
                add("igen");
                add("nem");
            }});
            if (vanmagja == 0) {
                System.out.println("kilepes");
            } else {
                if (levanfurva == 2 || vanmagja == 1) {
                    List<Hajo> hajo_temp = new ArrayList<Hajo>(hajok);
                    for (Hajo h : hajo_temp) {
                        h.Napvihar();
                    }
                }
            }
            SkeletonController.FunctionReturn();
        }
    }


    /**
     * Az aszteroida magjaba egy nyersanyag kerul.
     *
     * @param n A magba kerulo nyersanyag.
     * @return True vagy False aszerint, hogy sikeres-e a nyersanyag magba helyezese.
     */
    public boolean AddMag(Nyersanyag n) {
        SkeletonController.FunctionCall(new Object() {
        }.getClass().getEnclosingMethod().getName(), this);

        int napkozeli = SkeletonController.AskForInput("Napkozelben van az aszteroida?", new ArrayList<String>() {{
            add("igen");
            add("nem");
        }});
        switch (napkozeli) {
            case 0:
                System.out.println("kilepes");
                return false;
            case 1:
                System.out.println("napkozelben van az aszteroida");
                napkozelben = true;
                break;
            case 2:
                System.out.println("nincs napkozelben az aszteroida");
                napkozelben = false;
                break;
            default:
                System.out.println("Rossz bemenet");
                break;
        }


        int atfurva = SkeletonController.AskForInput("El lehet helyezni a nyersanyagot az aszteroidaban?", new ArrayList<String>() {{
            add("igen");
            add("nem");
        }});

        switch (atfurva) {
            case 0:
                System.out.println("kilepes");
                return false;
            case 1:
                System.out.println("el lehet helyezni a nyersanyagot az aszteroidaban");
                if (napkozelben) {
                    n.Megfurva(this);
                }
                mag = n;
                SkeletonController.FunctionReturn();
                return true;
            case 2:
                System.out.println("nem lehet elhelyezni a nyersanyagot az aszteroidaban");
                break;
            default:
                System.out.println("Rossz bemenet");
                break;
        }

        SkeletonController.FunctionReturn();
        return false;

    }

    public void Show() {
    	System.out.println("Kulso retegek: " + kulsoRetegek);
    	System.out.println("Naplkozelben: " + napkozelben);

    	System.out.print("Hajok: ");
    	StringJoiner lineJoiner = new StringJoiner(",");
    	for (Hajo hajo : hajok) {
    		lineJoiner.add(Main.getKeyByValue(Main.NamesMap, hajo)+": " + hajo.getClass().getSimpleName());
		}
    	System.out.println(lineJoiner.toString() + ": hajo[0..*]");
    	lineJoiner = new StringJoiner(",");
    	System.out.print("NyersanyagRakter: ");
    	for (Mezo szomszed : szomszedok) {
    		lineJoiner.add(Main.getKeyByValue(Main.NamesMap, szomszed)+": " + szomszed.getClass().getSimpleName());
		}
    	System.out.println(lineJoiner.toString() + ": mezo[0..*]");

	}
}
