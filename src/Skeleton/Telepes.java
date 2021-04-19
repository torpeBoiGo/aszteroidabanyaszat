package Skeleton;

import java.util.*;

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
        Palya.AddJatekosVezerli(this);
    }

    /**
     * A telepes konstruktora, a sajat aszteroida erteket nullra allitja.
     */
    public Telepes() {
        aszteroida = null;
        Palya.AddJatekosVezerli(this);
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
    	List<Szallithato> consumed = new ArrayList<>();
        for (Szallithato szallithato : nyersanyagRakter) {
        	if(e.KellE((Nyersanyag) szallithato)) { 
        		consumed.add(szallithato); 
        	}
        }

        boolean epitheto = e.EpithetoE();
        
        if(epitheto) {
        	e.Letrejon(aszteroida);
        	
        	for (Szallithato szallithato : consumed) {
				szallithato.Megsemmisul();
			}
        	nyersanyagRakter.removeAll(consumed);
        }
        //TODO ez kell?
        e.Reset();
    }

    /**
     * A teleportkapuk epiteset vegzo fuggveny.
     *
     * @param e A megfelelo epitheto objektum, amely a nyersanyagokat ellenorzi es tenylegesen letrehozza majd a teleportkapukat.
     */
    public void TeleportEpit(Epitheto e) {
    	List<Szallithato> consumed = new ArrayList<>();
        for (Szallithato szallithato : nyersanyagRakter) {
        	if(e.KellE((Nyersanyag) szallithato)) { 
        		consumed.add(szallithato); 
        	}
        }

        boolean epitheto = e.EpithetoE();
        
        if(epitheto && teleportkapuRakter.size() < 2) {
        	Vector<Szallithato> epitett;
        	epitett = e.Letrejon(aszteroida);
            teleportkapuRakter.addAll(epitett);
        	
        	for (Szallithato szallithato : consumed) {
				szallithato.Megsemmisul();
			}
        	nyersanyagRakter.removeAll(consumed);
        }
        //TODO ez kell?
        e.Reset();
    }

    /**
     * A telepes lerak egy teleportkaput
     */
    public void KapuLerak(Teleportkapu k) {
    	teleportkapuRakter.remove(k);
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
            Jatek.NamesMap.remove(Jatek.getKeyByValue(Jatek.NamesMap, szallithato));
        }
        for (Szallithato szallithato : temp_teleportkapuRakter) {
            szallithato.Megsemmisul();
            Jatek.NamesMap.remove(Jatek.getKeyByValue(Jatek.NamesMap, szallithato));
        }
        nyersanyagRakter = null;
        teleportkapuRakter = null;
        
        Palya.RemoveJatekosVezerli(this);
        Jatek.NamesMap.remove(Jatek.getKeyByValue(Jatek.NamesMap, this));
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

        Scanner sc = new Scanner(System.in);
        String telepes= Jatek.getKeyByValue(Jatek.NamesMap,this);
        System.out.println("Mit szeretne tenni a "+ telepes+" telepessel?");
        String line = sc.nextLine();
        String[] cmd = line.split(" ");
        if ("telepes".equals(cmd[0]) ||"hajo".equals(cmd[0])) {
            if ("robotEpit".equals(cmd[1])) {
                this.RobotEpit(new RobotEpito());
            } else if ("teleportEpit".equals(cmd[1])) {
                this.TeleportEpit(new TeleportEpito());
            } else if ("anyagVisszatesz".equals(cmd[1])) {
                Nyersanyag nyersanyag = (Nyersanyag) Jatek.NamesMap.get(cmd[3]);
                this.AnyagVisszatesz(nyersanyag);
            } else if ("fur".equals(cmd[1])) {
                this.Fur();
            } else if ("banyasz".equals(cmd[1])) {
                this.Banyasz();
            } else if ("kapuLerak".equals(cmd[1])) {
                this.KapuLerak((Teleportkapu) Jatek.NamesMap.get(cmd[2]));
            } else if ("mozog".equals(cmd[1])) {
                Mezo mezo = (Mezo) Jatek.NamesMap.get(cmd[3]);
                this.Mozog(mezo);
            } else if ("tetlen".equals(cmd[1])) {
                this.Tetlen();
            }else{
                System.out.println("Helytelen bemenet - "+telepes+" tetelen");
            }

    }else{
            System.out.println("Helytelen bemenet - "+telepes+" tetelen");
        }
        sc.close();
    }

    /**
     * Ellenorzi a hajo mivel jarulhat hozza a gyozelemhez
     *
     * @param e -amit vizsgalunk
     */
    @Override
    void NyerEllenoriz(Epitheto e) {
        for (Szallithato ny :nyersanyagRakter){
            e.KellE((Nyersanyag) ny);
        }
    }


    /**
     * Elhelyezi az aszteroida magj�ban a param�terk�nt kapott nyersanyagot, ha az aszteroida teljesen �t van f�rva �s �reges
     *
     * @param n - a nyersanyag ami visszateszunk
     */
    void AnyagVisszatesz(Nyersanyag n) {
    	boolean sikerult = aszteroida.AddMag(n);
    	if (sikerult) nyersanyagRakter.remove(n);
    }

    /**
     * A nyersanyagrakterhez hozzaadjuk az adott szallithatot
     *
     * @param n - az elem amit hozzaadunk
     */
    void addNyersanyagRakter(Szallithato n) {
        nyersanyagRakter.add(n);
    }

    /**
     * Banyassszuk az aszteroidat amin a telepes van
     */
    void Banyasz() {
        Nyersanyag n = aszteroida.Kinyer();
        if(nyersanyagRakter.size()>9)
            return;
        if(n!=null)
        addNyersanyagRakter(n);
    }

    //TODO
    public String toString() {
        System.out.println("Aszteroida: " + Jatek.getKeyByValue(Jatek.NamesMap, aszteroida) + ": Aszteroida");
        System.out.print("NyersanyagRakter: ");
        StringJoiner lineJoiner = new StringJoiner(",");
        for (Szallithato szallithato : nyersanyagRakter) {
            lineJoiner.add(Jatek.getKeyByValue(Jatek.NamesMap, szallithato) + ": " + szallithato.getClass().getSimpleName());
        }
        System.out.println(lineJoiner + ": Nyersanyag[0..10]");
        lineJoiner = new StringJoiner(",");
        System.out.print("TeleportkapuRakter: ");
        for (Szallithato tpkapu : teleportkapuRakter) {
            lineJoiner.add(Jatek.getKeyByValue(Jatek.NamesMap, tpkapu) + ": " + tpkapu.getClass().getSimpleName());
        }
        return lineJoiner + ": Teleportkapu[0..3]\n";
    }

}