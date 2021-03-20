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
    	SkeletonController.FunctionCall(new Object(){}.getClass().getEnclosingMethod().getName(),this);
    	int napkozeli = SkeletonController.AskForInput("Napk�zelben van az aszteroida?", new ArrayList<String>() {{
																    add("igen");
																    add("nem");}});
    	switch (napkozeli) {
        case 0:
        	System.out.println("kilepes");
        	return;
        case 1:
        	System.out.println("napkozelben van az aszteroida");
            break;
        case 2:
        	System.out.println("nincs napkozelben az aszteroida");
            break;
        default:
        	System.out.println("Rossz bemenet");
            break;
    	}
    	
    	int atfurva = SkeletonController.AskForInput("Teljesen �t van f�rva az aszteroida?", new ArrayList<String>() {{
		    														add("igen");
		    														add("nem");}});
    	
    	switch (atfurva) {
        case 0:
        	System.out.println("kilepes");
        	return;
        case 1:
        	System.out.println("teljesen �t van f�rva az aszteroida");
            break;
        case 2:
        	System.out.println("nincs teljesen �tf�rva az aszteroida");
            break;
        default:
        	System.out.println("Rossz bemenet");
            break;
    	}
    	
    	if (napkozeli==1 & atfurva==1) mag.Megfurva(this);
    	SkeletonController.FunctionReturn();
    }
    
    public Nyersanyag Kinyer(){
    	SkeletonController.FunctionCall(new Object(){}.getClass().getEnclosingMethod().getName(),this);
    	int kinyerheto = SkeletonController.AskForInput("Kinyerheto az aszteroida magja?", new ArrayList<String>() {{
			add("igen");
			add("nem");}});

		switch (kinyerheto) {
		case 0:
			System.out.println("kilepes");
			break;
		case 1:
			System.out.println("a mag kinyerheto");
			Nyersanyag kinyert = mag;
			mag = null;
			SkeletonController.FunctionReturn();
			return kinyert;
		case 2:
			System.out.println("a meg nem nyerheto ki");
			break;
		default:
			System.out.println("Rossz bemenet");
			break;
		}
		SkeletonController.FunctionReturn();
		return null;
    }
    
    public boolean NapkozelbenE(){
        return true;
    }
    
    public List<Mezo> getSzomszedok(){
    	return szomszedok;
    }
    
    public void AddSzomszed(Mezo m){
    	SkeletonController.FunctionCall(new Object(){}.getClass().getEnclosingMethod().getName(), this);
    	szomszedok.add(m);
    }

    @Override
    public void Robban() {
    	SkeletonController.FunctionCall(new Object(){}.getClass().getEnclosingMethod().getName(), this);
    	//TODO this is shit... mert az
		for (Hajo hajo : hajok) {
			hajo.Robbanas();
		}
		for (Mezo mezo : szomszedok) mezo.RemoveSzomszed(this);
    }
    
    @Override
    public void RemoveSzomszed(Mezo m){
    	SkeletonController.FunctionCall(new Object(){}.getClass().getEnclosingMethod().getName(), this);
    	if(m!=null) szomszedok.remove(m);
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
    
    public boolean AddMag (Nyersanyag n){
    	SkeletonController.FunctionCall(new Object(){}.getClass().getEnclosingMethod().getName(), this);
    	int atfurva = SkeletonController.AskForInput("El lehet helyezi a nyersanyagot az aszteroidaban?", new ArrayList<String>() {{
			add("igen");
			add("nem");}});

		switch (atfurva) {
		case 0:
			System.out.println("kilepes");
			return false;
		case 1:
			System.out.println("el lehet helyezi a nyersanyagot az aszteroidaban");
			mag = n;
			return true;
		case 2:
			System.out.println("nem lehet elhelyezi a nyersanyagot az aszteroid�ba");
			break;
		default:
			System.out.println("Rossz bemenet");
			break;
		}
		
		return false;
    }


}
