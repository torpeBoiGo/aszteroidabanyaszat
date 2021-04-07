package Skeleton;

import java.util.ArrayList;
/**
 * 
 * A hajo mukodeset megvalosito osztaly, a Telepes es Robot ososztalya
 *
 */
abstract class Hajo implements Showable{

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
     * A hajo ezzel a fuggvennyel tud masik mezore lepni
     * @param uj_mezo - az uj mezo amire atmegy a hajo
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
        SkeletonController.FunctionCall(new Object() {
        }.getClass().getEnclosingMethod().getName(), this);
        SkeletonController.FunctionReturn();
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
    abstract boolean NyerEllenoriz(Epitheto e);
}