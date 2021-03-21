package Skeleton;

import java.util.ArrayList;
import java.util.List;

/**A jatekban szerplo aszteroida*/
public class Aszteroida implements Mezo {
	//ez mi?
    public String name;
    /**Az aszteroida szomszedjai*/
    List<Mezo> szomszedok = new ArrayList<Mezo>();
    /**Az aszteroida kulso retegeinek a szama*/
    int kulsoRetegek;
    /**Az aszteroida magjaban levo nyersanyag*/
    Nyersanyag mag;
    /**Az aszteroidan tartozkodo hajok*/
    List<Hajo> hajok = new ArrayList<Hajo>();
    /**Megmutatja, hogy az aszteroida napkozelben van-e*/
    boolean napkozelben;

    /**Konstruktor*/
    public Aszteroida() {
        SkeletonController.ObjectCreated(this);
    }

    /**Az aszteroida furasa*/
    public void Fur() {
        SkeletonController.FunctionCall(new Object() {
        }.getClass().getEnclosingMethod().getName(), this);
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

        if (napkozeli == 1 & atfurva == 1) mag.Megfurva(this);
        SkeletonController.FunctionReturn();
    }
    
    
    /*public Nyersanyag Kinyer(){
        if(kulsoRetegek>0 || mag == null){
            return null;
        }
        else{
            return mag;
        }

    }*/

    /**Kiveszi a magban levo nyersanyagot es visszaadja azt
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
                System.out.println("a meg nem nyerheto ki");
                break;
            default:
                System.out.println("Rossz bemenet");
                break;
        }
        SkeletonController.FunctionReturn();
        return null;
    }

    /**Visszater azzal, hogy az aszteroida napokezelben van-e
     * @return igaz, ha az aszteroida napkozelben van, egyebkent hamis
     */
    public boolean NapkozelbenE() {
        return napkozelben;
    }

    /**Visszater az aszteroida szomszedjait tartalmazo listaval
     * @return az aszteroida szomszedjai
     */
    public List<Mezo> getSzomszedok() {
        return szomszedok;
    }

    /**Hozzaadja az aszteroida szomszedjaihoz a mezot
     * @param m az aszteroida uj szomszedja
     */
    public void AddSzomszed(Mezo m) {
        SkeletonController.FunctionCall(new Object() {
        }.getClass().getEnclosingMethod().getName(), this);
        szomszedok.add(m);
        SkeletonController.FunctionReturn();
    }

    /**Ez a fuggyveny felel az aszteroida felrobbanasaert
     * A rajta levo hajok felrobbanak,
     * a szomszedos mezok eltavolitjak a szomszedjaik kozul
     */
    @Override
    public void Robban() {
        SkeletonController.FunctionCall(new Object() {
        }.getClass().getEnclosingMethod().getName(), this);
        List<Hajo> hajo_temp = new ArrayList<Hajo>(hajok);
        for (Hajo hajo : hajo_temp) {
            hajo.Robbanas();
        }
        List<Mezo> szomszedok_temp = new ArrayList<Mezo>(szomszedok);
        for (Mezo mezo : szomszedok_temp) mezo.RemoveSzomszed(this);
        SkeletonController.FunctionReturn();
    }

    /**Eltavolitja a parameterkent kapott mezot a szomszedjai kozul
     * @ param m az eltavolitando mezo
     */
    @Override
    public void RemoveSzomszed(Mezo m) {
        SkeletonController.FunctionCall(new Object() {
        }.getClass().getEnclosingMethod().getName(), this);
        if (m != null) szomszedok.remove(m);
        SkeletonController.FunctionReturn();
    }

    /**Hozzadja a parameterkent kapott hajot az aszteroida
     * @ param h az erkezo hajo
     */
    @Override
    public void HajoErkezik(Hajo h) {
        SkeletonController.FunctionCall(new Object() {
        }.getClass().getEnclosingMethod().getName(), this);

        hajok.add(h);
        h.MezoBeallit(this);

        SkeletonController.FunctionReturn();
    }

    /**Eltavolitja a parameterkent kapott hajot az aszteroidarol
     * @param h az eltavolitando hajo
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


    /**Elhelyezi a parameterkent kapott nyersanyagot az aszteroida magjaban.
     * Ez csak, akkor tortenhet meg ha az aszteroida teljesen at van furva es ureges.
     * @param n az elhelyezendo nyersanyag
     * @return igaz, ha sikeres volt a muvelet, egyebkent hamis
     */
    public boolean AddMag(Nyersanyag n) {
        SkeletonController.FunctionCall(new Object() {
        }.getClass().getEnclosingMethod().getName(), this);
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


}
