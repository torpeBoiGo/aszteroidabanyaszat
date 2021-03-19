
package Skeleton;

public class SkeletonController {

	static int depth = 0;
	
    public static void FunctionCall(Object called, String calledFunctionName) {
    	for(int i = 0; i< depth;i++) {
    		System.out.print("\t");
    	}
        System.out.print("-> " + called.toString() + "." + calledFunctionName+ "\n");
        depth++;
    }
    
    public static void FunctionReturn() {
    	depth--;
    }

    public static void ObjectCreated(Object obj) {
        System.out.println("Created: " + obj.toString());
    }

    public static void Kilepes() {
        System.out.println("Bye(t)!");
    }

    public static void TelepesMozog() {
    	// A számozás rossz a diagramunkon (5.4.4)
    	Aszteroida jelenlegi =  new Aszteroida();
    	Aszteroida uj = new Aszteroida();
    	Telepes t = new Telepes(jelenlegi);
    	
    	jelenlegi.AddSzomszed(uj);
    	uj.AddSzomszed(jelenlegi);
    	
    	t.Mozog(uj);
    	
    }
    
    public static void TelepesTetlen() {
    	Telepes t = new Telepes();
    	t.Tetlen();
    }
    
    public static void TelepesMozogTeleport() {
    	Aszteroida a =  new Aszteroida();
    	Aszteroida a2 = new Aszteroida();
    	Telepes t = new Telepes(a);
    	Teleportkapu tp = new Teleportkapu();
    	Teleportkapu par = new Teleportkapu();
    	tp.SetPar(par);
    	tp.SetSajatAszteroida(a);
    	par.SetPar(tp);
    	par.SetSajatAszteroida(a2);
    	a.AddSzomszed(tp);
    	a2.AddSzomszed(par);
    	t.Mozog(tp);
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