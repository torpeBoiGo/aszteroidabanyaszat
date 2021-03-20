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
    
    public void TeleportEpit(Epitheto e) {
    	
    }
    
    public void KapuLerak(Teleportkapu k) {
    	
    	
    }

    @Override
	public void Meghal() {
    	SkeletonController.FunctionCall(new Object(){}.getClass().getEnclosingMethod().getName(),this);
    	aszteroida.HajoElhagy(this);
    	//palya.removeAIVezerli(this);
    	List<Szallithato> temp_nyersanyagRakter = new ArrayList<Szallithato>(nyersanyagRakter);
    	List<Szallithato> temp_teleportkapuRakter = new ArrayList<Szallithato>(teleportkapuRakter);
    
		for (Szallithato szallithato : temp_nyersanyagRakter) szallithato.Megsemmisul();
		for (Szallithato szallithato : temp_teleportkapuRakter) szallithato.Megsemmisul();
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