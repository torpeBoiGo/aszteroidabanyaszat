
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
        menuItems.add(new MenuItem("Telepes fur vasat",SkeletonController::TelepesFurVasat));
        menuItems.add(new MenuItem("Telepes fur szenet",SkeletonController::TelepesFurSzenet));
        menuItems.add(new MenuItem("Telepes fur vizjeget",SkeletonController::TelepesFurVizjeget));
        menuItems.add(new MenuItem("Telepes fur urant",SkeletonController::TelepesFurUrant));
        menuItems.add(new MenuItem("Robot fur vasat",SkeletonController::RobotFurVasat));
        menuItems.add(new MenuItem("Robot fur szenet",SkeletonController::RobotFurSzenet));
        menuItems.add(new MenuItem("Robot fur vizjeget",SkeletonController::RobotFurVizjeget));
        menuItems.add(new MenuItem("Robot fur urant",SkeletonController::RobotFurUrant));
        menuItems.add(new MenuItem("Telepes meghal, csak a kapupár fele van nála",SkeletonController::TelepesMeghalKapuKulon));
        menuItems.add(new MenuItem("Telepes meghal, egy teleportkapu par van nala",SkeletonController::TelepesMeghalKapupar));
        
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
				System.out.println(e.getMessage());
			}
            
            SkeletonController.NamesMap.clear();
            
        }
    }
}