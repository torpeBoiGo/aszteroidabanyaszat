package Skeleton;

/**
 * A robot mukodeset megvalosito osztaly.
 */
public class Robot extends Hajo {
    /**
     * Robot konstruktora, ha a keletkezese pillanatatol aszteroidan tartozkodik
     *
     * @param a Aszteroida, amin tartozkodik
     */
    public Robot(Aszteroida a) {
        a.HajoErkezik(this);
        aszteroida = a;
    }

    /**
     * Robotot napvihar eri.
     */
    @Override
    public void Napvihar() {
        this.Meghal();
    }

    /**
     * Robot meghal.
     */
    @Override
    public void Meghal() {
        aszteroida.HajoElhagy(this);
        //palya.removeAIVezerli(this);
    }

    /**
     * Robot felrobban.
     */
    @Override
    public void Robbanas() {
    }

    /**
     * A robot lep egyet, itt lesz mevalositva a viselkedese
     */
    @Override
    void Lepes() {
        // TODO Auto-generated method stub
    }

    /**
     * Ellenorzi a robot mivel jarulhat hozza a gyozelemhez
     */
    @Override
    boolean NyerEllenoriz(Epitheto e) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public String toString() {
        //System.out.println("Aszteroida: "+ Main.getKeyByValue(Main.NamesMap, aszteroida)+ ": Aszteroida");
        return super.toString();
    }
}