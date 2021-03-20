package Skeleton;

import java.util.ArrayList;
import java.util.List;

public class Telepes extends Hajo{
	ArrayList<Nyersanyag> nyersanyagRakter;
	ArrayList<Teleportkapu> teleportkapuRakter;
	
    public Telepes(Aszteroida a) {
        SkeletonController.ObjectCreated(this);
        a.HajoErkezik(this);
        aszteroida = a;
        
    }
    
    void AddNyersanyagRakter(Nyersanyag n) {
    	SkeletonController.FunctionCall(new Object(){}.getClass().getEnclosingMethod().getName(),this);
		int rakter = SkeletonController.AskForInput("Van hely a raktérben?", new ArrayList<String>() {{
			add("igen");
			add("nem");}});

		switch (rakter) {
		case 0:
			System.out.println("kilepes");
			break;
		case 1:
			System.out.println("van hely a raktérben");
			break;
		case 2:
			System.out.println("nincs hely a raktérben");
			break;
		default:
			System.out.println("Rossz bemenet");
			break;
		}
		
		if (rakter==1) nyersanyagRakter.add(n);
		
    }
    
    void AddTeleportkapuRakter(Teleportkapu t) {
    	SkeletonController.FunctionCall(new Object(){}.getClass().getEnclosingMethod().getName(),this);
		int rakter = SkeletonController.AskForInput("Van hely a raktérben?", new ArrayList<String>() {{
			add("igen");
			add("nem");}});

		switch (rakter) {
		case 0:
			System.out.println("kilepes");
			break;
		case 1:
			System.out.println("van hely a raktérben");
			break;
		case 2:
			System.out.println("nincs hely a raktérben");
			break;
		default:
			System.out.println("Rossz bemenet");
			break;
		}
		
		if(rakter == 1) teleportkapuRakter.add(t);
		
    }

    @Override
	void Meghal() {
    	SkeletonController.FunctionCall(new Object(){}.getClass().getEnclosingMethod().getName(),this);
    	aszteroida.HajoElhagy(this);
    	//palya.removeAIVezerli(this);
    	for (int i=0;i<nyersanyagRakter.size();i++) nyersanyagRakter.get(i).Megsemmisul();
    	for (int i=0;i<teleportkapuRakter.size();i++) teleportkapuRakter.get(i).Megsemmisul();
    	//SkeletonController.FunctionReturn();
	}
    
	@Override
	void Robbanas() {
		SkeletonController.FunctionCall(new Object(){}.getClass().getEnclosingMethod().getName(),this);
    	Meghal();
		//SkeletonController.FunctionReturn();
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