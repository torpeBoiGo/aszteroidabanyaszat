package Grafikus;

import java.util.*;

/**
 * A telepest megvalosito osztaly.
 */
public class Telepes extends Hajo implements Leptetheto {

    /**
     * a nyersanyagokat tarolo Rakter
     */
    private List<Szallithato> nyersanyagRakter = new ArrayList<>();

    /**
     * a teleportkapukat tarolo Rakter
     */
    private List<Szallithato> teleportkapuRakter = new ArrayList<>();

    /**
     * A telepes konstruktora, amely beallitja a sajat aszteroidajat, es hozzaadja a parameterul kapott aszteroidan tartozkodo hajokhoz a telepest,
     * valamint hozzaadja a palyan tarolt jatekosVezerli objektumokhoz.
     *
     * @param a Az az aszteroida, ahova a telepes letrejottenek pillanataban kerul.
     */
    public Telepes(Aszteroida a) {
        a.HajoErkezik(this);
        aszteroida = a;
        Palya.AddJatekosVezerli(this);
    }

    /**
     * A telepes konstruktora, a sajat aszteroida erteket nullra allitja, valamint  hozzaadja  a palyan tarolt Jatekos vezerelt objektumokhoz.
     */
    public Telepes() {
        aszteroida = null;
        Palya.AddJatekosVezerli(this);
    }

    /**
     * A telepesfurast  vegez  az  aszteroidan,  amin  tartozkodik. Ha a muvelet sikertelen a telepes tetlen marad.
     */
    public void Fur() {
        aszteroida.Fur();
    }

    /**
     * A telepes nyersanyagRakter listjehez ad hozza egy uj elemet.
     *
     * @param n a nyersanyag
     */
    public void SetNyersanyagRakter(Nyersanyag n) {
        nyersanyagRakter.add(n);
    }

    /**
     * A telepes teleportkapuRakter listjehez ad hozza egy uj elemet.
     *
     * @param t a teleportkapu
     */
    public void SetTeleportkapuRakter(Teleportkapu t) {
        teleportkapuRakter.add(t);
    }

    /**
     *   Telepes  robotepites  hivas  eseten  torteno viselkedeset  valositja  meg.  
     *   Ezutan  ez  a  fuggveny  kezeli  az  es  felugyeli  a  robot epitesenek  teljes  folyamatat.
     *   Parameterkent  egy  RobotEpito  objektumot  kap,  ami tartalmazza,  hogy  milyen  nyersanyagok  szuksegesek  a  robot  epiteshez,  
     *   valamint  a robot epitesere metodust.A robotot a telepes az aszteroidajan helyezi el. Ha a muvelet sikertelen a telepes tetlen marad
     *
     * @param e A megfelelo epitheto objektum, amely a nyersanyagokat ellenorzi es tenylegesen letrehozza majd a robotot.
     */
    public void RobotEpit(Epitheto e) {
    	List<Szallithato> consumed = new ArrayList<>();
        for (Szallithato szallithato : nyersanyagRakter) {
        	if(e.KellE((Nyersanyag) szallithato)) { 
        		consumed.add(szallithato); 
        	}
        }

        boolean epitheto = e.EpithetoE();
        
        if(epitheto) {
        	e.Letrejon(aszteroida);
        	
        	for (Szallithato szallithato : consumed) {
				szallithato.Megsemmisul();
			}
        	nyersanyagRakter.removeAll(consumed);
        }
        e.Reset();
    }

