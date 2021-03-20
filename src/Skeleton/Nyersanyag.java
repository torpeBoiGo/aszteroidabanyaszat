package Skeleton;

/**A j�t�kban szerepl� nyersanyagok �soszt�lya*/
public class Nyersanyag implements Szallithato{
	/**Konstruktor*/
	public Nyersanyag() {
		SkeletonController.ObjectCreated(this);
	}
	/**A nyersanyag megsemmisulesert felel*/
	 public void Megsemmisul() {
		 SkeletonController.FunctionCall(new Object(){}.getClass().getEnclosingMethod().getName(),this);
		 //SkeletonController.FunctionReturn();
	 } 
	
	 /**A f�ggv�ny, akkor h�vodik meg,  
	  * mikor a nyersanyagr�l leker�l az utols� k�ls�r�teg is,
	  * valamint az aszteroid�ja napk�zelben  van
	  * @param a Az aszteroida, amin a nyersanyag van
	  */
	public void Megfurva(Aszteroida a) {
		 SkeletonController.FunctionCall(new Object(){}.getClass().getEnclosingMethod().getName(),this);
		 //SkeletonController.FunctionReturn();
	}
	
	/**A  f�ggv�ny  megvizsg�lja, hogy a param�terk�nt kapott nyersanyag
	 * azonos vagy kompatibilis-e a nyersanyaggal
	 * @param ny Az �sszehasonl�tand� nyersanyag
	 * @return igaz, ha a k�t nyersanyag azonos t�pus�, egy�bk�nt hamis
	 */
	public boolean KompatibilisE(Nyersanyag ny) {
		SkeletonController.FunctionCall(new Object(){}.getClass().getEnclosingMethod().getName(),this);
		//SkeletonController.FunctionReturn();
		return (ny.getClass() == getClass());
	}
}
