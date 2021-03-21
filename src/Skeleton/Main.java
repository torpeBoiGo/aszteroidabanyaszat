package Skeleton;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class Main {
    public static void main(String[] args) {
        int chosen = -1;
        ArrayList<MenuItem> menuItems = new ArrayList<MenuItem>();
        menuItems.add(new MenuItem("Kilepes", SkeletonController::Kilepes));
        menuItems.add(new MenuItem("Telepes tetlen", SkeletonController::TelepesTetlen));
        menuItems.add(new MenuItem("Telepes mozog teleporton keresztul", SkeletonController::TelepesMozogTeleport));
        menuItems.add(new MenuItem("Robot mozog teleporton keresztul", SkeletonController::RobotMozogTeleport));
        menuItems.add(new MenuItem("Telepes mozog szomszedos aszteroidara", SkeletonController::TelepesMozogSzomszedosAszteroidara));
        menuItems.add(new MenuItem("Robot mozog szomszedos aszteroidara", SkeletonController::RobotMozogSzomszedosAszteroidara));
        //Telepes lerak teleportkaput
        menuItems.add(new MenuItem("Telepes robotot epit", SkeletonController::TelepesRobototEpit));
        menuItems.add(new MenuItem("Telepes teleportkaput epit", SkeletonController::TelepesTeleportkaputEpit));
        menuItems.add(new MenuItem("Telepes banyaszik szenet", SkeletonController::TelepesBanyaszikSzenet));
        menuItems.add(new MenuItem("Telepes banyaszik vasat", SkeletonController::TelepesBanyaszikVasat));
        menuItems.add(new MenuItem("Telepes banyaszik urant", SkeletonController::TelepesBanyaszikUrant));
        menuItems.add(new MenuItem("Telepes banyaszik vizjeget", SkeletonController::TelepesBanyaszikVizjeget));
        menuItems.add(new MenuItem("Telepes lerak szenet", SkeletonController::TelepesLerakSzenet));
        menuItems.add(new MenuItem("Telepes lerak vasat", SkeletonController::TelepesLerakVasat));
        menuItems.add(new MenuItem("Telepes lerak vizjeges", SkeletonController::TelepesLerakVizjeget));
        menuItems.add(new MenuItem("Telepes lerak urant", SkeletonController::TelepesLerakUrant));
        
        menuItems.add(new MenuItem("Telepes furja a vasat tartalmazo aszteroidat", SkeletonController::TelepesFurVasat));
        menuItems.add(new MenuItem("Telepes furja a szenet tartalmazo aszteroidat", SkeletonController::TelepesFurSzenet));
        menuItems.add(new MenuItem("Telepes furja a vizjeget tartalmazo aszteroidat", SkeletonController::TelepesFurVizjeget));
        menuItems.add(new MenuItem("Telepes furja az urant tartalmazo aszteroidat", SkeletonController::TelepesFurUrant));
        menuItems.add(new MenuItem("Robot furja a vasat tartalmazo aszteroidat", SkeletonController::RobotFurVasat));
        menuItems.add(new MenuItem("Robot furja a szenet tartalmazo aszteroidat", SkeletonController::RobotFurSzenet));
        menuItems.add(new MenuItem("Robot furja a vizjeget tartalmazo aszteroidat", SkeletonController::RobotFurVizjeget));
        menuItems.add(new MenuItem("Robot furja az urant tartalmazo aszteroidat", SkeletonController::RobotFurUrant));

        menuItems.add(new MenuItem("Telepes meghal - tarolojaban a teleportkapu par egyik fele van csak ", SkeletonController::TelepesMeghalKapuKulon));
        menuItems.add(new MenuItem("Telepes meghal - tarolojaban van a teleportkapu par mindket fele", SkeletonController::TelepesMeghalKapupar));     
        
        menuItems.add(new MenuItem("Napvihar olyan aszteroidat er, amin telepes van", SkeletonController::NapviharAszteroidaraTelepesre));
        menuItems.add(new MenuItem("Napvihar olyan aszteroidat er, amin robot van", SkeletonController::NapviharAszteroidaraRobotra));
        
        
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (chosen != 0) {
            System.out.println("Kerlek valassz egy opciot!\n");
            for (int i = 0; i < menuItems.size(); i++)
                System.out.println(i + ". " + menuItems.get(i).name);
            System.out.print("Valasztas: ");
            try {
                String line = reader.readLine();
                chosen = Integer.parseInt(String.valueOf(line));
            } catch (Exception e) {
                System.out.println(e.getMessage());
                chosen = 0;
            }

            try {
                menuItems.get(chosen).toCall.run();
            } catch (Exception e) {
                System.out.println(e.getMessage());
                //Igy látjuk ha valamit elbasztunk...
                System.out.println(e.toString());
            }
            SkeletonController.NamesMap.clear();
        }
    }
}
