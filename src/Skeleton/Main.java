
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