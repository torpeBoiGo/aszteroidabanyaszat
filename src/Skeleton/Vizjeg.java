package Skeleton;

/**A jatekban szereplo vizjeg nyersanyag*/
public class Vizjeg extends Nyersanyag{
  	@Override
  	/** fuggveny akkor hivodik, mikor a vizjegrol lekerul az utolso kulsoreteg is,
	 *  valamint  az  aszteroidaja  napkozelben  van. Ekkora a vizjeg elszublimal.
	 *  @para a Az aszteroida, amin a vízjeg van.
	 */
	public void Megfurva(Aszteroida a) {
  		SkeletonController.FunctionCall(new Object(){}.getClass().getEnclosingMethod().getName(),this);
		Nyersanyag kinyert = a.Kinyer();
		SkeletonController.FunctionReturn();
	}
}
