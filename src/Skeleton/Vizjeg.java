package Skeleton;

/**A j�t�kban szerepl� vizjeg nyersanyag*/
public class Vizjeg extends Nyersanyag{
  	@Override
  	/** f�ggv�ny akkor h�v�dik, mikor a v�zj�gr�l leker�l az utols�  k�ls�r�teg is,
	 *  valamint  az  aszteroid�ja  napk�zelben  van. Ekkora a v�zj�g elszublim�l.
	 *  @para a Az aszteroida, amin a v�zj�g van.
	 */
	public void Megfurva(Aszteroida a) {
  		SkeletonController.FunctionCall(new Object(){}.getClass().getEnclosingMethod().getName(),this);
		Nyersanyag kinyert = a.Kinyer();
		//SkeletonController.FunctionReturn();
	}
}
