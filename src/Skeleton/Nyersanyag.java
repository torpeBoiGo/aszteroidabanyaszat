package Skeleton;

/**A játékban szereplõ nyersanyagok õsosztálya*/
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
	
	 /**A függvény, akkor hívodik meg,  
	  * mikor a nyersanyagról lekerül az utolsó külsõréteg is,
	  * valamint az aszteroidája napközelben  van
	  * @param a Az aszteroida, amin a nyersanyag van
	  */
	public void Megfurva(Aszteroida a) {
		 SkeletonController.FunctionCall(new Object(){}.getClass().getEnclosingMethod().getName(),this);
		 //SkeletonController.FunctionReturn();
	}
	
	/**A  függvény  megvizsgálja, hogy a paraméterként kapott nyersanyag
	 * azonos vagy kompatibilis-e a nyersanyaggal
	 * @param ny Az összehasonlítandó nyersanyag
	 * @return igaz, ha a két nyersanyag azonos típusú, egyébként hamis
	 */
	public boolean KompatibilisE(Nyersanyag ny) {
		SkeletonController.FunctionCall(new Object(){}.getClass().getEnclosingMethod().getName(),this);
		//SkeletonController.FunctionReturn();
		return (ny.getClass() == getClass());
	}
}
