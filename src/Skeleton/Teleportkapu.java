package Skeleton;

public class Teleportkapu implements Mezo, Szallithato{
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
		SkeletonController.FunctionCall(new Object(){}.getClass().getEnclosingMethod().getName(),this);
		this.sajatAszteroida = a;
		SkeletonController.FunctionReturn();
	}
	
	public void HajoTeleportErkezik(Hajo h) {
		SkeletonController.FunctionCall(new Object(){}.getClass().getEnclosingMethod().getName(),this);
		if (sajatAszteroida != null) {
			sajatAszteroida.HajoErkezik(h);
			
		}
		
		SkeletonController.FunctionReturn();
	}
	
	public void Elront() {
		SkeletonController.FunctionCall(new Object(){}.getClass().getEnclosingMethod().getName(),this);
		mukodikE = false;
		SkeletonController.FunctionReturn();
	}
	
	@Override
	public void Robban() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void RemoveSzomszed(Mezo m) {
		SkeletonController.FunctionCall(new Object(){}.getClass().getEnclosingMethod().getName(),this);
		if (sajatAszteroida != null) sajatAszteroida.RemoveSzomszed(this);
		Elront();
		if (par!=null) {
			par.SetPar(null);
			par.RemoveSzomszed(this);
		}
		SkeletonController.FunctionReturn();
		
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
	
	public void Megsemmisul() {
		SkeletonController.FunctionCall(new Object(){}.getClass().getEnclosingMethod().getName(),this);
		Elront();
		if (par!=null) {
			par.SetPar(null);
			par.RemoveSzomszed(this);
		}
		SkeletonController.FunctionReturn();
	}
}
