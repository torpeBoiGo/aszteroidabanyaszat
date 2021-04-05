package Skeleton;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

import javax.sound.midi.SysexMessage;

/**
 * A telepest megvalosito osztaly.
 * 
 *
 */
public class Telepes extends Hajo {

	/**
	 * a nyersanyagokat tarolo Rakter
	 */
    private List<Szallithato> nyersanyagRakter = new ArrayList<>(); 
    
    /**
     *  a teleportkapukat tarolo Rakter
     */
    private List<Szallithato> teleportkapuRakter = new ArrayList<>();	
    
    /**
     * A telepes nyersanyagRakter listjehez ad hozza egy uj elemet.
     * @param n
     */
    public void SetNyersanyagRakter(Nyersanyag n) {
    	SkeletonController.FunctionCall(new Object() {
        }.getClass().getEnclosingMethod().getName(), this);
    	nyersanyagRakter.add(n);
        SkeletonController.FunctionReturn();

    }
    
    /**
     * A telepes teleportkapuRakter listjehez ad hozza egy uj elemet.
     * @param t
     */
    public void SetTeleportkapuRakter(Teleportkapu t) {
    	SkeletonController.FunctionCall(new Object() {
        }.getClass().getEnclosingMethod().getName(), this);
    	teleportkapuRakter.add(t);
    	SkeletonController.FunctionReturn();
    }

    /**
     * A telepes konstruktora, amely beallitja a sajat aszteroidajat, es hozzaadja a parameterul kapott aszteroidan tartozkodo hajokhoz a telepest. 
     * @param a Az az aszteroida, ahova a telepes letrejottenek pillanataban kerul.
     */
    public Telepes(Aszteroida a) {

        SkeletonController.ObjectCreated(this);
        a.HajoErkezik(this);
        aszteroida = a;

    }
    
    /**
     * A telepes konstruktora, a sajat aszteroida erteket nullra allitja. 
     */
    public Telepes() {
        SkeletonController.ObjectCreated(this);
        aszteroida = null;
    }

    /**
     * A Robot epiteset vegzo fuggveny.
     * @param e A megfelelo epitheto objektum, amely a nyersanyagokat ellenorzi es tenylegesen letrehozza majd a robotot.
     */
    public void RobotEpit(Epitheto e) {
        SkeletonController.FunctionCall(new Object() {
        }.getClass().getEnclosingMethod().getName(), this);
        for (int i = 0; i < nyersanyagRakter.size(); i++) {
            e.KellE((Nyersanyag) nyersanyagRakter.get(i));
        }
        boolean epitheto = e.EpithetoE();

        int res1 = SkeletonController.AskForInput("epitheto?", new ArrayList<String>() {{
            add("igen");
            add("nem");
        }});
        switch (res1) {
            case 0:
                System.out.println("kilepes");
                return;
            case 1:
                System.out.println("epitheto");
                break;
            case 2:
                System.out.println("nem epitheto");
                break;
            default:
                System.out.println("Rossz bemenet");
                break;
        }
        if (res1 == 1) {        // epitheto
            e.Letrejon(aszteroida);
        }
        SkeletonController.FunctionReturn();
    }

    /**
     * A teleportkapuk epiteset vegzo fuggveny.
     * @param e A megfelelo epitheto objektum, amely a nyersanyagokat ellenorzi es tenylegesen letrehozza majd a teleportkapukat.
     */
    public void TeleportEpit(Epitheto e) {
        SkeletonController.FunctionCall(new Object() {}.getClass().getEnclosingMethod().getName(), this);
        for (int i = 0; i < nyersanyagRakter.size(); i++) {
            e.KellE((Nyersanyag) nyersanyagRakter.get(i));
        }
        
        boolean epitheto = e.EpithetoE();

        int res1 = SkeletonController.AskForInput("epitheto?", new ArrayList<String>() {{
            add("igen");
            add("nem");
        }});
        switch (res1) {
            case 0:
                System.out.println("kilepes");
                return;
            case 1:
                System.out.println("epitheto");
                break;
            case 2:
                System.out.println("nem epitheto");
                break;
            default:
                System.out.println("Rossz bemenet");
                break;
        }
        int res2 = SkeletonController.AskForInput("Van hely a rakterben?", new ArrayList<String>() {{
            add("igen");
            add("nem");
        }});
        switch (res2) {
            case 0:
                System.out.println("kilepes");
                return;
            case 1:
                System.out.println("van hely");
                break;
            case 2:
                System.out.println("nincs hely");
                break;
            default:
                System.out.println("Rossz bemenet");
                break;
        }
        if (res1 == 1 && res2 == 1) {        // epitheto es van hely a rakterben
            List<Szallithato> ujak = e.Letrejon(aszteroida);
            teleportkapuRakter.add(ujak.get(0));
            teleportkapuRakter.add(ujak.get(1));
        }
        SkeletonController.FunctionReturn();
    }

