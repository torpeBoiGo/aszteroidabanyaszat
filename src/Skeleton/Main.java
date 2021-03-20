
package Skeleton;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class Main {
    public static void main(String[] args) {
        int chosen = -1;
        ArrayList<MenuItem> menuItems= new ArrayList<MenuItem>();
        menuItems.add(new MenuItem("Kilepes", SkeletonController::Kilepes));
        menuItems.add(new MenuItem("Telepes mozog szomszedos aszteroidara", SkeletonController::TelepesMozogSzomszedosAszteroidara));
        menuItems.add(new MenuItem("Robot mozog szomszedos aszteroidara", SkeletonController::RobotMozogSzomszedosAszteroidara));
        menuItems.add(new MenuItem("Telepes tetlen", SkeletonController::TelepesTetlen));
        menuItems.add(new MenuItem("Telepes mozog teleporton keresztul", SkeletonController::TelepesMozogTeleport));
        menuItems.add(new MenuItem("Robot mozog teleporton keresztul", SkeletonController::RobotMozogTeleport));
        menuItems.add(new MenuItem("Telepes teleportkaput epit", SkeletonController::TelepesTeleportkaputEpit));
        menuItems.add(new MenuItem("Telepes robotot epit", SkeletonController::TelepesRobototEpit));
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (chosen != 0) {
            System.out.println("Kerlek valassz egy opciot!\n");
            for (int i = 0; i< menuItems.size();i++) 
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
				
			}
            SkeletonController.NamesMap.clear();
        }
    }
}