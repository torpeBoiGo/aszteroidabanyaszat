
package Skeleton;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class SkeletonController {

	static int depth = 0;
	static HashMap<String, String> NamesMap = new HashMap<String, String>();
	
    public static void FunctionCall(Object called, String calledFunctionName) {
    	for(int i = 0; i< depth;i++) {
    		System.out.print("\t");
    	}
        System.out.print("-> " + called.toString() + "." + calledFunctionName+ "\n");
        depth++;
    }
    
    public static void FunctionCall(String calledFunctionName, Object callerObject) {
    	for(int i = 0; i< depth;i++) {
    		System.out.print("\t");
    	}
    	if(NamesMap.containsKey(callerObject.toString()))
    		System.out.print("-> " + NamesMap.get(callerObject.toString()));
    	else System.out.print("-> NINCS N�V REGISZTR�LVA");
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
    	for (int i = 0; i< choices.size();i++) {
			System.out.print(i+1 + ". " + choices.get(i) + ",  ");
		}
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
        System.out.println("Created: " + obj.toString());
    }

    public static void Kilepes() {
        System.out.println("Bye(t)!");
        System.exit(0);
    }

    
    public static void TelepesMozog() {
    	// A sz�moz�s rossz a diagramunkon (5.4.4)
    	
    	//Inicializ�l�s
    	Aszteroida jelenlegi;
    	Aszteroida uj;
    	Telepes t;
    	
    	
    	//N�v regisztr�ci� �s inicializ�l�s
    	//M�g nem tudom hogy lehet kiker�lni hogy csak a konstruktor ut�n lehet elnevezni
    	//Fel lehetne mindenre venni egy �j param�tert, de az sok munka lenne, megpr�b�lom Goldit megk�rdezni majd hogy k�ne
    	jelenlegi =  new Aszteroida();
    	NamesMap.put(jelenlegi.toString(), "jelenlegi");
    	uj = new Aszteroida();
    	NamesMap.put(uj.toString(), "uj");
    	t = new Telepes(jelenlegi);
    	NamesMap.put(t.toString(), "t");
    	
    	jelenlegi.AddSzomszed(uj);
    	uj.AddSzomszed(jelenlegi);
    	
    	
    	//Kezd�hiv�s
    	
    		t.Mozog(uj);
		
    	
    	
    	//Hogy ne legyen konflikt m�sik esettel
    	NamesMap.clear();
    }
    
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
    	a.AddSzomszed(tp);
    	a2.AddSzomszed(par);
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
    	a.AddSzomszed(tp);
    	a2.AddSzomszed(par);
    	r.Mozog(tp);
    	NamesMap.clear();
    }
    public static void RobotMozog() {
    	Aszteroida jelenlegi;
    	Aszteroida uj;
    	jelenlegi =  new Aszteroida();
    	NamesMap.put(jelenlegi.toString(), "jelenlegi");
    	uj = new Aszteroida();
    	NamesMap.put(uj.toString(), "uj");
    	Robot r = new Robot(jelenlegi);
    	NamesMap.put(r.toString(), "r");
    	jelenlegi.AddSzomszed(uj);
    	uj.AddSzomszed(jelenlegi);
    	r.Mozog(uj);
    	NamesMap.clear();
    }
    //old implementation
    /*
    public static void TelepesBanyaszikVasat() {
        System.out.println("TelepesBanyaszikVasat Use-Case:");
        Aszteroida a = new Aszteroida();
        Telepes t = new Telepes(a);
        a.HajoErkezik(t);
        FunctionCall("TelepesBanyaszikVasat()", a, "HajoErkezik(t)");
        t.MezoBeallit(a);
        FunctionCall("TelepesBanyaszikVasat()", t, "MezoBeallit(a)");
        Vas va = new Vas();
        a.AddMag(va);
        FunctionCall("TelepesBanyaszikVasat()", a, "AddMag(va)");


    }
    
    */
}