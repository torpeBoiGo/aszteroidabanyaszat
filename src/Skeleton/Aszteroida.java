package Skeleton;

import java.util.ArrayList;
import java.util.List;

public class Aszteroida implements Mezo {
    public String name;
    List<Mezo> szomszedok = new ArrayList<Mezo>();
    int kulsoRetegek;
    Nyersanyag mag;
    List<Hajo> hajok = new ArrayList<Hajo>();
    boolean napkozelben;

    public Aszteroida() {
        SkeletonController.ObjectCreated(this);
    }

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

    public boolean NapkozelbenE() {
        return napkozelben;
    }

    public List<Mezo> getSzomszedok() {
        return szomszedok;
    }

    
    /**
     * Egy szomszedot adunk az aszteroidahoz
     * A szomszedban is beallitja hogy ez az aszteroida szomszedja legyen
     * @param Mezo m - az uj szomszed
     */
    public void AddSzomszed(Mezo m) {
        SkeletonController.FunctionCall(new Object() {
        }.getClass().getEnclosingMethod().getName(), this);
        szomszedok.add(m);
        SkeletonController.FunctionReturn();
    }

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

    @Override
    public void RemoveSzomszed(Mezo m) {
        SkeletonController.FunctionCall(new Object() {
        }.getClass().getEnclosingMethod().getName(), this);
        if (m != null) szomszedok.remove(m);
        SkeletonController.FunctionReturn();
    }

    @Override
    public void HajoErkezik(Hajo h) {
        SkeletonController.FunctionCall(new Object() {
        }.getClass().getEnclosingMethod().getName(), this);

        hajok.add(h);
        h.MezoBeallit(this);

        SkeletonController.FunctionReturn();
    }

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

        int levanfurva = SkeletonController.AskForInput("Az aszteroida le van furva(kulso retegeinek szama 0)? ", new ArrayList<>() {{
            add("igen");
            add("nem");
        }});

        if (levanfurva == 0) {
            System.out.println("kilepes");
        } else {
            int vanmagja = SkeletonController.AskForInput("Az aszteroidaban talalhato mag? ", new ArrayList<>() {{
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
                System.out.println("nem lehet elhelyezni a nyersanyagot az aszteroid�ba");
                break;
            default:
                System.out.println("Rossz bemenet");
                break;
        }

        SkeletonController.FunctionReturn();
        return false;

    }


}
