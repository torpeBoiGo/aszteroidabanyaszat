package Skeleton;

/**A jatekban szereplo nyersanyagok ososztalya*/
public abstract class Nyersanyag implements Szallithato{
	/**Konstruktor*/
	public Nyersanyag() {
		SkeletonController.ObjectCreated(this);
	}
	/**A nyersanyag megsemmisulesert felel*/
	 public void Megsemmisul() {
		 SkeletonController.FunctionCall(new Object(){}.getClass().getEnclosingMethod().getName(),this);
		 SkeletonController.FunctionReturn();
	 } 
	
	 /**A fuggveny, akkor hivodik meg,  
	  * mikor a nyersanyagrol lekerul az utolso kulsoreteg is,
	  * valamint az aszteroidaja napkozelben  van
	  * @param a Az aszteroida, amin a nyersanyag van
	  */
	public void Megfurva(Aszteroida a) {
		 SkeletonController.FunctionCall(new Object(){}.getClass().getEnclosingMethod().getName(),this);
		 SkeletonController.FunctionReturn();
	}
	
	/**A  f�ggv�ny  megvizsg�lja, hogy a param�terk�nt kapott nyersanyag
	 * azonos vagy kompatibilis-e a nyersanyaggal
	 * @param ny Az �sszehasonl�tand� nyersanyag
	 * @return igaz, ha a k�t nyersanyag azonos t�pus�, egy�bk�nt hamis
	 */
	public boolean KompatibilisE(Nyersanyag ny) {
		SkeletonController.FunctionCall(new Object(){}.getClass().getEnclosingMethod().getName(),this);
		SkeletonController.FunctionReturn();
		return (ny.getClass() == getClass());
	}
}
