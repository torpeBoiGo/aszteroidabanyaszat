package Skeleton;



import java.util.List;
import java.util.Random;

/**
 * A robot mukodeset megvalosito osztaly.
 */
public class Robot extends Hajo implements Leptetheto {
    /**
     * Robot konstruktora, ha a keletkezese pillanatatol aszteroidan tartozkodik
     *
     * @param a Aszteroida, amin tartozkodik
     */
    public Robot(Aszteroida a) {
        a.HajoErkezik(this);
        aszteroida = a;
        Palya.AddAiVezerli(this);
    }

    /**
     * Az aszteroidan valo furast hajtja vegre
     */
    public void Fur() {
        aszteroida.Fur();
    }
    
    /**
     * Robotot napvihar eri.
     */
    @Override
    public void Napvihar() {
        this.Meghal();
    }

    /**
     * Robot meghal.
     */
    @Override
    public void Meghal() {
        aszteroida.HajoElhagy(this);
        Palya.removeAIVezerli(this);
        Jatek.NamesMap.remove(Jatek.getKeyByValue(Jatek.NamesMap, this));
    }

    /**
     * Robot felrobban.
     */
    @Override
    public void Robbanas() {
    	List<Mezo> szomsz = aszteroida.getSzomszedok();
    	if(szomsz.isEmpty()) Meghal();
    	else {
    		Random rand = new Random();
    		Mozog(szomsz.get(rand.nextInt(szomsz.size())));
    	}
    }

    /**
     * A robot lep egyet, itt lesz mevalositva a viselkedese
     */
    @Override
	public void Lepes() {
    	List<Mezo> szomszedok = aszteroida.getSzomszedok();
    	
    	if (aszteroida.GetKulsoRetegek() > 0) { //nincs atfurva
    		Fur();
    	}
    	if ((aszteroida.GetKulsoRetegek() == 0) && (szomszedok.size() > 0)) { //at van furva, VAN szomszedos mezo
    		Random rand = new Random();
    		int rand_aszt = rand.nextInt(szomszedok.size());
    		Mozog(szomszedok.get(rand_aszt));
    	} 
    	if ((aszteroida.GetKulsoRetegek() == 0) && (szomszedok.size() == 0)) { //at van furva, de NINCS szomszedos mezo
    		Tetlen();
    	}
    }

    /**
     * Ellenorzi a robot mivel jarulhat hozza a gyozelemhez
     */
    @Override
    void NyerEllenoriz(Epitheto e) {
        // TODO Auto-generated method stub

    }

    @Override
    public String toString() {
        return "Aszteroida: " + Jatek.getKeyByValue(Jatek.NamesMap, aszteroida) + ": Aszteroida\n";
    }
}
