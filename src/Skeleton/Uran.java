package Skeleton;

/**A jatekban szereplo urenn nyersanyag*/
public class Uran extends Nyersanyag{
	@Override
	/** fuggveny akkor hivodik, mikor az uranrol lekerul az utolso kulsoreteg is,
	 *  valamint  az  aszteroidaja  napkozelben  van. Ekkora az uran felrobban.
	 *  @para a Az aszteroida, amin az uran van.
	 */
	public void Megfurva(Aszteroida a) {
		SkeletonController.FunctionCall(new Object(){}.getClass().getEnclosingMethod().getName(),this);
		a.Robban();
		SkeletonController.FunctionReturn();
	}
}

