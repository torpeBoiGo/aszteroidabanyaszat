package Skeleton;

abstract class Hajo {
	
	protected Aszteroida aszteroida;
	
    public void Fur(){
		aszteroida.Fur();
    }
    
    public void Mozog(Mezo uj_mezo){
    	SkeletonController.FunctionCall("Hajo", "Mozog()");
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
    	SkeletonController.ObjectCreated(this);
    	SkeletonController.FunctionCall("Telepes", "Tetlen");
    	SkeletonController.FunctionReturn();
    }
    
    //Ezt elbaltáztuk... Aszteroidabeallit kellett volna hogy legyen
    public void MezoBeallit(Mezo m){
    	SkeletonController.FunctionCall("Hajo", "Mezobeallit");
    			
    	if(aszteroida != null)
    		aszteroida.HajoElhagy(this);
    	aszteroida = (Aszteroida) m;
    	
    	SkeletonController.FunctionReturn();
    }
    
    abstract boolean NyerEllenoriz(Epitheto e);
}