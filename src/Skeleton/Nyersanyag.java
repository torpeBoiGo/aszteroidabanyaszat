package Skeleton;

public abstract class Nyersanyag implements Szallithato{
	 public void Megsemmisul() {
		
	} 
	
	public void Megfurva() {
		
	}
	
	public boolean KompatibilisE(Nyersanyag ny) {
		SkeletonController.FunctionCall(new Object(){}.getClass().getEnclosingMethod().getName(),this);
		
    	SkeletonController.FunctionReturn();
		return (equals(ny));
	}
}
