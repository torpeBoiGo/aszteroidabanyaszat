package Skeleton;

import java.util.ArrayList;

public class Teleportkapu implements Mezo{
	Teleportkapu par;
	Aszteroida sajatAszteroida;
	boolean mukodikE;
	
	public Teleportkapu() {
		SkeletonController.ObjectCreated(this);
        par = null;
        sajatAszteroida = null;
        mukodikE = true;
	}
	
	public void SetPar(Teleportkapu p) {
		SkeletonController.FunctionCall(new Object(){}.getClass().getEnclosingMethod().getName(),this);
		par = p;
		SkeletonController.FunctionReturn();
	}
	public void SetSajatAszteroida(Aszteroida a) {
		this.sajatAszteroida = a;
	}
	public void HajoTeleportErkezik(Hajo h) {
		SkeletonController.FunctionCall(new Object(){}.getClass().getEnclosingMethod().getName(),this);
		if (sajatAszteroida != null) {
			sajatAszteroida.HajoErkezik(h);
			
		}
		
		SkeletonController.FunctionReturn();
	}
	
	public void Elront() {
		
	}
	
	@Override
	public void Robban() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void RemoveSzomszed(Mezo m) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void HajoErkezik(Hajo h) {
		SkeletonController.FunctionCall(new Object(){}.getClass().getEnclosingMethod().getName(),this);
		int res = SkeletonController.AskForInput("null a par?", new ArrayList<String>() {{
		    add("igen");
		    add("nem");}});
		
		switch (res) {
        case 0:
        	System.out.println("kilepes");
        	return;
        case 1:
        	System.out.println("null a par");
        	par = null;
            break;
        case 2:
        	System.out.println("nem null a par");
        	//itt elvileg az inicializalas soran mar beallitottunk part, szoval nincs teendo
            break;
        default:
        	System.out.println("Rossz bemenet");
            break;
    }
		
		if (par != null) {
			par.HajoTeleportErkezik(h);
		}
		
		SkeletonController.FunctionReturn();
	}
	@Override
	public void HajoElhagy(Hajo h) {
		// TODO Auto-generated method stub
		
	}
	
	
}
