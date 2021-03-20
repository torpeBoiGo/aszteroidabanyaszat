package Skeleton;

import java.util.ArrayList;
import java.util.List;

public class Telepes extends Hajo {
    List<Szallithato> nyersanyagRakter = new ArrayList<Szallithato>();
    List<Szallithato> teleportkapuRakter = new ArrayList<Szallithato>();
	
	
	public Telepes(Aszteroida a) {
        SkeletonController.ObjectCreated(this);
        a.HajoErkezik(this);
        aszteroida = a;
        
    }
	public Telepes() {
        SkeletonController.ObjectCreated(this);
        aszteroida = null;
    }
    
    public void AnyagVisszatesz(Nyersanyag n) {
    	
    }
    
    public void Banyasz() {
    	
    }
    
    public void AddRakter(Szallithato sz) {
    	
    }
    
    public void RobotEpit(Epitheto e) {
    	SkeletonController.FunctionCall(new Object(){}.getClass().getEnclosingMethod().getName(),this);
    	for (int i = 0; i < nyersanyagRakter.size(); i++) {
    		e.KellE((Nyersanyag)nyersanyagRakter.get(i));
    	}
    	boolean epitheto = e.EpithetoE();
    	
    	int res1 = SkeletonController.AskForInput("epitheto?", new ArrayList<String>() {{
																    add("igen");
																    add("nem");}});
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
	    if (res1 == 1) { 		// epitheto
	    	e.Letrejon(aszteroida);
	    }
    	SkeletonController.FunctionReturn();
    }

    public void TeleportEpit(Epitheto e) {
    	SkeletonController.FunctionCall(new Object(){}.getClass().getEnclosingMethod().getName(),this);
    	for (int i = 0; i < nyersanyagRakter.size(); i++) {
    		e.KellE((Nyersanyag)nyersanyagRakter.get(i));
    	}
    	boolean epitheto = e.EpithetoE();
    	
    	int res1 = SkeletonController.AskForInput("epitheto?", new ArrayList<String>() {{
																    add("igen");
																    add("nem");}});
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
		    														add("nem");}});
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
	    if (res1 == 1 && res2 == 1) { 		// epitheto es van hely a rakterben
	    	List<Szallithato> ujak = e.Letrejon(aszteroida);
	    	teleportkapuRakter.add(ujak.get(0));
	    	teleportkapuRakter.add(ujak.get(1));
	    }
    	SkeletonController.FunctionReturn();
    }
    
    public void KapuLerak(Teleportkapu k) {
    	
    	
    }
    
	@Override
	void Robbanas() {
		// TODO Auto-generated method stub
		
	}

	@Override
	void Lepes() {
		// TODO Auto-generated method stub
	}
  
	@Override
	boolean NyerEllenoriz(Epitheto e) {
		// TODO Auto-generated method stub
		return false;
	}
}