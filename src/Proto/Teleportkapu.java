package Skeleton;

import java.util.ArrayList;

/**
 * A jatekban szereplo teleportkapu
 */
public class Teleportkapu implements Mezo, Szallithato{
    /**
     * A kapu par masik tagja
     */
    Teleportkapu par;

    /**
     * Az aszteroida, ami kurol kering a kapu
     */
    Aszteroida sajatAszteroida;

    /**
     * Azt mutatja meg, hogy uzemkepes-e a kapu
     */
    boolean mukodikE;
    
    //TODO 
    boolean megkergulE;

    /**
     * A teleportkapu konstruktora, a par, sajatAszteroida es mukodikE ertekeket null-ra allitja.
     */
    public Teleportkapu() {
        par = null;
        sajatAszteroida = null;
        mukodikE = true;
        megkergulE = false;
    }


    public Teleportkapu(Aszteroida a, boolean mukodik) {
        sajatAszteroida = a;
        mukodikE = mukodik;
    }

    /**
     * Beallitja a par erteket a kapott teleportkapura.
     *
     * @param p A teleortkapu, ami ezutan ennek a kpaunak a parja lesz.
     */
    public void SetPar(Teleportkapu p) {
        par = p;
    }

    /**
     * Beallitja a sajatAszteroida erteket a kapott aszteroidara.
     *
     * @param a Az aszteroida, ami korul a teleportkapu kering a jatekban.
     */
    public void SetSajatAszteroida(Aszteroida a) {
        if (mukodikE) {
        	 this.sajatAszteroida = a;
        	 sajatAszteroida.AddSzomszed(this);
        } else {
        	Megsemmisul();
        }
    }

    /**
     * A teleprotkapuba egy Hajo (telepes vagy robot) erkezik a kapu parjatol, amely ezutan tovabbhalad a kapu aszteriodajara, ha az letezik.
     *
     * @param h Az erkezo Hajo
     */
    public void HajoTeleportErkezik(Hajo h) {
        if (sajatAszteroida != null) {
            sajatAszteroida.HajoErkezik(h);
            
        }
    }

    /**
     * A teleportkapu mukodeskeptelenne valik
     */
    public void Elront() {
        mukodikE = false;
    }

    @Override
    public void Robban() {
        // TODO Auto-generated method stub

    }

    /**
     * Ez a fuggveny felel, azert, ha az teleportkapuval szomszedos mezo felrobban
     * Ekkor a teleportkapu es a parja is felrobban
     *
     * @param m a felrobbant mezo
     */
    @Override
    public void RemoveSzomszed(Mezo m) {
        if (sajatAszteroida != null) sajatAszteroida.RemoveSzomszed(this);
        Elront();
        if (par != null) {
            par.SetPar(null);
            par.RemoveSzomszed(this);
        }
    }

    /**
     * A teleprotkapuba egy Hajo (telepes vagy robot) erkezik, amely ezutan tovabbhalad a kapu parjaba, ha az letezik.
     *
     * @param h Az erkezo Hajo
     */
    @Override
    public void HajoErkezik(Hajo h) {
        if (par != null) {
            par.HajoTeleportErkezik(h);
        }
    }

    /**
     * Hajo elhagyja a teleportkaput, nem hivjuk
     */
    @Override
    public void HajoElhagy(Hajo h) {
        // TODO Auto-generated method stub

    }

    /**
     * A teleportkapu megsemmisuleseert felel
     */
    public void Megsemmisul() {
        Elront();
        if (par != null) {
            par.SetPar(null);
            par.RemoveSzomszed(this);
        }
    }

    @Override
    public String toString() {
        System.out.println("MukodikE: " + mukodikE);
        System.out.println("MegkergulE: " + megkergulE);
        System.out.println("Par: " + Main.getKeyByValue(Main.NamesMap, par) +": " + par.getClass().getSimpleName());
        System.out.println("SajatAszteroida: " + Main.getKeyByValue(Main.NamesMap, sajatAszteroida)+": " + sajatAszteroida.getClass().getSimpleName());
        return super.toString();
    }
}
