package Grafikus;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class SkeletonController {

	static int depth = 0;
	static HashMap<String, String> NamesMap = new HashMap<>();
	
    
    /**
     * Minden fuggvenyhivas elejen hivjuk, a megfelelo behuzassal kiirja a fuggveny nevet
     * 
     *@param calledFunctionName - a meghivott fuggveny neve
     *@param calledObject - az objektum amin a fuggvenyt meghivtuk
     */
    public static void FunctionCall(String calledFunctionName, Object calledObject) {
    	for(int i = 0; i< depth;i++)
    		System.out.print("\t");
    	
    	if(NamesMap.containsKey(calledObject.toString()))
    		System.out.print("-> " + NamesMap.get(calledObject.toString()));
    	
    	//email alapj�n �gy d�nt�tt�nk most nem gond ha az inicializ�l�s alatt nem mindennek tudjuk kiirni a nev�t
    	else System.out.print("-> most letrejott " + calledObject.getClass().getSimpleName());
    	
        System.out.print("." + calledFunctionName+ "()\n");
        depth++;
    }
    
    
    /**
     * Ha a felhasznalotol visszajelzest kerunk, akkor hivjuk meg
     * 
     *@param kerdes - a helhasznalonak feltett kerdes
     *@param choices - a kerdesre adhato valaszok listaja
     */
    public static int AskForInput(String kerdes, ArrayList<String> choices) {
    	for(int i = 0; i< depth;i++)
    		System.out.print("\t");
    	System.out.println(kerdes);
    	
    	for(int i = 0; i< depth;i++)
    		System.out.print("\t");
    	System.out.print(0 + ". kilepes,   ");
    	for (int i = 0; i< choices.size();i++)
			System.out.print(i+1 + ". " + choices.get(i) + ",  ");
   
    	System.out.print("Valasz: ");
    	
    	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    	int chosen = -1;
    	try {
            String line = reader.readLine();
            chosen = Integer.parseInt(String.valueOf(line));
        } catch (Exception e) {
            System.out.println(e.getMessage());
		}
    	if(chosen > choices.size()+1 || chosen <= 0 )
    		throw new RuntimeException("Kilepes");
    	
    	for(int i = 0; i< depth;i++)
    		System.out.print("\t");
    	
    	return chosen; 
    }
    
    
    /**
     * Minden fuggvenyhivas vegen hivjuk, a behuzas merteket korrigalja
     * 
     */
    public static void FunctionReturn() {
    	depth--;
    }

    /**
     * Minden konstruktor meghivja, kiirja a kepernyore milyen objektum jott letre
     * 
     */
    public static void ObjectCreated(Object obj) {
        System.out.println("Created: " + obj.getClass().getSimpleName());
    }

    /**
     * Kilep a programbol
     * 
     */
    public static void Kilepes() {
        System.out.println("Bye(t)!");
        System.exit(0);
    }

    
    public static void TelepesTeleport() {
    	Aszteroida a =  new Aszteroida();
    	NamesMap.put(a.toString(), "a");
    	
    	Telepes t = new Telepes(a);
    	NamesMap.put(t.toString(), "t");
    	Teleportkapu k = new Teleportkapu();
    	NamesMap.put(k.toString(), "k");
    	
    	t.AddRakter(k);
    	t.KapuLerak(k);
    	
    }
    
    
    public static void TelepesMozogSzomszedosAszteroidara() {

    	//Inicializalas
    	
    	//Nev regisztracio es inicializalas
    	Aszteroida jelenlegi =  new Aszteroida(); 
    	//Mikor letrehozunk valamit, rogton el is nevezzuk
    	NamesMap.put(jelenlegi.toString(), "jelenlegi");
    	
    	Aszteroida uj = new Aszteroida();
    	NamesMap.put(uj.toString(), "uj");
    	Telepes t = new Telepes(jelenlegi);
    	NamesMap.put(t.toString(), "t");
    	
    	jelenlegi.AddSzomszed(uj);
    	uj.AddSzomszed(jelenlegi);
    	
    	
    	//Kezd�hiv�s
    	t.Mozog(uj);
    }
    
    public static void RobotMozogSzomszedosAszteroidara() {
    	
    	//Inicializ�l�s
    	
    	//N�v regisztr�ci� �s inicializ�l�s
    	Aszteroida jelenlegi =  new Aszteroida(); 
    	//Mikor letrehozunk valamit, rogton el is nevezzuk
    	NamesMap.put(jelenlegi.toString(), "jelenlegi");
    	
    	Aszteroida uj = new Aszteroida();
    	NamesMap.put(uj.toString(), "uj");
    	Robot t = new Robot(jelenlegi);
    	NamesMap.put(t.toString(), "t");
    	
    	jelenlegi.AddSzomszed(uj);
    	uj.AddSzomszed(jelenlegi);
    	
    	
    	//Kezd�hiv�s
    	t.Mozog(uj);
    }

	public static void TelepesBanyaszikVasat() {


		Aszteroida a =  new Aszteroida();
		NamesMap.put(a.toString(), "a");
		
		Telepes t = new Telepes(a);
		NamesMap.put(t.toString(), "t");

		Vas vas = new Vas();
		NamesMap.put(vas.toString(), "vas");

		a.SetMag(vas);

		//Kezdohivas
		t.Banyasz();
	}

	public static void TelepesBanyaszikSzenet() {


		Aszteroida a =  new Aszteroida();
		NamesMap.put(a.toString(), "a");
		
		Telepes t = new Telepes(a);
		NamesMap.put(t.toString(), "t");


		Szen szen = new Szen();
		NamesMap.put(szen.toString(), "szen");

		a.SetMag(szen);

		//Kezdohivas
		t.Banyasz();
	}

	public static void TelepesBanyaszikUrant() {


		Aszteroida a =  new Aszteroida();
		NamesMap.put(a.toString(), "a");

		Telepes t = new Telepes(a);
		NamesMap.put(t.toString(), "t");

		Uran uran = new Uran();
		NamesMap.put(uran.toString(), "uran");

		a.SetMag(uran);

		//Kezdohivas
		t.Banyasz();
	}

	public static void TelepesBanyaszikVizjeget() {


		Aszteroida a =  new Aszteroida();
		NamesMap.put(a.toString(), "a");

		Telepes t = new Telepes(a);
		NamesMap.put(t.toString(), "t");

		Vizjeg vizjeg= new Vizjeg();
		NamesMap.put(vizjeg.toString(), "vizjeg");

		a.SetMag(vizjeg);

		//Kezdohivas
		t.Banyasz();
	}

	public static void TelepesLerakVizjeget() {


		Aszteroida a =  new Aszteroida();
		NamesMap.put(a.toString(), "a");

		Vizjeg vizjeg= new Vizjeg();
		NamesMap.put(vizjeg.toString(), "vizjeg");

		Telepes t = new Telepes(a);
		NamesMap.put(t.toString(), "t");

		t.AddRakter(vizjeg);


		//Kezdohivas
		t.AnyagVisszatesz(vizjeg);
	}

	public static void TelepesLerakVasat() {


		Aszteroida a =  new Aszteroida();
		NamesMap.put(a.toString(), "a");

		Vas vas= new Vas();
		NamesMap.put(vas.toString(), "vas");

		Telepes t = new Telepes(a);
		NamesMap.put(t.toString(), "t");

		t.AddRakter(vas);


		//Kezdohivas
		t.AnyagVisszatesz(vas);
	}
	public static void TelepesLerakSzenet() {


		Aszteroida a =  new Aszteroida();
		NamesMap.put(a.toString(), "a");

		Szen szen= new Szen();
		NamesMap.put(szen.toString(), "szen");

		Telepes t = new Telepes(a);
		NamesMap.put(t.toString(), "t");

		t.AddRakter(szen);


		//Kezdohivas
		t.AnyagVisszatesz(szen);
	}
	public static void TelepesLerakUrant() {


		Aszteroida a =  new Aszteroida();
		NamesMap.put(a.toString(), "a");
		Aszteroida a1 =  new Aszteroida();
		NamesMap.put(a1.toString(), "a1");
		Aszteroida szomsz1 =  new Aszteroida();
		NamesMap.put(szomsz1.toString(), "szomsz1");

		a.AddSzomszed(szomsz1);
    		szomsz1.AddSzomszed(a);

		Robot r = new Robot(a);
		NamesMap.put(r.toString(), "r");

		Uran uran= new Uran();
		NamesMap.put(uran.toString(), "uran");

		Telepes t = new Telepes(a);
		NamesMap.put(t.toString(), "t");

		Teleportkapu szomsz2 = new Teleportkapu();
    		NamesMap.put(szomsz2.toString(), "szomsz2");
		Teleportkapu par = new Teleportkapu();
    		NamesMap.put(par.toString(), "par");
	
		szomsz2.SetPar(par);
    		szomsz2.SetSajatAszteroida(a);
    		par.SetPar(szomsz2);
   	 	par.SetSajatAszteroida(a1);
    		



		t.AddRakter(uran);


		//Kezdohivas
		t.AnyagVisszatesz(uran);
	}



    /**
     * A telepes Tetlen() fuggvenyet hivja meg.
     * 
     */
    public static void TelepesTetlen() {
    	Telepes t = new Telepes();
    	NamesMap.put(t.toString(), "t");
    	t.Tetlen();
    	NamesMap.clear();
    }
    
    public static void TelepesMozogTeleport() {
    	Aszteroida a =  new Aszteroida();
    	NamesMap.put(a.toString(), "a");
    	Aszteroida a2 = new Aszteroida();
    	NamesMap.put(a2.toString(), "a2");
    	Telepes t = new Telepes(a);
    	NamesMap.put(t.toString(), "t");
    	Teleportkapu tp = new Teleportkapu();
    	NamesMap.put(tp.toString(), "tp");
    	Teleportkapu par = new Teleportkapu();
    	NamesMap.put(par.toString(), "par");
    	tp.SetPar(par);
    	tp.SetSajatAszteroida(a);
    	par.SetPar(tp);
    	par.SetSajatAszteroida(a2);
    	
    	t.Mozog(tp);
    	NamesMap.clear();
    }
    public static void RobotMozogTeleport() {
    	Aszteroida a =  new Aszteroida();
    	NamesMap.put(a.toString(), "a");
    	Aszteroida a2 = new Aszteroida();
    	NamesMap.put(a2.toString(), "a2");
    	Robot r = new Robot(a);
    	NamesMap.put(r.toString(), "r");
    	Teleportkapu tp = new Teleportkapu();
    	NamesMap.put(tp.toString(), "tp");
    	Teleportkapu par = new Teleportkapu();
    	NamesMap.put(par.toString(), "par");
    	tp.SetPar(par);
    	tp.SetSajatAszteroida(a);
    	par.SetPar(tp);
    	par.SetSajatAszteroida(a2);
    	
    	r.Mozog(tp);
    	NamesMap.clear();
    }

    
    /**Telepes fur vasat*/
    public static void TelepesFurVasat() {
    	//Inicializalas
    	Aszteroida a = new Aszteroida();
    	NamesMap.put(a.toString(), "a");
    	Telepes t = new Telepes(a);
    	NamesMap.put(t.toString(), "t");
    	Vas vas = new Vas();
    	NamesMap.put(vas.toString(), "vas");
    	
    	a.SetMag(vas);
    	
    	//Kezdo hivas
    	t.Fur();
    }
    
    /**Telepes fur szenet*/
    public static void TelepesFurSzenet() {
    	//Inicializalas
    	Aszteroida a = new Aszteroida();
    	NamesMap.put(a.toString(), "a");
    	Telepes t = new Telepes(a);
    	NamesMap.put(t.toString(), "t");
    	Szen sz = new Szen();
    	NamesMap.put(sz.toString(), "sz");
    	
    	a.SetMag(sz);
    	
    	//Kezdo hivas
    	t.Fur();
    }
    
    /**Telepes fur vizjeget*/
    public static void TelepesFurVizjeget() {
    	//Inicializalas
    	Aszteroida a = new Aszteroida();
    	NamesMap.put(a.toString(), "a");
    	Telepes t = new Telepes(a);
    	NamesMap.put(t.toString(), "t");
    	Vizjeg v= new Vizjeg();
    	NamesMap.put(v.toString(), "v");
    	
    	a.SetMag(v);
    	
    	//Kezdo hivas
    	t.Fur();
    }
    
    /**Telepes fur urant*/
    public static void TelepesFurUrant() {
    	//Inicializalas
    	Aszteroida a = new Aszteroida();
    	NamesMap.put(a.toString(), "a");
    	Telepes t = new Telepes(a);
    	NamesMap.put(t.toString(), "t");
    	Robot r = new Robot(a);
    	NamesMap.put(r.toString(), "r");
    	Uran u = new Uran();
    	NamesMap.put(u.toString(), "u");
    	a.SetMag(u);
    	
    	Aszteroida szomsz1 = new Aszteroida();
    	NamesMap.put(szomsz1.toString(), "szomsz1");
    	a.AddSzomszed(szomsz1);
    	szomsz1.AddSzomszed(a);
    	
    	Teleportkapu szomsz2 = new Teleportkapu();
    	NamesMap.put(szomsz2.toString(), "szomsz2");
    	
    	szomsz2.SetSajatAszteroida(a);
   
    	Teleportkapu par = new Teleportkapu();
    	NamesMap.put(par.toString(), "par");
    	szomsz2.SetPar(par);
    	par.SetPar(szomsz2);
    	
    	Aszteroida a2 = new Aszteroida();
    	NamesMap.put(a2.toString(), "a2");
    	
    	//diagramban elirva
    	par.SetSajatAszteroida(a2);
    	
    	//Kezdo hivas
    	t.Fur();
    }
    
    /**Robot fur vasat*/
    public static void RobotFurVasat() {
    	//Inicializalas
    	Aszteroida a = new Aszteroida();
    	NamesMap.put(a.toString(), "a");
    	Robot r = new Robot(a);
    	NamesMap.put(r.toString(), "r");
    	Vas vas = new Vas();
    	NamesMap.put(vas.toString(), "vas");
    	
    	a.SetMag(vas);
    	
    	//Kezdo hivas
    	r.Fur();
    }
    
    /**Robot fur szenet*/
    public static void RobotFurSzenet() {
    	//Inicializalas
    	Aszteroida a = new Aszteroida();
    	NamesMap.put(a.toString(), "a");
    	Robot r = new Robot(a);
    	NamesMap.put(r.toString(), "r");
    	Szen sz = new Szen();
    	NamesMap.put(sz.toString(), "sz");
    	
    	a.SetMag(sz);
    	
    	//Kezdo hivas
    	r.Fur();
    }
    
    /**Robot fur vizjeget*/
    public static void RobotFurVizjeget() {
    	//Inicializalas
    	Aszteroida a = new Aszteroida();
    	NamesMap.put(a.toString(), "a");
    	Robot r = new Robot(a);
    	NamesMap.put(r.toString(), "r");
    	Vizjeg v= new Vizjeg();
    	NamesMap.put(v.toString(), "v");
    	
    	a.SetMag(v);
    	
    	//Kezdo hivas
    	r.Fur();
    }
    
    /**Robot fur urant*/
    public static void RobotFurUrant() {
    	//Inicializalas
    	Aszteroida a = new Aszteroida();
    	NamesMap.put(a.toString(), "a");
    	Telepes t = new Telepes(a);
    	NamesMap.put(t.toString(), "t");
    	Robot r = new Robot(a);
    	NamesMap.put(r.toString(), "r");
    	Uran u = new Uran();
    	NamesMap.put(u.toString(), "u");
    	a.SetMag(u);
    	
    	Aszteroida szomsz1 = new Aszteroida();
    	NamesMap.put(szomsz1.toString(), "szomsz1");
    	a.AddSzomszed(szomsz1);
    	szomsz1.AddSzomszed(a);
    	
    	Teleportkapu szomsz2 = new Teleportkapu();
    	NamesMap.put(szomsz2.toString(), "szomsz2");
    	
    	szomsz2.SetSajatAszteroida(a);
    	
    	Teleportkapu par = new Teleportkapu();
    	NamesMap.put(par.toString(), "par");
    	szomsz2.SetPar(par);
    	par.SetPar(szomsz2);
    	
    	Aszteroida a2 = new Aszteroida();
    	NamesMap.put(a2.toString(), "a2");
    	
    	//diagramban elirva
    	par.SetSajatAszteroida(a2);
    	
    	
    	//Kezdo hivas
    	r.Fur();
    }
    
    /**telepes meghal, egy teleportkapu par van nala*/
    public static void TelepesMeghalKapupar() {
    	//inicializalas
    	Aszteroida a = new Aszteroida();
    	NamesMap.put(a.toString(), "a");
    	Telepes t = new Telepes(a);
    	NamesMap.put(t.toString(), "t");
    	Vas v = new Vas();
    	NamesMap.put(v.toString(), "v");
    	t.SetNyersanyagRakter(v);
    	
    	Teleportkapu tp = new Teleportkapu();
    	NamesMap.put(tp.toString(), "tp");
    	Teleportkapu par = new Teleportkapu();
    	NamesMap.put(par.toString(), "par");
    	tp.SetPar(par);
    	par.SetPar(tp);
    	t.SetTeleportkapuRakter(tp);
    	t.SetTeleportkapuRakter(par);
    	
    	//Kezdo hivas
    	t.Meghal();   	
    }
    
    /**telepes meghal, csak a kapupar fele van nala*/
    public static void TelepesMeghalKapuKulon() {
    	//inicializalas
    	Aszteroida a = new Aszteroida();
    	NamesMap.put(a.toString(), "a");
    	Telepes t = new Telepes(a);
    	NamesMap.put(t.toString(), "t");
    	Vas v = new Vas();
    	NamesMap.put(v.toString(), "v");
    	t.SetNyersanyagRakter(v);
    	
    	Teleportkapu tp = new Teleportkapu();
    	NamesMap.put(tp.toString(), "tp");
    	Teleportkapu par = new Teleportkapu();
    	NamesMap.put(par.toString(), "par");
    	tp.SetPar(par);
    	par.SetPar(tp);
    	t.SetTeleportkapuRakter(tp);
    	
    	Aszteroida a2 = new Aszteroida();
    	NamesMap.put(a2.toString(), "a2");
    	par.SetSajatAszteroida(a2);
    	
    	
    	//Kezdo hivas
    	t.Meghal();   	
    }
    public static void TelepesTeleportkaputEpit() {
    	Telepes t = new Telepes();
    	NamesMap.put(t.toString(), "t");
    	TeleportEpito e = new TeleportEpito();
    	NamesMap.put(e.toString(), "e");
    	Vas v = new Vas();
    	NamesMap.put(v.toString(), "v");
    	t.SetNyersanyagRakter(v);
    	
    	t.TeleportEpit(e);
    	NamesMap.clear();
    }
    public static void TelepesRobototEpit() {
    	Aszteroida a = new Aszteroida();
    	NamesMap.put(a.toString(), "a");
    	Telepes t = new Telepes(a);
    	NamesMap.put(t.toString(), "t");
    	RobotEpito e = new RobotEpito();
    	NamesMap.put(e.toString(), "e");
    	Vas v = new Vas();
    	NamesMap.put(v.toString(), "v");
    	t.SetNyersanyagRakter(v);
    	
    	t.RobotEpit(e);
    	NamesMap.clear();
    }

	public static void NapviharAszteroidaraTelepesre() {
    	Aszteroida a = new Aszteroida();
    	NamesMap.put(a.toString(),"a");
		Telepes t = new Telepes(a);
		NamesMap.put(t.toString(), "t");

		a.Napvihar();


		NamesMap.clear();
	}
	public static void NapviharAszteroidaraRobotra() {
		Aszteroida a = new Aszteroida();
		NamesMap.put(a.toString(),"a");
		Robot r = new Robot(a);
		NamesMap.put(r.toString(), "r");

		a.Napvihar();

		NamesMap.clear();
	}
}