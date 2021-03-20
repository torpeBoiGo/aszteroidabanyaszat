package Skeleton;

/**A j�t�kban szerepl� ur�n nyersanyag*/
public class Uran extends Nyersanyag{
	@Override
	/** f�ggv�ny akkor h�v�dik, mikor a v�zj�gr�l leker�l az utols�  k�ls�r�teg is,
	 *  valamint  az  aszteroid�ja  napk�zelben  van. Ekkora az ur�n felrobban.
	 *  @para a Az aszteroida, amin az ur�n van.
	 */
	public void Megfurva(Aszteroida a) {
		SkeletonController.FunctionCall(new Object(){}.getClass().getEnclosingMethod().getName(),this);
		a.Robban();
		SkeletonController.FunctionReturn();
	}
}

