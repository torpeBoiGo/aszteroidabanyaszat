
package Skeleton;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class SkeletonController {

	static int depth = 0;
	static HashMap<String, String> NamesMap = new HashMap<String, String>();
	
    public static void FunctionCall(Object called, String calledFunctionName) {
    	for(int i = 0; i< depth;i++)
    		System.out.print("\t");

        System.out.print("-> " + called.toString() + "." + calledFunctionName+ "\n");
        depth++;
    }
    
    public static void FunctionCall(String calledFunctionName, Object callerObject) {
    	for(int i = 0; i< depth;i++)
    		System.out.print("\t");
    	
    	if(NamesMap.containsKey(callerObject.toString()))
    		System.out.print("-> " + NamesMap.get(callerObject.toString()));
    	else System.out.print("-> most letrejott " + callerObject.getClass().getSimpleName());
    	
        System.out.print("." + calledFunctionName+ "()\n");
        depth++;
    }
    
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
            chosen = -1;
        }
    	if(chosen > choices.size()+1 || chosen <= 0 )
    		throw new RuntimeException();
    	
    	for(int i = 0; i< depth;i++)
    		System.out.print("\t");
    	
    	return chosen; 
    }
    
    public static void FunctionReturn() {
    	depth--;
    }

    public static void ObjectCreated(Object obj) {
        System.out.println("Created: " + obj.getClass().getSimpleName());
    }

    public static void Kilepes() {
        System.out.println("Bye(t)!");
        System.exit(0);
    }

    
    public static void TelepesMozogSzomszedosAszteroidara() {
    	// A számozás rossz a diagramunkon (5.4.4)
    	
    	//Inicializálás
    	
    	//Név regisztráció és inicializálás
    	Aszteroida jelenlegi =  new Aszteroida(); 
    	//Mikor letrehozunk valamit, rogton el is nevezzuk
    	NamesMap.put(jelenlegi.toString(), "jelenlegi");
    	
    	Aszteroida uj = new Aszteroida();
    	NamesMap.put(uj.toString(), "uj");
    	Telepes t = new Telepes(jelenlegi);
    	NamesMap.put(t.toString(), "t");
    	
    	jelenlegi.AddSzomszed(uj);
    	uj.AddSzomszed(jelenlegi);
    	
    	
    	//Kezdõhivás
    	t.Mozog(uj);
    }
    
    public static void RobotMozogSzomszedosAszteroidara() {
    	// A számozás rossz a diagramunkon (5.4.4)
    	
    	//Inicializálás
    	
    	//Név regisztráció és inicializálás
    	Aszteroida jelenlegi =  new Aszteroida(); 
    	//Mikor letrehozunk valamit, rogton el is nevezzuk
    	NamesMap.put(jelenlegi.toString(), "jelenlegi");
    	
    	Aszteroida uj = new Aszteroida();
    	NamesMap.put(uj.toString(), "uj");
    	Robot t = new Robot(jelenlegi);
    	NamesMap.put(t.toString(), "t");
    	
    	jelenlegi.AddSzomszed(uj);
    	uj.AddSzomszed(jelenlegi);
    	
    	
    	//Kezdõhivás
    	t.Mozog(uj);
    }
    
    /**Telepes fúr vasat*/
    public static void TelepesFurVasat() {
    	depth=0;
    	//Inicializalas
    	Aszteroida a = new Aszteroida();
    	NamesMap.put(a.toString(), "a");
    	Telepes t = new Telepes(a);
    	NamesMap.put(t.toString(), "t");
    	Vas vas = new Vas();
    	NamesMap.put(vas.toString(), "vas");
    	
    	a.AddMag(vas);
    	
    	//Kezdo hivas
    	t.Fur();
    }
    
    /**Telepes fúr szenet*/
    public static void TelepesFurSzenet() {
    	depth=0;
    	//Inicializalas
    	Aszteroida a = new Aszteroida();
    	NamesMap.put(a.toString(), "a");
    	Telepes t = new Telepes(a);
    	NamesMap.put(t.toString(), "t");
    	Szen sz = new Szen();
    	NamesMap.put(sz.toString(), "sz");
    	
    	a.AddMag(sz);
    	
    	//Kezdo hivas
    	t.Fur();
    }
    
    /**Telepes fúr vízjeget*/
    public static void TelepesFurVizjeget() {
    	depth=0;
    	//Inicializalas
    	Aszteroida a = new Aszteroida();
    	NamesMap.put(a.toString(), "a");
    	Telepes t = new Telepes(a);
    	NamesMap.put(t.toString(), "t");
    	Vizjeg v= new Vizjeg();
    	NamesMap.put(v.toString(), "v");
    	
    	a.AddMag(v);
    	
    	//Kezdo hivas
    	t.Fur();
    }
    
    /**Telepes fúr uránt*/
    public static void TelepesFurUrant() {
    	depth=0;
    	//Inicializalas
    	Aszteroida a = new Aszteroida();
    	NamesMap.put(a.toString(), "a");
    	Telepes t = new Telepes(a);
    	NamesMap.put(t.toString(), "t");
    	Robot r = new Robot(a);
    	NamesMap.put(r.toString(), "r");
    	Uran u = new Uran();
    	NamesMap.put(u.toString(), "u");
    	a.AddMag(u);
    	
    	Aszteroida szomsz1 = new Aszteroida();
    	NamesMap.put(szomsz1.toString(), "szomsz1");
    	a.AddSzomszed(szomsz1);
    	szomsz1.AddSzomszed(a);
    	
    	Teleportkapu szomsz2 = new Teleportkapu();
    	NamesMap.put(szomsz2.toString(), "szomsz2");
    	szomsz2.SetSajatAszteroida(a);
    	a.AddSzomszed(szomsz2);
    	Teleportkapu par = new Teleportkapu();
    	NamesMap.put(par.toString(), "par");
    	szomsz2.SetPar(par);
    	par.SetPar(szomsz2);
    	
    	Aszteroida a2 = new Aszteroida();
    	NamesMap.put(a2.toString(), "a2");
    	par.SetSajatAszteroida(a2);
    	a2.AddSzomszed(par);
    	
    	//Kezdo hivas
    	t.Fur();
    }
    
    /**Robot fúr vasat*/
    public static void RobotFurVasat() {
    	depth=0;
    	//Inicializalas
    	Aszteroida a = new Aszteroida();
    	NamesMap.put(a.toString(), "a");
    	Robot r = new Robot(a);
    	NamesMap.put(r.toString(), "r");
    	Vas vas = new Vas();
    	NamesMap.put(vas.toString(), "vas");
    	
    	a.AddMag(vas);
    	
    	//Kezdo hivas
    	r.Fur();
    }
    
    /**Robot fúr szenet*/
    public static void RobotFurSzenet() {
    	depth=0;
    	//Inicializalas
    	Aszteroida a = new Aszteroida();
    	NamesMap.put(a.toString(), "a");
    	Robot r = new Robot(a);
    	NamesMap.put(r.toString(), "r");
    	Szen sz = new Szen();
    	NamesMap.put(sz.toString(), "sz");
    	
    	a.AddMag(sz);
    	
    	//Kezdo hivas
    	r.Fur();
    }
    
    /**Robot fúr vízjeget*/
    public static void RobotFurVizjeget() {
    	depth=0;
    	//Inicializalas
    	Aszteroida a = new Aszteroida();
    	NamesMap.put(a.toString(), "a");
    	Robot r = new Robot(a);
    	NamesMap.put(r.toString(), "r");
    	Vizjeg v= new Vizjeg();
    	NamesMap.put(v.toString(), "v");
    	
    	a.AddMag(v);
    	
    	//Kezdo hivas
    	r.Fur();
    }
    
    /**Robot fúr uránt*/
    public static void RobotFurUrant() {
    	depth=0;
    	//Inicializalas
    	Aszteroida a = new Aszteroida();
    	NamesMap.put(a.toString(), "a");
    	Telepes t = new Telepes(a);
    	NamesMap.put(t.toString(), "t");
    	Robot r = new Robot(a);
    	NamesMap.put(r.toString(), "r");
    	Uran u = new Uran();
    	NamesMap.put(u.toString(), "u");
    	a.AddMag(u);
    	
    	Aszteroida szomsz1 = new Aszteroida();
    	NamesMap.put(szomsz1.toString(), "szomsz1");
    	a.AddSzomszed(szomsz1);
    	szomsz1.AddSzomszed(a);
    	
    	Teleportkapu szomsz2 = new Teleportkapu();
    	NamesMap.put(szomsz2.toString(), "szomsz2");
    	szomsz2.SetSajatAszteroida(a);
    	a.AddSzomszed(szomsz2);
    	Teleportkapu par = new Teleportkapu();
    	NamesMap.put(par.toString(), "par");
    	szomsz2.SetPar(par);
    	par.SetPar(szomsz2);
    	
    	Aszteroida a2 = new Aszteroida();
    	NamesMap.put(a2.toString(), "a2");
    	par.SetSajatAszteroida(a2);
    	a2.AddSzomszed(par);
    	
    	//Kezdo hivas
    	r.Fur();
    }
    
    /**telepes meghal, egy teleportkapu par van nala*/
    public static void TelepesMeghalKapupar() {
    	depth=0;
    	//inicializalas
    	Aszteroida a = new Aszteroida();
    	NamesMap.put(a.toString(), "a");
    	Telepes t = new Telepes(a);
    	NamesMap.put(t.toString(), "t");
    	Vas v = new Vas();
    	NamesMap.put(v.toString(), "v");
    	t.AddNyersanyagRakter(v);
    	
    	Teleportkapu tp = new Teleportkapu();
    	NamesMap.put(tp.toString(), "tp");
    	Teleportkapu par = new Teleportkapu();
    	NamesMap.put(par.toString(), "par");
    	tp.SetPar(par);
    	par.SetPar(tp);
    	t.AddTeleportkapuRakter(tp);
    	t.AddTeleportkapuRakter(par);
    	
    	//Kezdo hivas
    	t.Meghal();   	
    }
    
    /**telepes meghal, csak a kapupár fele van nála*/
    public static void TelepesMeghalKapuKulon() {
    	depth=0;
    	//inicializalas
    	Aszteroida a = new Aszteroida();
    	NamesMap.put(a.toString(), "a");
    	Telepes t = new Telepes(a);
    	NamesMap.put(t.toString(), "t");
    	Vas v = new Vas();
    	NamesMap.put(v.toString(), "v");
    	t.AddNyersanyagRakter(v);
    	
    	Teleportkapu tp = new Teleportkapu();
    	NamesMap.put(tp.toString(), "tp");
    	Teleportkapu par = new Teleportkapu();
    	NamesMap.put(par.toString(), "par");
    	tp.SetPar(par);
    	par.SetPar(tp);
    	t.AddTeleportkapuRakter(tp);
    	
    	Aszteroida a2 = new Aszteroida();
    	NamesMap.put(a2.toString(), "a2");
    	par.SetSajatAszteroida(a2);
    	a2.AddSzomszed(par);
    	
    	//Kezdo hivas
    	t.Meghal();   	
    }
}