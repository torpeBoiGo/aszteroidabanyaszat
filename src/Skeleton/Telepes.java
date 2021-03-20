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
    
    public void RobotEpit(Epitheto e) {
    	
    }
    
    void AddNyersanyagRakter(Nyersanyag n) {
    	SkeletonController.FunctionCall(new Object(){}.getClass().getEnclosingMethod().getName(),this);
		int rakter = SkeletonController.AskForInput("Van hely a rakterben?", new ArrayList<String>() {{
			add("igen");
			add("nem");}});
    
		switch (rakter) {
		case 0:
			System.out.println("kilepes");
			break;
		case 1:
			System.out.println("van hely a rakterben");
			break;
		case 2:
			System.out.println("nincs hely a rakterben");
			break;
		default:
			System.out.println("Rossz bemenet");
			break;
		}
		
		if (rakter==1) nyersanyagRakter.add(n);
		
    }
    
    void AddTeleportkapuRakter(Teleportkapu t) {
    	SkeletonController.FunctionCall(new Object(){}.getClass().getEnclosingMethod().getName(),this);
		int rakter = SkeletonController.AskForInput("Van hely a rakterben?", new ArrayList<String>() {{
			add("igen");
			add("nem");}});

		switch (rakter) {
		case 0:
			System.out.println("kilepes");
			break;
		case 1:
			System.out.println("van hely a rakterben");
			break;
		case 2:
			System.out.println("nincs hely a rakterben");
			break;
		default:
			System.out.println("Rossz bemenet");
			break;
		}
		
		if(rakter == 1) teleportkapuRakter.add(t);
		
    }
    
    public void TeleportEpit(Epitheto e) {
    	
    }
    
    public void KapuLerak(Teleportkapu k) {
    	
    	
    }

    @Override
	public void Meghal() {
    	SkeletonController.FunctionCall(new Object(){}.getClass().getEnclosingMethod().getName(),this);
    	aszteroida.HajoElhagy(this);
    	//palya.removeAIVezerli(this);
		for (Szallithato szallithato : nyersanyagRakter) szallithato.Megsemmisul();
		for (Szallithato szallithato : teleportkapuRakter) szallithato.Megsemmisul();
    	SkeletonController.FunctionReturn();
	}
    
	@Override
	public void Robbanas() {
		SkeletonController.FunctionCall(new Object(){}.getClass().getEnclosingMethod().getName(),this);
    	Meghal();
		SkeletonController.FunctionReturn();
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