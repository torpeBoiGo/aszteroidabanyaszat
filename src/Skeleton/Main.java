package Skeleton;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        int chosen = -1;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (chosen != 0) {
            System.out.print("Kerlek válassz egy opciot!");
            try {
                String line = reader.readLine();
                chosen = Integer.parseInt(String.valueOf(line));
            } catch (Exception e) {
                System.out.println(e.getMessage());
                chosen = 0;
            }
            switch (chosen) {
                case 0:
                    SkeletonController.Kilepes();
                    break;
                case 1:
                    SkeletonController.TelepesBanyaszikVasat();
                    break;
            }
        }
    }
}
