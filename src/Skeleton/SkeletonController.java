
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
}