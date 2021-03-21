package Skeleton;

/**
 * A jatekban szereplo uran nyersanyag
 */
public class Uran extends Nyersanyag {
    /**
     * fuggveny akkor hivodik, mikor az uranrol lekerul az utolso kulsoreteg is,
     * valamint  az  aszteroidaja  napkozelben  van. Ekkora az uran felrobban.
     *
     * @param a Az aszteroida, amin az uran van.
     */
    @Override
    public void Megfurva(Aszteroida a) {
        SkeletonController.FunctionCall(new Object() {
        }.getClass().getEnclosingMethod().getName(), this);
        a.Robban();
        SkeletonController.FunctionReturn();
    }
}

