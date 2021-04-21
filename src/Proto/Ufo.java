package Proto;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.StringJoiner;

/**
 * Az ufo mukodeset megvalosito osztaly
 *
 */
public class Ufo extends Hajo implements Leptetheto{

    /**
     * Az Ufo nyersanyagok tarolasara szolgalo raktere. Akarmennyi nyersanyagot tartalmazhat.
     */
    private List<Szallithato> nyersanyagRakter = new ArrayList<>();

    /**
     * Konstruktor, az Ufo keletekezesekor hivodik. Elhelyezi az ufot a  parameterkent  kapott  aszteroidan,  
     * beallitja az ufo aszteroidajat a parameterkent kapottra, valamint hozzaadja a palyan tarolt Aivezerelelt objektumokhoz
     *
     * @param a Aszteroida, amin tartozkodik
     */
    public Ufo(Aszteroida a) {
        a.HajoErkezik(this);
        aszteroida = a;
        Palya.AddAiVezerli(this);
    }

    /**
     * Konstruktor,  az  ufo aszteroidajat  nullra  allitja,  valamint  hozzaadja  a  palyan tarolt Ai vezerelelt objektumokhoz
     */
    public Ufo() {
        aszteroida = null;
        Palya.AddAiVezerli(this);
    }

    /**
     * A telepes nyersanyagRakter listjehez ad hozza egy uj elemet.
     *
     * @param n a hozzaadando nyersanyag
     */
    public void AddNyersanyagRakter(Nyersanyag n) {
        nyersanyagRakter.add(n);
    }

    /**
     * Kinyeri az aszteroida magjaat es elhelyezi a raktereben.
     */
    void Banyasz() {
        Nyersanyag n = aszteroida.Kinyer();

        if (n != null) {
            AddNyersanyagRakter(n);
        }
    }

    /**
     * Visszater   az   ufo tulajdonsagait (az   aszteroidaja, raktere) tartalmaza stringgel a kimeneti nyelvnek megfelelo formatumban.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Aszteroida: ").append(Jatek.getKeyByValue(Jatek.NamesMap, aszteroida)).append(": Aszteroida\n");
        sb.append("NyersanyagRakter:");
        StringJoiner lineJoiner = new StringJoiner(",");
        for (Szallithato szallithato : nyersanyagRakter) {
            lineJoiner.add(Jatek.getKeyByValue(Jatek.NamesMap, szallithato) + ": " + szallithato.getClass().getSimpleName());
        }
        sb.append(lineJoiner).append(": Nyersanyag[0..*]\n");
        return sb.toString();
    }

    /**
     * Az  ufo viselked�s�t  �rja  le,  ha  a  telepest  napvihar  �ri.  Ekkor  az ufo meghal.
     */
    @Override
    public void Napvihar() {
        Meghal();
    }
    
    /**
     * Az ufo viselkedeset irja le, ha felrobban. Ekkor az ufo meghal.
     */
	@Override
	public void Robbanas() {
		Meghal();
	}

	/**
	 * Az  ufo viselkedeset  erja  le,  ha  meghal. 
	 * Eltevol�tja  az  ufot az aszteroidajarol,  a  palyan  tarolt Ai vezerelelt  objektumok  kozul,  valamint  a  kiirashoz hasznalt hasmaprol.
	 */
	@Override
	void Meghal() {
		aszteroida.HajoElhagy(this);
        Palya.removeAIVezerli(this);
        for (Szallithato szallithato : nyersanyagRakter) {
			szallithato.Megsemmisul();
		}
        Jatek.NamesMap.remove(Jatek.getKeyByValue(Jatek.NamesMap, this));
	}
    
	/**
	 * Az   ufo lepeset   irja   le. Ha   az   aszteroida,   amin   tartozkodik banynaszhato (teljesen  at  van  furva,  nem ureges),  
	 * akkor  az  ufo  a  korben  banyaszik, egyebkent,  ha  van  szomszedos  mezoje  az  aszteroidanak,  
	 * akkor  egy  random szomszedos  mezore mozog.  Ha  nincs  szomszedja  az  aszteroidanak  �s  nem  tud banyaszni se, akkor az ufo tetlen marad.
	 */
    @Override
	public void Lepes() {
        List<Mezo> szomszedok = aszteroida.getSzomszedok();

        if ((aszteroida.GetKulsoRetegek() > 0) && (szomszedok.size() > 0)) { //nincs atfurva, van szonszed
            Random rand = new Random();
            int rand_aszt = rand.nextInt(szomszedok.size());
            Mozog(szomszedok.get(rand_aszt));
        }
        else if ((aszteroida.GetKulsoRetegek() == 0) && (aszteroida.UregesE()) && (szomszedok.size() > 0)) { //at van furva, ureges, van szomszed
            Random rand = new Random();
            int rand_aszt = rand.nextInt(szomszedok.size());
            Mozog(szomszedok.get(rand_aszt));
        }
        else if ((aszteroida.GetKulsoRetegek() > 0) && (szomszedok.size() == 0)) { //nincs atfurva, NINCS szomszed
            Tetlen();
        }
        else if ((aszteroida.GetKulsoRetegek() == 0) && (aszteroida.UregesE()) && (szomszedok.size() == 0)) { //atfurva, ureges, NINCS szomszed
            Tetlen();
        }
        else if ((aszteroida.GetKulsoRetegek() == 0) && (!aszteroida.UregesE())) { //atfurva, nem ureges
            Banyasz();
        }
    }

   /**
    * Ellenorzi az ufo mivel jarulhat hozza a gyozelemhez
    */
    @Override
    void NyerEllenoriz(Epitheto e) {

    }

}
