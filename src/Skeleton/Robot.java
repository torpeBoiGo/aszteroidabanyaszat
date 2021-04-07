package Skeleton;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * A robot mukodeset megvalosito osztaly.
 */
public class Robot extends Hajo {
    /**
     * Robot konstruktora, ha a keletkezese pillanatatol aszteroidan tartozkodik
     *
     * @param a Aszteroida, amin tartozkodik
     */
    public Robot(Aszteroida a) {
        SkeletonController.ObjectCreated(this);
        a.HajoErkezik(this);
        aszteroida = a;
    }

    /**
     * Az aszteroidan valo furast hajtja vegre
     */
    public void Fur() {
        SkeletonController.FunctionCall(new Object() {
        }.getClass().getEnclosingMethod().getName(), this);
        
        aszteroida.Fur();
        
        SkeletonController.FunctionReturn();
    }
    
    /**
     * Robotot napvihar eri.
     */
    @Override
    public void Napvihar() {
        SkeletonController.FunctionCall(new Object() {
        }.getClass().getEnclosingMethod().getName(), this);

        this.Meghal();

        SkeletonController.FunctionReturn();
    }

    /**
     * Robot meghal.
     */
    @Override
    public void Meghal() {
        SkeletonController.FunctionCall(new Object() {
        }.getClass().getEnclosingMethod().getName(), this);
        aszteroida.HajoElhagy(this);
        //palya.removeAIVezerli(this);
        SkeletonController.FunctionReturn();
    }

    /**
     * Robot felrobban.
     */
    @Override
    public void Robbanas() {
        SkeletonController.FunctionCall(new Object() {
        }.getClass().getEnclosingMethod().getName(), this);
        int van_szomszed = SkeletonController.AskForInput("Van szomszedja az aszteroidanak?", new ArrayList<>() {{
            add("igen");
            add("nem");
        }});

        switch (van_szomszed) {
            case 0:
                System.out.println("kilepes");
                return;
            case 1:
                System.out.println("van szomszedja az aszteroidanak");
                Mozog(aszteroida.getSzomszedok().get(0));
                break;
            case 2:
                System.out.println("nincs szomszedja az aszteroidanak");
                Meghal();
                break;
            default:
                System.out.println("Rossz bemenet");
                break;
        }
        SkeletonController.FunctionReturn();
    }

    /**
     * A robot lep egyet, itt lesz mevalositva a viselkedese
     */
    @Override
    void Lepes() {
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
    boolean NyerEllenoriz(Epitheto e) {
        // TODO Auto-generated method stub
        return false;
    }
    
    public  void Show() {
    	System.out.println("Aszteroida: "+ Main.getKeyByValue(Main.NamesMap, aszteroida)+ ": Aszteroida");
	}
}
