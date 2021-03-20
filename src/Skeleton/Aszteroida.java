package Skeleton;

import java.util.ArrayList;
import java.util.List;

public class Aszteroida implements Mezo{
	public String name;
    List<Mezo> szomszedok = new ArrayList<Mezo>();
    int kulsoRetegek;
    Nyersanyag mag;
    List<Hajo> hajok = new ArrayList<Hajo>();
    boolean napkozelben;


    public Aszteroida() {
		SkeletonController.ObjectCreated(this);
	}
    
    public void Fur() {

    }
    public boolean NapkozelbenE(){
        return napkozelben;
    }
    public void AddSzomszed(Mezo m){
    	szomszedok.add(m);
    }

    @Override
    public void Robban() {

    }

    public void RemoveSzomszed(Mezo m){

    }

    @Override
    public void HajoErkezik(Hajo h) {
    	SkeletonController.FunctionCall(new Object(){}.getClass().getEnclosingMethod().getName(), this);
    	
    	hajok.add(h);
    	h.MezoBeallit(this);
    	
    	SkeletonController.FunctionReturn();
    }

    @Override
    public void HajoElhagy(Hajo h) {
    	SkeletonController.FunctionCall(new Object(){}.getClass().getEnclosingMethod().getName(), this);
    	hajok.remove(h);
    	
    }

    public void Napvihar(){

    }
    public boolean AddMag(Nyersanyag n){
        return false;
    }

    public Nyersanyag Kinyer(){
        if(kulsoRetegek>0 || mag == null){
            return null;
        }
        else{
            return mag;
        }

    }

    public boolean addMag(Nyersanyag n){
        if(mag== null && kulsoRetegek ==0){
             if(napkozelben){
                 n.Megfurva();
             }
        return true;
    }
        return false;
    }


}
