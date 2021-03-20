package Skeleton;

/**A játékban szereplõ urán nyersanyag*/
public class Uran extends Nyersanyag{
	@Override
	/** függvény akkor hívódik, mikor a vízjégrõl lekerül az utolsó  külsõréteg is,
	 *  valamint  az  aszteroidája  napközelben  van. Ekkora az urán felrobban.
	 *  @para a Az aszteroida, amin az urán van.
	 */
	public void Megfurva(Aszteroida a) {
		SkeletonController.FunctionCall(new Object(){}.getClass().getEnclosingMethod().getName(),this);
		a.Robban();
		//SkeletonController.FunctionReturn();
	}
}

