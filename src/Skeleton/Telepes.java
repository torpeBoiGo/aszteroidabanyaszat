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
    
    public void AnyagVisszatesz(Nyersanyag n) {
    	
    }
    
    public void Banyasz() {
    	
    }
    
    public void AddRakter(Szallithato sz) {
    	
    }
    
    public void RobotEpit(Epitheto e) {
    	
    }

    public void TeleportEpit(Epitheto e) {
    	
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
	
	public void setName(String input) {
    	super.name = input;
    }
}