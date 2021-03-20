package Skeleton;

import java.util.Vector;

public class Epitheto {
    public void Hozzaad(Nyersanyag n){

    }
    public boolean KellE(Nyersanyag n){
    	SkeletonController.FunctionCall(new Object(){}.getClass().getEnclosingMethod().getName(),this);
    	SkeletonController.FunctionReturn();
    	return false;
    }
    public boolean EpithetoE(){
    	SkeletonController.FunctionCall(new Object(){}.getClass().getEnclosingMethod().getName(),this);
    	SkeletonController.FunctionReturn();
        return false;
    }
    public void Reset(){

    }
    public Vector<Szallithato> Letrejon(Aszteroida a){
        return new Vector<Szallithato>();
    }


}
