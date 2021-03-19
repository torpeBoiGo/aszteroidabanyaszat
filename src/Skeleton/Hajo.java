package Skeleton;

import java.util.ArrayList;

abstract class Hajo {
	
	protected Aszteroida aszteroida;
	public String name;
    public void Fur(){
		aszteroida.Fur();
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
    public void Tetlen(){}
    
    //Ezt elbaltáztuk... Aszteroidabeallit kellett volna hogy legyen
    public void MezoBeallit(Mezo m){
    	SkeletonController.FunctionCall(new Object(){}.getClass().getEnclosingMethod().getName(), this);
    	
    	
    	
    	//Ez ide nem kell, csak mint bemutató kódot tettem bele
    	int res = SkeletonController.AskForInput("null az aszteroida?", new ArrayList<String>() {{
																    add("igen");
																    add("nem");}});
    	
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