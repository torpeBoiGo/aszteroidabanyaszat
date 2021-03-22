package Skeleton;

import java.util.ArrayList;

/**
 * A jatekban szereplo nyersanyagok ososztalya
 */
public abstract class Nyersanyag implements Szallithato {
    /**
     * Konstruktor
     */
    public Nyersanyag() {
        SkeletonController.ObjectCreated(this);
    }

    /**
     * A nyersanyag megsemmisulesert felel
     */
    public void Megsemmisul() {
        SkeletonController.FunctionCall(new Object() {
        }.getClass().getEnclosingMethod().getName(), this);
        SkeletonController.FunctionReturn();
    }

    /**
     * A fuggveny, akkor hivodik meg,
     * mikor a nyersanyagrol lekerul az utolso kulsoreteg is,
     * valamint az aszteroidaja napkozelben  van
     *
     * @param a Az aszteroida, amin a nyersanyag van
     */
    public void Megfurva(Aszteroida a) {
        SkeletonController.FunctionCall(new Object() {
        }.getClass().getEnclosingMethod().getName(), this);
        SkeletonController.FunctionReturn();
    }

    /**
     * A  fuggveny  megvizsgalja, hogy a parameterkent kapott nyersanyag
     * azonos vagy kompatibilis-e a nyersanyaggal
     *
     * @param ny Az osszehasonlitando nyersanyag
     * @return igaz, ha a ket nyersanyag azonos tipusu, egyebkent hamis
     */
    public boolean KompatibilisE(Nyersanyag ny) {
        SkeletonController.FunctionCall(new Object() {
        }.getClass().getEnclosingMethod().getName(), this);
        SkeletonController.FunctionReturn();
        
        int res = SkeletonController.AskForInput("Kompatibilis a nyersanyag?", new ArrayList<String>() {{
            add("igen");
            add("nem");
        }});
        switch(res) {
            case 0:
                System.out.println("kilepes");
                return false;
            case 1:
                System.out.println("kompatibilis");
                return true;
            case 2:
                System.out.println("nem kompatibilis");
                return false;
            default:
                System.out.println("Rossz bemenet");
                break;
        }
        
        return false;
    }
}
