package Grafikus;



import java.util.List;
import java.util.Random;

/**
 * A robot mukodeset megvalosito osztaly.
 */
public class Robot extends Hajo implements Leptetheto {
    /**
     * Robot konstruktora, ha a keletkezese pillanatatol aszteroidan tartozkodik
     * Elhelyezi a robotot a parameterkent kapott aszteroidan, beallitja a robot aszteroidajat a parameterkent kapottra,    
     * valamint hozzaadja a palyan tarolt  aiVezerli objektumokhoz.
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
     * A robot viselkedeset irja le, ha a robotot napvihar eri Ekkor a robot meghal.
     */
    @Override
    public void Napvihar() {
        this.Meghal();
    }

    /**
     * A robot viselkedeset irja le, ha meghal. Eltavolitja a robotot az aszteroidajarol,
     * a palyan tarolt aiVezerli objektumok kozul, valamint a kiirashoz hasznalt hashmaprol.
     */
    @Override
    public void Meghal() {
        aszteroida.HajoElhagy(this);
        Palya.removeAIVezerli(this);
        MainGUI.NamesMap.remove(MainGUI.getKeyByValue(MainGUI.NamesMap, this));
    }

    /**
     * A  robot  viselkedeset irja le, ha felrobban. Ekkor a robot egy random szomszedos mezore mozog,  
     * vagy, ha az aszteroidanak nincs szomszedja, akkor meghal
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
     *A robot lepeset irja le. Ha az aszteroida,  amin  tartozkodik  nincs teljesen afurva, akkor a robot a korben fur, egyebkent, 
     *ha van szomszedos mezoje az aszteroidanak, akkor egy random szomszedos mezore mozog. 
     *Ha nincs szomszedja az aszteroidanak es nem tud furni se, akkor a robot tetlen marad
     */
    @Override
	public void Lepes() {
    	List<Mezo> szomszedok = aszteroida.getSzomszedok();

    	if (aszteroida.GetKulsoRetegek() > 0) { //nincs atfurva
    		Fur();
    	}
    	else if ((aszteroida.GetKulsoRetegek() == 0) && (szomszedok.size() > 0)) { //at van furva, VAN szomszedos mezo
    		Random rand = new Random();
    		int rand_aszt = rand.nextInt(szomszedok.size());
    		Mozog(szomszedok.get(rand_aszt));
    	} 
    	else if ((aszteroida.GetKulsoRetegek() == 0) && (szomszedok.size() == 0)) { //at van furva, de NINCS szomszedos mezo
    		Tetlen();
    	}
    }

    /**
     * Ellenorzi a robot mivel jarulhat hozza a gyozelemhez
     */
    @Override
    void NyerEllenoriz(Epitheto e) {

    }
    
    /**
     * Visszater a robot tulajdonsagait (az aszteroidaja) tartalmazo stringgel a kimeneti nyelvnek megfelelo formatumban.
     */
    @Override
    public String toString() {
        return "Aszteroida: " + MainGUI.getKeyByValue(MainGUI.NamesMap, aszteroida) + ": Aszteroida\n";
    }
}
