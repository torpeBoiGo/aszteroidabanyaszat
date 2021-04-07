package Skeleton;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

/**
 * A telepest megvalosito osztaly.
 */
public class Telepes extends Hajo implements Leptetheto {

    /**
     * a nyersanyagokat tarolo Rakter
     */
    private List<Szallithato> nyersanyagRakter = new ArrayList<>();

    /**
     * a teleportkapukat tarolo Rakter
     */
    private List<Szallithato> teleportkapuRakter = new ArrayList<>();

    /**
     * A telepes konstruktora, amely beallitja a sajat aszteroidajat, es hozzaadja a parameterul kapott aszteroidan tartozkodo hajokhoz a telepest.
     *
     * @param a Az az aszteroida, ahova a telepes letrejottenek pillanataban kerul.
     */
    public Telepes(Aszteroida a) {
        a.HajoErkezik(this);
        aszteroida = a;
    }

    /**
     * A telepes konstruktora, a sajat aszteroida erteket nullra allitja.
     */
    public Telepes() {
        aszteroida = null;
    }

    /**
     * az aszteroidan valo furast hajtja vegre
     */
    public void Fur() {
        aszteroida.Fur();
    }

    /**
     * A telepes nyersanyagRakter listjehez ad hozza egy uj elemet.
     *
     * @param n a nyersanyag
     */
    public void SetNyersanyagRakter(Nyersanyag n) {
        nyersanyagRakter.add(n);
    }

    /**
     * A telepes teleportkapuRakter listjehez ad hozza egy uj elemet.
     *
     * @param t a teleportkapu
     */
    public void SetTeleportkapuRakter(Teleportkapu t) {
        teleportkapuRakter.add(t);
    }

    /**
     * A Robot epiteset vegzo fuggveny.
     *
     * @param e A megfelelo epitheto objektum, amely a nyersanyagokat ellenorzi es tenylegesen letrehozza majd a robotot.
     */
    public void RobotEpit(Epitheto e) {
        for (Szallithato szallithato : nyersanyagRakter) {
            e.KellE((Nyersanyag) szallithato);
        }
        boolean epitheto = e.EpithetoE();
    }

    /**
     * A teleportkapuk epiteset vegzo fuggveny.
     *
     * @param e A megfelelo epitheto objektum, amely a nyersanyagokat ellenorzi es tenylegesen letrehozza majd a teleportkapukat.
     */
    public void TeleportEpit(Epitheto e) {
        for (Szallithato szallithato : nyersanyagRakter) {
            e.KellE((Nyersanyag) szallithato);
        }

        boolean epitheto = e.EpithetoE();
    }

    /**
     * A telepes lerak egy teleportkaput
     */
    public void KapuLerak(Teleportkapu k) {
        k.SetSajatAszteroida(aszteroida);
    }

    /**
     * Telepest napvihar eri.
     */
    @Override
    public void Napvihar() {
        this.Meghal();
    }

    /**
     * Telepes meghal.
     */
    @Override
    public void Meghal() {
        aszteroida.HajoElhagy(this);
        Palya.removeAIVezerli(this);
        List<Szallithato> temp_nyersanyagRakter = new ArrayList<>(nyersanyagRakter);
        List<Szallithato> temp_teleportkapuRakter = new ArrayList<>(teleportkapuRakter);

        for (Szallithato szallithato : temp_nyersanyagRakter) {
            szallithato.Megsemmisul();
            Main.NamesMap.remove(Main.getKeyByValue(Main.NamesMap, szallithato));
        }
        for (Szallithato szallithato : temp_teleportkapuRakter) {
            szallithato.Megsemmisul();
            Main.NamesMap.remove(Main.getKeyByValue(Main.NamesMap, szallithato));
        }
        nyersanyagRakter = null;
        teleportkapuRakter = null;
    }

    /**
     * A telepes felrobban.
     */
    @Override
    public void Robbanas() {
        Meghal();
    }


    /**
     * A telepes lep egyet
     */
    @Override
    public void Lepes() {
        // TODO Auto-generated method stub
    }

    /**
     * Ellenorzi a hajo mivel jarulhat hozza a gyozelemhez
     *
     * @param e -amit vizsgalunk
     */
    @Override
    boolean NyerEllenoriz(Epitheto e) {
        // TODO Auto-generated method stub
        return false;
    }


    /**
     * Ellenorzi a hajo mivel jarulhat hozza a gyozelemhez
     *
     * @param n - a nyersanyag ami visszateszunk
     */
    void AnyagVisszatesz(Nyersanyag n) {
        aszteroida.AddMag(n);
    }

    /**
     * A nyersanyagrakterhez hozzaadjuk az adott szallithatot
     *
     * @param n - az elem amit hozzaadunk
     */
    void AddRakter(Szallithato n) {
        nyersanyagRakter.add(n);
    }

    /**
     * Banyassszuk az aszteroidat amin a telepes van
     */
    void Banyasz() {
        Nyersanyag n = aszteroida.Kinyer();
    }

    //TODO
    public String toString() {
        System.out.println("Aszteroida: " + Main.getKeyByValue(Main.NamesMap, aszteroida) + ": Aszteroida");
        System.out.print("NyersanyagRakter: ");
        StringJoiner lineJoiner = new StringJoiner(",");
        for (Szallithato szallithato : nyersanyagRakter) {
            lineJoiner.add(Main.getKeyByValue(Main.NamesMap, szallithato) + ": " + szallithato.getClass().getSimpleName());
        }
        System.out.println(lineJoiner + ": Nyersanyag[0..10]");
        lineJoiner = new StringJoiner(",");
        System.out.print("TeleportkapuRakter: ");
        for (Szallithato tpkapu : teleportkapuRakter) {
            lineJoiner.add(Main.getKeyByValue(Main.NamesMap, tpkapu) + ": " + tpkapu.getClass().getSimpleName());
        }
        return lineJoiner + ": Teleportkapu[0..3]\n";
    }

}