    /**
     * A  Telepes  teleportkapu  epites  hivas  eseten torteno  viselkedeset  valositja  meg.  
     * Ezutan  ez  a  fuggveny  kezeli  az  es  felugyeli  a teleportkapu    epitesenek    teljes    folyamatat.    
     * Parameterkent    egy    TeleportEpito objektumot  kap,  ami  tartalmazza,  hogy  milyen  nyersanyagok  szuksegesek  a kapupar epiteshez,  
     * valamint  a kapupar epitesere  metodust.A  teleportkapu  part  csak,  akkor lehet megepiteni,
     * ha van eleg hely a telepes raktereben, mindket kapunak. epites utan a kapupar a telepes rakterebe kerul. Ha a muvelet sikertelen a telepes tetlen marad
     *
     * @param e A megfelelo epitheto objektum, amely a nyersanyagokat ellenorzi es tenylegesen letrehozza majd a teleportkapukat.
     */
    public void TeleportEpit(Epitheto e) {
    	List<Szallithato> consumed = new ArrayList<>();
        for (Szallithato szallithato : nyersanyagRakter) {
        	if(e.KellE((Nyersanyag) szallithato)) { 
        		consumed.add(szallithato); 
        	}
        }

        boolean epitheto = e.EpithetoE();
        
        if(epitheto && teleportkapuRakter.size() < 2) {
        	Vector<Szallithato> epitett;
        	epitett = e.Letrejon(aszteroida);
            teleportkapuRakter.addAll(epitett);
        	
        	for (Szallithato szallithato : consumed) {
				szallithato.Megsemmisul();
			}
        	nyersanyagRakter.removeAll(consumed);
        }
        e.Reset();
    }

    /**
     * A   lehelyezi   a   jelenlegi   Aszteroidara   a parameterkent kapott kaput, valamint eltavolitja azt a telepes rakterebol
     */
    public void KapuLerak(Teleportkapu k) {
    	teleportkapuRakter.remove(k);
        k.SetSajatAszteroida(aszteroida);
    }

    /**
     * Telepest napvihar eri.
     */
    @Override
    public void Napvihar() {
        this.Meghal();
    }

    /**
     * A telepesviselkedeset  irja  le,  ha  meghal.  Eltavolitja  a telepestaz aszteroidajarol,a palyan  tarolt Jatekosvezerelelt objektumok kozul,  
     * valamint  a kiirashoz  hasznalt hasmaprol. Emellett  a  telepes  raktereben  levo  osszes szallithato objektum (nyersanyag, teleportkapu) megsemmisul.
     */
    @Override
    public void Meghal() {
        aszteroida.HajoElhagy(this);
        Palya.removeAIVezerli(this);
        List<Szallithato> temp_nyersanyagRakter = new ArrayList<>(nyersanyagRakter);
        List<Szallithato> temp_teleportkapuRakter = new ArrayList<>(teleportkapuRakter);

        for (Szallithato szallithato : temp_nyersanyagRakter) {
            szallithato.Megsemmisul();
            MainGUI.NamesMap.remove(MainGUI.getKeyByValue(MainGUI.NamesMap, szallithato));
        }
        for (Szallithato szallithato : temp_teleportkapuRakter) {
            szallithato.Megsemmisul();
            MainGUI.NamesMap.remove(MainGUI.getKeyByValue(MainGUI.NamesMap, szallithato));
        }
        nyersanyagRakter = null;
        teleportkapuRakter = null;
        
        Palya.RemoveJatekosVezerli(this);
        MainGUI.NamesMap.remove(MainGUI.getKeyByValue(MainGUI.NamesMap, this));
    }

    /**
     * A telepes felrobban.
     */
    @Override
    public void Robbanas() {
        Meghal();
    }


    /**
     * A telepes lep egyet
     */
    @Override
    public void Lepes() {


        String telepes= MainGUI.getKeyByValue(MainGUI.NamesMap,this);
        System.out.println("Mit szeretne tenni a "+ telepes+" telepessel?");



           String  line = Reader.sc.nextLine();
        String[] cmd = line.split(" ");
        if ("telepes".equals(cmd[0]) ||"hajo".equals(cmd[0])) {
            if ("robotEpit".equals(cmd[1])) {
                this.RobotEpit(new RobotEpito());
            } else if ("teleportEpit".equals(cmd[1])) {
                this.TeleportEpit(new TeleportEpito());
            } else if ("anyagVisszatesz".equals(cmd[1])) {
                Nyersanyag nyersanyag = (Nyersanyag) MainGUI.NamesMap.get(cmd[3]);
                this.AnyagVisszatesz(nyersanyag);
            } else if ("fur".equals(cmd[1])) {
                this.Fur();
            } else if ("banyasz".equals(cmd[1])) {
                this.Banyasz();
            } else if ("kapuLerak".equals(cmd[1])) {
                this.KapuLerak((Teleportkapu) MainGUI.NamesMap.get(cmd[2]));
            } else if ("mozog".equals(cmd[1])) {
                Mezo mezo = (Mezo) MainGUI.NamesMap.get(cmd[3]);
                this.Mozog(mezo);
            } else if ("tetlen".equals(cmd[1])) {
                this.Tetlen();
            }else{
                System.out.println("Helytelen bemenet - "+telepes+" tetelen");
            }

    }else{
            System.out.println("Helytelen bemenet - "+telepes+" tetelen");
        }
    }

