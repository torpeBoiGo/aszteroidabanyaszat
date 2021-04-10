package Skeleton;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.StringJoiner;

public class Ufo extends Hajo implements Leptetheto{

    /**
     * a nyersanyagokat tarolo Rakter
     */
    private List<Szallithato> nyersanyagRakter = new ArrayList<>();

    /**
     * UFO konstruktora, ha a keletkezese pillanatatol aszteroidan tartozkodik
     *
     * @param a Aszteroida, amin tartozkodik
     */
    public Ufo(Aszteroida a) {
        a.HajoErkezik(this);
        aszteroida = a;
        Palya.AddAiVezerli(this);
    }

    /**
     * A telepes konstruktora, a sajat aszteroida erteket nullra allitja.
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
     * Banyassszuk az aszteroidat amin az UFO van
     */
    void Banyasz() {
        Nyersanyag n = aszteroida.Kinyer();

        if (n != null) {
            AddNyersanyagRakter(n);
        }
    }


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

    @Override
    public void Napvihar() {
        // TODO Auto-generated method stub
    }
	@Override
	public void Robbanas() {
		Meghal();
	}

	@Override
	void Meghal() {
		aszteroida.HajoElhagy(this);
        Palya.removeAIVezerli(this);
        Jatek.NamesMap.remove(Jatek.getKeyByValue(Jatek.NamesMap, this));
	}

    

    @Override
	public void Lepes() {
        List<Mezo> szomszedok = aszteroida.getSzomszedok();

        if ((aszteroida.GetKulsoRetegek() > 0) && (szomszedok.size() > 0)) { //nincs atfurva, van szonszed
            Random rand = new Random();
            int rand_aszt = rand.nextInt(szomszedok.size());
            Mozog(szomszedok.get(rand_aszt));
        }
        if ((aszteroida.GetKulsoRetegek() == 0) && (aszteroida.UregesE()) && (szomszedok.size() > 0)) { //at van furva, ureges, van szomszed
            Random rand = new Random();
            int rand_aszt = rand.nextInt(szomszedok.size());
            Mozog(szomszedok.get(rand_aszt));
        }
        if ((aszteroida.GetKulsoRetegek() > 0) && (szomszedok.size() == 0)) { //nincs atfurva, NINCS szomszed
            Tetlen();
        }
        if ((aszteroida.GetKulsoRetegek() == 0) && (aszteroida.UregesE()) && (szomszedok.size() == 0)) { //atfurva, ureges, NINCS szomszed
            Tetlen();
        }
        if ((aszteroida.GetKulsoRetegek() == 0) && (!aszteroida.UregesE())) { //atfurva, nem ureges
            Banyasz();
        }
    }

   
    @Override
    void NyerEllenoriz(Epitheto e) {
        // TODO Auto-generated method stub
    }

}
