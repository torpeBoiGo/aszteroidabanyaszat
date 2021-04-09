package Skeleton;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Jatek jatek = new Jatek();
        while (true) {
        	
            String line = sc.nextLine();
            String[] cmd = line.split(" ");
            if ("exit".equals(cmd[0])) break;
            jatek.DoCommand(cmd);
            
        }
        sc.close();
	}
}
