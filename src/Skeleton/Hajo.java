package Skeleton;

import java.util.ArrayList;

abstract class Hajo {
	
	protected Aszteroida aszteroida;
	public String name;
    public void Fur(){
    	SkeletonController.FunctionCall(new Object(){}.getClass().getEnclosingMethod().getName(),this);
		aszteroida.Fur();
		//SkeletonController.FunctionReturn();
    }
    
    public void Mozog(Mezo uj_mezo){
    	SkeletonController.FunctionCall(new Object(){}.getClass().getEnclosingMethod().getName(),this);
    	uj_mezo.HajoErkezik(this);
    	
    	SkeletonController.FunctionReturn();
    }
    
    public void Napvihar(){

    }
    
    abstract void Robbanas();
    abstract void Lepes();
    public void Meghal(){

    }
    public void Tetlen(){
    	SkeletonController.FunctionCall(new Object(){}.getClass().getEnclosingMethod().getName(),this);
    	SkeletonController.FunctionReturn();
    }
    
    //Ezt elbalt�ztuk... Aszteroidabeallit kellett volna hogy legyen
    public void MezoBeallit(Mezo m){
    	SkeletonController.FunctionCall(new Object(){}.getClass().getEnclosingMethod().getName(), this);
    	
    	
    	
    	//Ez ide nem kell, csak mint bemutat� k�dot tettem bele
    	int res = SkeletonController.AskForInput("null az aszteroida?", new ArrayList<String>() {{
																    add("igen");
																    add("nem");}});
    	//Ez nem feltetlen kell
    	//Lehet szebb lesz a kod �s a kimenet ha nem raktuk oda
    	switch (res) {
        case 0:
        	System.out.println("kilepes");
        	return;
        case 1:
        	System.out.println("null az aszteroida");
            break;
        case 2:
        	System.out.println("nem null az aszteroida");
            break;
        default:
        	System.out.println("Rossz bemenet");
            break;
    }
    	
    	
    	if(aszteroida != null)
    		aszteroida.HajoElhagy(this);
    	aszteroida = (Aszteroida) m;
    	
    	SkeletonController.FunctionReturn();
    }
    
    abstract boolean NyerEllenoriz(Epitheto e);
}