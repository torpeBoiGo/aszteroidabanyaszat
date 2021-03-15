package Skeleton;

public class SkeletonController {

    public static void FunctionCall(String callerFunctionName, Object called, String calledFunctionName) {
        System.out.println("SkeletonController:" + callerFunctionName + " -> " + called.toString() + "." + calledFunctionName);
    }

    public static void ObjectCreated(Object obj) {
        System.out.println("Created: " + obj.toString());
    }

    public static void Kilepes() {
        System.out.println("Bye(t)!");
    }

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
}
