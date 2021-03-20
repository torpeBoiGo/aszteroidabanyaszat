package Skeleton;

import java.util.ArrayList;

public class Robot extends Hajo{
	public Robot(Aszteroida a) {
        SkeletonController.ObjectCreated(this);
        a.HajoErkezik(this);
        aszteroida = a;
    }
	
	@Override 
	void Meghal() {
		SkeletonController.FunctionCall(new Object(){}.getClass().getEnclosingMethod().getName(),this);
    	aszteroida.HajoElhagy(this);
    	//palya.removeAIVezerli(this);
    	//SkeletonController.FunctionReturn();
	}

	@Override
	void Robbanas() {
		SkeletonController.FunctionCall(new Object(){}.getClass().getEnclosingMethod().getName(),this);
    	int van_szomszed = SkeletonController.AskForInput("Van szomszédja az aszteroidának?", new ArrayList<String>() {{
			add("igen");
			add("nem");}});
    	
    	switch(van_szomszed) {
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