    /**
     * A telepes lerak egy teleportkaput
     */
    public void KapuLerak(Teleportkapu k) {
    	SkeletonController.FunctionCall(new Object() {
        }.getClass().getEnclosingMethod().getName(), this);

        k.SetSajatAszteroida(aszteroida);

        SkeletonController.FunctionReturn();
    	
    }

    /**
     * Telepest napvihar eri.
     */
    @Override
    public void Napvihar() {
        SkeletonController.FunctionCall(new Object() {
        }.getClass().getEnclosingMethod().getName(), this);

        this.Meghal();

        SkeletonController.FunctionReturn();
    }

    /**
     * Telepes meghal.
     */
    @Override
    public void Meghal() {
        SkeletonController.FunctionCall(new Object() {
        }.getClass().getEnclosingMethod().getName(), this);
        aszteroida.HajoElhagy(this);
        //palya.removeAIVezerli(this);
        List<Szallithato> temp_nyersanyagRakter = new ArrayList<>(nyersanyagRakter);
        List<Szallithato> temp_teleportkapuRakter = new ArrayList<>(teleportkapuRakter);

        for (Szallithato szallithato : temp_nyersanyagRakter) szallithato.Megsemmisul();
        for (Szallithato szallithato : temp_teleportkapuRakter) szallithato.Megsemmisul();
        SkeletonController.FunctionReturn();
    }

    /*A telepes felrobban*/
    @Override
    public void Robbanas() {
        SkeletonController.FunctionCall(new Object() {
        }.getClass().getEnclosingMethod().getName(), this);
        Meghal();
        SkeletonController.FunctionReturn();
    }

    
    /**
     * A telepes lep egyet
     */
    @Override
    void Lepes() {
        // TODO Auto-generated method stub
    }

    /**
     * Ellenorzi a hajo mivel jarulhat hozza a gyozelemhez
     * @param e -amit vizsgalunk
     */
    @Override
    boolean NyerEllenoriz(Epitheto e) {
        // TODO Auto-generated method stub
        return false;
    }


    /**
     * Ellenorzi a hajo mivel jarulhat hozza a gyozelemhez
     * @param n - a nyersanyag ami visszateszunk
     */
    void AnyagVisszatesz(Nyersanyag n) {
    	SkeletonController.FunctionCall(new Object() {}.getClass().getEnclosingMethod().getName(), this);
        aszteroida.AddMag(n);
        SkeletonController.FunctionReturn();
    }

    /**
     * A nyersanyagrakterhez hozzaadjuk az adott szallithatot
     * @param n - az elem amit hozzaadunk
     */
    void AddRakter(Szallithato n) {
    	SkeletonController.FunctionCall(new Object() {}.getClass().getEnclosingMethod().getName(), this);
    	nyersanyagRakter.add(n);
    	SkeletonController.FunctionReturn();
    }

    /**
     * Banyassszuk az aszteroidat amin a telepes van
     */
    void Banyasz() {
    	SkeletonController.FunctionCall(new Object() {}.getClass().getEnclosingMethod().getName(), this);
        Nyersanyag n = aszteroida.Kinyer();
        
        if(n != null) {
	        int res = SkeletonController.AskForInput("Van hely a rakterben?", new ArrayList<String>() {{
	            add("igen");
	            add("nem");
	        }});
	        switch(res) {
	            case 0:
	                System.out.println("kilepes");
	                return;
	            case 1:
	                System.out.println("van hely");
	                AddRakter(n);
	                break;
	            case 2:
	                System.out.println("nincs hely");
	                break;
	            default:
	                System.out.println("Rossz bemenet");
	                break;
	        }
	        SkeletonController.FunctionReturn();
	    }
    }
    
    
    public void Show() {
    	System.out.println(Main.NamesMap.get(aszteroida) + ": Aszteroida");
    	System.out.print("NyersanyagRakter: ");
    	StringJoiner lineJoiner = new StringJoiner(",");
    	for (Szallithato szallithato : nyersanyagRakter) {
    		lineJoiner.add(Main.getKeyByValue(Main.NamesMap, szallithato)+": " + szallithato.getClass().getSimpleName());
		}
    	System.out.println(lineJoiner.toString() + ": Nyersanyag[0..10]");
    	lineJoiner = new StringJoiner(",");
    	System.out.print("NyersanyagRakter: ");
    	for (Szallithato tpkapu : teleportkapuRakter) {
    		lineJoiner.add(Main.getKeyByValue(Main.NamesMap, tpkapu)+": " + tpkapu.getClass().getSimpleName());
		}
    	System.out.println(lineJoiner.toString() + ": Teleportkapu[0..3]");
    }

}