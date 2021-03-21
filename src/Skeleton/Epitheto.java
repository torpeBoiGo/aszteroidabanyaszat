package Skeleton;

import java.util.Vector;

public abstract class Epitheto {
    public void Hozzaad(Nyersanyag n) {

    }
    
    /**
     * Ellenorzi, hogy a parameterul kapott nyersanyag kell-e az adott dolog epitesehez.
     * @param n A nyersanyag, amirol el kell donteni, hogy kell-e az epiteshez.
     * @return True vagy False aszerint, hogy az adott nyersanyag kell-e az epiteshez, vagy nem.
     */
    public boolean KellE(Nyersanyag n) {
        SkeletonController.FunctionCall(new Object() {
        }.getClass().getEnclosingMethod().getName(), this);
        SkeletonController.FunctionReturn();
        return false;
    }
    
    /**
     * Ellenorzi, hogy a KellE fuggvenyben megkapott nyersanyagok felhasznalasaval megepitheto-e az adott dolog.
     * @return True vagy False aszerint, hogy az adott dolog megepitheto-e, vagy sem.
     */
    public boolean EpithetoE() {
        SkeletonController.FunctionCall(new Object() {
        }.getClass().getEnclosingMethod().getName(), this);
        Reset();
        SkeletonController.FunctionReturn();
        return false;
    }
    
    /**
     * Reset-eli az epitheto objektum tartalmat, ami a KellE fuggveny meghivasai miatt nem lenne hasznalhato egy ujabb epiteshez.
     */
    public void Reset() {
    	SkeletonController.FunctionCall(new Object() {
        }.getClass().getEnclosingMethod().getName(), this);
    	
        SkeletonController.FunctionReturn();
    }
    
    /**
     * Letrehozza a megadott aszteroidan a megfelelo dolgokat (robotot vagy teleportkapukat).
     * @param a Az aszteroida, ahol az epites tortenik (a robot epitesenel lenyeges).
     * @return A letrejott dolgok (a teleportepitesnel lenyeges).
     */
    public abstract Vector<Szallithato> Letrejon(Aszteroida a);


}
