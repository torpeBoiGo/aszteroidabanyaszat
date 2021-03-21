package Skeleton;

import java.util.ArrayList;
/**
 * 
 * A hajo mukodeset megvalosito osztaly, a Telepes es Robot ososztalya
 *
 */
abstract class Hajo {

    /**
     * A Hajo ezen az aszteroidan tartozkodik.
     */
    protected Aszteroida aszteroida;	

    public void Fur() {
        SkeletonController.FunctionCall(new Object() {
        }.getClass().getEnclosingMethod().getName(), this);
        aszteroida.Fur();
        SkeletonController.FunctionReturn();
    }
    
    /**
     * A Hajo egy uj mezora mozog a jelenlegirol.
     * @param uj_mezo A mezo, ahova a Hajo mozog.
     */
    public void Mozog(Mezo uj_mezo) {
        SkeletonController.FunctionCall(new Object() {
        }.getClass().getEnclosingMethod().getName(), this);
        uj_mezo.HajoErkezik(this);

        SkeletonController.FunctionReturn();
    }

    /**
     * Hajot napvihar eri.
     */
    abstract public void Napvihar();

    /**
     * Hajo felrobban. Absztrakt.
     */
    abstract void Robbanas();

    abstract void Lepes();

    /**
     * Hajo megsemmisul.
     */
     abstract void Meghal();

    /**
     * Hajo tetlen.
     */
    public void Tetlen() {
        SkeletonController.FunctionCall(new Object() {
        }.getClass().getEnclosingMethod().getName(), this);
        SkeletonController.FunctionReturn();
    }

    /**
     * Az aszteroida erteket allitja be a kapottra.
     * @param m Az uj mazo
     */
    public void MezoBeallit(Mezo m) {
        SkeletonController.FunctionCall(new Object() {
        }.getClass().getEnclosingMethod().getName(), this);


        //ToDo
        //Ez ide nem kell, csak mint bemutat� k�dot tettem bele
        int res = SkeletonController.AskForInput("null az aszteroida?", new ArrayList<String>() {{
            add("igen");
            add("nem");
        }});
        //ToDo
        //Ez nem feltetlen kell
        //Lehet szebb lesz a kod �s a kimenet ha nem raktuk oda
        switch (res) {
            case 0:
                System.out.println("kilepes");
                return;
            case 1:
                System.out.println("null az aszteroida");
                break;
            case 2:
                System.out.println("nem null az aszteroida");
                break;
            default:
                System.out.println("Rossz bemenet");
                break;
        }


        if (aszteroida != null)
            aszteroida.HajoElhagy(this);
        aszteroida = (Aszteroida) m;

        SkeletonController.FunctionReturn();
    }

    abstract boolean NyerEllenoriz(Epitheto e);
}