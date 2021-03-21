package Skeleton;

import java.util.ArrayList;

/**A jatekban szereplo teleportkapu*/
public class Teleportkapu implements Mezo, Szallithato {
    /**A kapu par masik tagja*/
	Teleportkapu par;
	
	/**Az aszteroida, ami kurol kering a kapu*/
    Aszteroida sajatAszteroida;
    
    /**Azt mutatja meg, hogy uzemkepes-e a kapu*/
    boolean mukodikE;
    
    /**Konstruktor*/
    public Teleportkapu() {
        SkeletonController.ObjectCreated(this);
        par = null;
        sajatAszteroida = null;
        mukodikE = true;
    }

    /**Beallitja a teleportkapu parjat a parameterkent kapott teleportkapura
     * 
     * @param p a beallitando teleportkapu
     */
    public void SetPar(Teleportkapu p) {
        SkeletonController.FunctionCall(new Object() {
        }.getClass().getEnclosingMethod().getName(), this);
        par = p;
        SkeletonController.FunctionReturn();
    }
    
    /**Beallitja a teleportkapu aszteroidajat a parameterkent kapottra
     * 
     * @param a a beallitando aszteroida
     */
    public void SetSajatAszteroida(Aszteroida a) {
        SkeletonController.FunctionCall(new Object() {
        }.getClass().getEnclosingMethod().getName(), this);
        this.sajatAszteroida = a;
        SkeletonController.FunctionReturn();
    }
    
    /**Ez a fuggveny felel, azert, ha a teleportkapuba hajo erkezik a parjabol
     * Ekkor tovabb kuldi a hajot az aszteroidajara
     * @param h az erkezo hajo
     */
    public void HajoTeleportErkezik(Hajo h) {
        SkeletonController.FunctionCall(new Object() {
        }.getClass().getEnclosingMethod().getName(), this);
        if (sajatAszteroida != null) {
            sajatAszteroida.HajoErkezik(h);

        }

        SkeletonController.FunctionReturn();
    }

    /**A teleportkapu mukodeskeptelenne valik*/
    public void Elront() {
        SkeletonController.FunctionCall(new Object() {
        }.getClass().getEnclosingMethod().getName(), this);
        mukodikE = false;
        SkeletonController.FunctionReturn();
    }

    @Override
    public void Robban() {
        // TODO Auto-generated method stub

    }

    /**Ez a fuggveny felel, azert, ha az teleportkapuval szomszedos mezo felrobban
     * Ekkor a teleportkapu es a parja is felrobban
     * @param m a felrobbant mezo
     */
    @Override
    public void RemoveSzomszed(Mezo m) {
        SkeletonController.FunctionCall(new Object() {
        }.getClass().getEnclosingMethod().getName(), this);
        if (sajatAszteroida != null) sajatAszteroida.RemoveSzomszed(this);
        Elront();
        if (par != null) {
            par.SetPar(null);
            par.RemoveSzomszed(this);
        }
        SkeletonController.FunctionReturn();

    }

    /**Ez a fuggveny felel azert, ha a teleportkapuba aszteroidaro hajo erkezik
     * Ha nem null a parja, akkor tovabb adja neki a hajot
     * @param h az erkezo hajo
     */
    @Override
    public void HajoErkezik(Hajo h) {
        SkeletonController.FunctionCall(new Object() {
        }.getClass().getEnclosingMethod().getName(), this);
        int res = SkeletonController.AskForInput("null a par?", new ArrayList<String>() {{
            add("igen");
            add("nem");
        }});

        switch (res) {
            case 0:
                System.out.println("kilepes");
                return;
            case 1:
                System.out.println("null a par");
                par = null;
                break;
            case 2:
                System.out.println("nem null a par");
                //itt elvileg az inicializalas soran mar beallitottunk part, szoval nincs teendo
                break;
            default:
                System.out.println("Rossz bemenet");
                break;
        }

        if (par != null) {
            par.HajoTeleportErkezik(h);
        }

        SkeletonController.FunctionReturn();
    }

    @Override
    public void HajoElhagy(Hajo h) {
        // TODO Auto-generated method stub

    }

    /**A teleportkapu megsemmisuleseert felel*/
    public void Megsemmisul() {
        SkeletonController.FunctionCall(new Object() {
        }.getClass().getEnclosingMethod().getName(), this);
        Elront();
        if (par != null) {
            par.SetPar(null);
            par.RemoveSzomszed(this);
        }
        SkeletonController.FunctionReturn();
    }
}
