package Skeleton;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.StringJoiner;

public class Ufo extends Hajo{

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
    }
	
    /**
     * A telepes konstruktora, a sajat aszteroida erteket nullra allitja. 
     */
    public Ufo() {
        aszteroida = null;
    }
    
    /**
     * A telepes nyersanyagRakter listjehez ad hozza egy uj elemet.
     * @param n
     */
    public void AddNyersanyagRakter(Nyersanyag n) {
    	nyersanyagRakter.add(n);
    }
    
    /**
     * Banyassszuk az aszteroidat amin az UFO van
     */
    void Banyasz() {
        Nyersanyag n = aszteroida.Kinyer();
        
        if(n != null) {
	        AddNyersanyagRakter(n);
	    }
    }
    
	@Override
	public String toString() {
		System.out.println("Aszteroida: " + Main.getKeyByValue(Main.NamesMap, aszteroida) + ": Aszteroida");
    	System.out.print("NyersanyagRakter: ");
    	StringJoiner lineJoiner = new StringJoiner(",");
    	for (Szallithato szallithato : nyersanyagRakter) {
    		lineJoiner.add(Main.getKeyByValue(Main.NamesMap, szallithato)+": " + szallithato.getClass().getSimpleName());
		}
    	System.out.println(lineJoiner.toString() + ": Nyersanyag[0..*]");		
    	return "TODO";
	}

	@Override
	public void Napvihar() {
		// TODO Auto-generated method stub
		
	}

	@Override
	void Robbanas() {
		// TODO Auto-generated method stub
		
	}

	@Override
	void Lepes() {
		List<Mezo> szomszedok = aszteroida.getSzomszedok();
    	
    	if ((aszteroida.GetKulsoRetegek() > 0) && (szomszedok.size() > 0)) { //nincs atfurva, van szonszed
    		Random rand = new Random();
    		int rand_aszt = rand.nextInt(szomszedok.size());
    		Mozog(szomszedok.get(rand_aszt));
    	}
    	if ((aszteroida.GetKulsoRetegek() == 0) && (aszteroida.UregesE() == true) && (szomszedok.size() > 0)) { //at van furva, ureges, van szomszed
    		Random rand = new Random();
    		int rand_aszt = rand.nextInt(szomszedok.size());
    		Mozog(szomszedok.get(rand_aszt));
    	} 
    	if ((aszteroida.GetKulsoRetegek() > 0) && (szomszedok.size() == 0)) { //nincs atfurva, NINCS szomszed
    		Tetlen();
    	}
    	if ((aszteroida.GetKulsoRetegek() == 0) && (aszteroida.UregesE() == true) && (szomszedok.size() == 0)) { //atfurva, ureges, NINCS szomszed
    		Tetlen();
    	}
    	if ((aszteroida.GetKulsoRetegek() == 0) && (aszteroida.UregesE() == false)) { //atfurva, nem ureges
    		Banyasz();
    	}
	}

	@Override
	void Meghal() {
		// TODO Auto-generated method stub
		
	}

	@Override
	boolean NyerEllenoriz(Epitheto e) {
		// TODO Auto-generated method stub
		return false;
	}

}
