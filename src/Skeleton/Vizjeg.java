package Skeleton;

/**A játékban szereplõ vizjeg nyersanyag*/
public class Vizjeg extends Nyersanyag{
  	@Override
  	/** függvény akkor hívódik, mikor a vízjégrõl lekerül az utolsó  külsõréteg is,
	 *  valamint  az  aszteroidája  napközelben  van. Ekkora a vízjég elszublimál.
	 *  @para a Az aszteroida, amin a vízjég van.
	 */
	public void Megfurva(Aszteroida a) {
  		SkeletonController.FunctionCall(new Object(){}.getClass().getEnclosingMethod().getName(),this);
		Nyersanyag kinyert = a.Kinyer();
		//SkeletonController.FunctionReturn();
	}
}
