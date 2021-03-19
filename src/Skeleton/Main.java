
package Skeleton;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        int chosen = -1;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (chosen != 0) {
            System.out.println("Kerlek valassz egy opciot!\n");
            System.out.println("0. Kilepes");
            System.out.println("1. Telepes mozog szomszedos aszteroidara");
            System.out.println("2. Robot mozog szomszedos aszteroidara");
            System.out.println("3. Telepes tetlen");
            System.out.println("4. Telepes mozog teleportkapun keresztul");
            System.out.println("5. Robot mozog teleportkapun keresztul");
            System.out.print("Valasztas: ");
            try {
                String line = reader.readLine();
                chosen = Integer.parseInt(String.valueOf(line));
            } catch (Exception e) {
                System.out.println(e.getMessage());
                chosen = 0;
            }
            
            try {
            	switch (chosen) {
                case 0:
                    SkeletonController.Kilepes();
                    break;
                case 1:
                    SkeletonController.TelepesMozog();
                    break;
                case 2:
                    SkeletonController.RobotMozog();
                    break;
                case 3:
                	SkeletonController.TelepesTetlen();
                	break;
                case 4:
                	SkeletonController.TelepesMozogTeleport();
                	break;
                case 5:
                	SkeletonController.RobotMozogTeleport();
                	break;
            	}
			} catch (Exception e) {
				
			}
        }
    }
}