    /**
     * Ellenorzi,hogy  a  telepes  mivel  jarulhat  hozza  a gyozelemhez,  vagy  a  megnyerhetoseghez  a  parameter  szerint. 
     * Parameterkent  vagy Gyozelem vagy Nyerheto objektumot kap.
     *
     * @param e -amit vizsgalunk
     */
    @Override
    void NyerEllenoriz(Epitheto e) {
        for (Szallithato ny :nyersanyagRakter){
            e.KellE((Nyersanyag) ny);
        }
    }


    /**
     * A   telepes   nyersanyag   lerakas   lepeset valositja meg. 
     * Ha el lehet helyezni a parameterkent kapott nyersanyagot az aszteroida magjaban(sikeres  az  addMag()  muvelet), 
     * akkor a  nyersanyag  eltunik  a  telepes rakterebol,  az  aszteroida  magjaba  kerul.  Ha  a  muvelet  sikertelen  a  telepes  tetlen marad.
     *
     * @param n - a nyersanyag ami visszateszunk
     */
    void AnyagVisszatesz(Nyersanyag n) {
    	boolean sikerult = aszteroida.AddMag(n);
    	if (sikerult) nyersanyagRakter.remove(n);
    }

    /**
     * A nyersanyagrakterhez hozzaadjuk az adott szallithatot
     *
     * @param n - az elem amit hozzaadunk
     */
    void addNyersanyagRakter(Szallithato n) {
        nyersanyagRakter.add(n);
    }

    /**
     * A  telepes  banyaszas  lepeset  valositja  meg.  Ha  van  hely  a  telepes raktereben,  valamint  az  aszteroida  magjanak  kinyerese  sikeres,  
     * akkor  a nyersanyagot hozzaadja a telepes rakterehez es eltavolitja az aszteroida magjabol. Ha a muvelet sikertelen a telepes tetlen marad.
     */
    void Banyasz() {
        Nyersanyag n = aszteroida.Kinyer();
        if(nyersanyagRakter.size()>9)
            return;
        if(n!=null)
        addNyersanyagRakter(n);
    }

    public List<Szallithato> getRakterek(){
        List<Szallithato> ossz = new ArrayList<>();
        ossz.addAll(nyersanyagRakter);
        ossz.addAll(teleportkapuRakter);
        return ossz;
    }

    /**
     * Visszater  a telepestulajdonsagait(az  aszteroidaja,  rakterei) tartalmazo stringgel a kimeneti nyelvnek megfelelo formatumban.
     */
    public String toString() {
        System.out.println("Aszteroida: " + MainGUI.getKeyByValue(MainGUI.NamesMap, aszteroida) + ": Aszteroida");
        System.out.print("NyersanyagRakter: ");
        StringJoiner lineJoiner = new StringJoiner(",");
        for (Szallithato szallithato : nyersanyagRakter) {
            lineJoiner.add(MainGUI.getKeyByValue(MainGUI.NamesMap, szallithato) + ": " + szallithato.getClass().getSimpleName());
        }
        System.out.println(lineJoiner + ":Nyersanyag[0..10]");
        lineJoiner = new StringJoiner(",");
        System.out.print("TeleportkapuRakter: ");
        for (Szallithato tpkapu : teleportkapuRakter) {
            lineJoiner.add(MainGUI.getKeyByValue(MainGUI.NamesMap, tpkapu) + ": " + tpkapu.getClass().getSimpleName());
        }
        return lineJoiner + ":Teleportkapu[0..3]\n";
    }
}