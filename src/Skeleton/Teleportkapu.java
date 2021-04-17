package Skeleton;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * A jatekban szereplo teleportkapu
 */
public class Teleportkapu implements Mezo, Szallithato, Leptetheto {
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
    boolean mukodikE = true;

    //TODO 
    boolean megkergultE;

    /**
     * A teleportkapu konstruktora, a par, sajatAszteroida es mukodikE ertekeket null-ra allitja.
     */
    public Teleportkapu() {
        par = null;
        sajatAszteroida = null;
        megkergultE = false;
        Palya.AddTeleportkapu(this);
    }


    /**
     * Teleport kapu konstruktora, meglevo aszteroidara, es mukodes beallitasaval.
     *
     * @param a       A meglevo aszteroida, amihez a kapu tartozik
     * @param SetMegkergultE A megkergultseg beallitasa igen/nem.
     */
    public Teleportkapu(Aszteroida a, boolean SetMegkergultE) {
        sajatAszteroida = a;
        a.AddSzomszed(this);
        //TODO eldoneni hogy igy van-e, a spec-ben nem ezt allitjuk
        megkergultE = SetMegkergultE;
        Palya.AddTeleportkapu(this);
    }

    /**
     * Teleport kapu konstruktora, a kapuhoz tartozo aszteroida null, es mukodes beallitasaval.
     *
     * @param SetMegkergultE A megkergultseg beallitasa igen/nem.
     */
    public Teleportkapu(boolean SetMegkergultE) {
        sajatAszteroida = null;
      //TODO eldoneni hogy igy van-e, a spec-ben nem ezt allitjuk
        megkergultE = SetMegkergultE;
        Palya.AddTeleportkapu(this);
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
        Palya.RemoveTeleportkapu(this);
        Jatek.NamesMap.remove(Jatek.getKeyByValue(Jatek.NamesMap, this));
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
        
        Palya.RemoveTeleportkapu(this);
        Jatek.NamesMap.remove(Jatek.getKeyByValue(Jatek.NamesMap, this));
    }

    @Override
    public String toString() {
        String out = "";
        out += "MukodikE: " + mukodikE + ": bool\n";
        out += "MegkergulE: " + megkergultE + ": bool\n";
        if(par==null){
            //TODO ez így jó?
            //TODO a lent lévő kapu megdöglik-e?
            out += "Par: " + null +"\n";
        }else{
            out += "Par: " + Jatek.getKeyByValue(Jatek.NamesMap, par) + ": " + par.getClass().getSimpleName() + "\n";
        }
        if(sajatAszteroida==null){
            //TODO ez így jó?
            out += "SajatAszteroida: " + null +"\n";
        }else{
            out += "SajatAszteroida: " + Jatek.getKeyByValue(Jatek.NamesMap, sajatAszteroida) + ": " + sajatAszteroida.getClass().getSimpleName() + "\n";
        }
        return out;
    }


	@Override
	public void Lepes() {
		if (megkergultE) {
			List<Mezo> szomsz = sajatAszteroida.getSzomszedok();
			List<Mezo> szomsz_aszt = new ArrayList<>();
			//TODO itt nem csak az szteroidákat kéne kiszedni? mezo-re sír az IDEA
            for (Mezo mezo : szomsz) {
                if (Palya.aszteroidak.contains(mezo)) {
                    szomsz_aszt.add(mezo);
                }
            }
	    	if(!szomsz_aszt.isEmpty()) {
	    		Random rand = new Random();
	    		this.SetSajatAszteroida((Aszteroida)szomsz_aszt.get(rand.nextInt(szomsz_aszt.size())));
	    	}
		}
		
	}


	@Override
	public void Napvihar() {
		this.megkergultE = false;
	}
}
