package Skeleton;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        int choosed = -1;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (choosed != 0) {
            System.out.println("Kérlek válassz egy opciót!");
            try {
                String line = reader.readLine();
                choosed = Integer.parseInt(String.valueOf(line));
            } catch (Exception e) {
                System.out.println(e.getMessage());
                choosed = 0;
            }
            switch (choosed) {
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
