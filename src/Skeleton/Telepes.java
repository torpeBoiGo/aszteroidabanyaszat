package Skeleton;

import java.util.ArrayList;
import java.util.List;


public class Telepes extends Hajo {


    List<Szallithato> nyersanyagRakter = new ArrayList<>(); 	// a nyersanyagokat tarolo Rakter
    List<Szallithato> teleportkapuRakter = new ArrayList<>();	// a teleportkapukat tarolo Rakter

    /**
     * A telepes konstruktora, amely beallitja a sajat aszteroidajat, es hozzaadja a parameterul kapott aszteroidan tartozkodo hajokhoz a telepest. 
     * @param a Az az aszteroida, ahova a telepes letrejottenek pillanataban kerul.
     */
    public Telepes(Aszteroida a) {

        SkeletonController.ObjectCreated(this);
        a.HajoErkezik(this);
        aszteroida = a;

    }
    
    /**
     * A telepes konstruktora, a sajat aszteroida erteket nullra allitja. 
     */
    public Telepes() {
        SkeletonController.ObjectCreated(this);
        aszteroida = null;
    }

    /**
     * A Robot epiteset vegzo fuggveny.
     * @param e A megfelelo epitheto objektum, amely a nyersanyagokat ellenorzi es tenylegesen letrehozza majd a robotot.
     */
    public void RobotEpit(Epitheto e) {
        SkeletonController.FunctionCall(new Object() {
        }.getClass().getEnclosingMethod().getName(), this);
        for (int i = 0; i < nyersanyagRakter.size(); i++) {
            e.KellE((Nyersanyag) nyersanyagRakter.get(i));
        }
        boolean epitheto = e.EpithetoE();

        int res1 = SkeletonController.AskForInput("epitheto?", new ArrayList<String>() {{
            add("igen");
            add("nem");
        }});
        switch (res1) {
            case 0:
                System.out.println("kilepes");
                return;
            case 1:
                System.out.println("epitheto");
                break;
            case 2:
                System.out.println("nem epitheto");
                break;
            default:
                System.out.println("Rossz bemenet");
                break;
        }
        if (res1 == 1) {        // epitheto
            e.Letrejon(aszteroida);
        }
        SkeletonController.FunctionReturn();
    }

    /**
     * A telpeortkapuk epiteset vegzo fuggveny.
     * @param e A megfelelo epitheto objektum, amely a nyersanyagokat ellenorzi es tenylegesen letrehozza majd a teleportkapukat.
     */
    public void TeleportEpit(Epitheto e) {
        SkeletonController.FunctionCall(new Object() {
        }.getClass().getEnclosingMethod().getName(), this);
        for (int i = 0; i < nyersanyagRakter.size(); i++) {
            e.KellE((Nyersanyag) nyersanyagRakter.get(i));
        }
        boolean epitheto = e.EpithetoE();

        int res1 = SkeletonController.AskForInput("epitheto?", new ArrayList<String>() {{
            add("igen");
            add("nem");
        }});
        switch (res1) {
            case 0:
                System.out.println("kilepes");
                return;
            case 1:
                System.out.println("epitheto");
                break;
            case 2:
                System.out.println("nem epitheto");
                break;
            default:
                System.out.println("Rossz bemenet");
                break;
        }
        int res2 = SkeletonController.AskForInput("Van hely a rakterben?", new ArrayList<>() {{
            add("igen");
            add("nem");
        }});
        switch (res2) {
            case 0:
                System.out.println("kilepes");
                return;
            case 1:
                System.out.println("van hely");
                break;
            case 2:
                System.out.println("nincs hely");
                break;
            default:
                System.out.println("Rossz bemenet");
                break;
        }
        if (res1 == 1 && res2 == 1) {        // epitheto es van hely a rakterben
            List<Szallithato> ujak = e.Letrejon(aszteroida);
            teleportkapuRakter.add(ujak.get(0));
            teleportkapuRakter.add(ujak.get(1));
        }
        SkeletonController.FunctionReturn();
    }

    public void KapuLerak(Teleportkapu k) {


    }

    /**
     * Telepest napvihar eri.
     */
    @Override
    public void Napvihar() {
        SkeletonController.FunctionCall(new Object() {
        }.getClass().getEnclosingMethod().getName(), this);

        this.Meghal();

        SkeletonController.FunctionReturn();
    }

    /**
     * Telepes meghal.
     */
    @Override
    public void Meghal() {
        SkeletonController.FunctionCall(new Object() {
        }.getClass().getEnclosingMethod().getName(), this);
        aszteroida.HajoElhagy(this);
        //palya.removeAIVezerli(this);
        List<Szallithato> temp_nyersanyagRakter = new ArrayList<>(nyersanyagRakter);
        List<Szallithato> temp_teleportkapuRakter = new ArrayList<>(teleportkapuRakter);

        for (Szallithato szallithato : temp_nyersanyagRakter) szallithato.Megsemmisul();
        for (Szallithato szallithato : temp_teleportkapuRakter) szallithato.Megsemmisul();
        SkeletonController.FunctionReturn();
    }

    @Override
    public void Robbanas() {
        SkeletonController.FunctionCall(new Object() {
        }.getClass().getEnclosingMethod().getName(), this);
        Meghal();
        SkeletonController.FunctionReturn();
    }

    @Override
    void Lepes() {
        // TODO Auto-generated method stub
    }

    @Override
    boolean NyerEllenoriz(Epitheto e) {
        // TODO Auto-generated method stub
        return false;
    }


    void AnyagVisszatesz(Nyersanyag n) {
        aszteroida.AddMag(n);

    }

    void AddRakter(Nyersanyag n) {
        //rakter.add(n);
    }

    void Banyasz() {
        Nyersanyag n = aszteroida.Kinyer();
        if (n != null && nyersanyagRakter.size() < 9) {
            //Rakter.AddRakter(n);
        }

    }


}