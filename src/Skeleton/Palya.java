package Skeleton;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class Palya implements Showable {
	
	List<Aszteroida> aszteroidak = new ArrayList<>();
	List<Leptetheto> aiVezerli = new ArrayList<>();
	List<Leptetheto> jatekosVezerli = new ArrayList<>();
	List<Teleportkapu> teleportKapuk = new ArrayList<>(); //Ez tenyleg letezik?
	static void Napvihar() {
		
	}
	
	static void Napvihar(Aszteroida a) {
		
	}
	
	static void Kor() {
		
	}
	
	static void RemoveAszteroida(Aszteroida a){
		
	}
	
	static void RemoveJatekosVezerli(Leptetheto l){
		
	}
	
	static void AddAiVezerli(Leptetheto l) {
		
	}
	
	boolean MegnyerhetoE(){
		return false;
	}
	
	boolean GyozelemE(){
		return false;
	}
	
	public void Show() {
		StringJoiner lineJoiner = new StringJoiner(",");
		System.out.print("JatekosVezerelt: ");
    	for (Leptetheto obj : jatekosVezerli) {
    		lineJoiner.add(Main.getKeyByValue(Main.NamesMap, obj)+": " + obj.getClass().getSimpleName());
		}
    	System.out.println(lineJoiner.toString() + ": JatekosVezerelt[0..*]");
    	
    	System.out.print("AiVezerelt: ");
    	for (Leptetheto obj : aiVezerli) {
    		lineJoiner.add(Main.getKeyByValue(Main.NamesMap, obj)+": " + obj.getClass().getSimpleName());
		}
    	System.out.println(lineJoiner.toString() + ": AiVezerelt[0..*]");
    	
    	System.out.print("Aszteroidak: ");
    	for (Aszteroida obj : aszteroidak) {
    		lineJoiner.add(Main.getKeyByValue(Main.NamesMap, obj)+": " + obj.getClass().getSimpleName());
		}
    	System.out.println(lineJoiner.toString() + ": Aszteroidak[0..*]");
    	
    	System.out.print("Teleportkapuk: ");
    	for (Teleportkapu obj : teleportKapuk) {
    		lineJoiner.add(Main.getKeyByValue(Main.NamesMap, obj)+": " + obj.getClass().getSimpleName());
		}
    	System.out.println(lineJoiner.toString() + ": Teleportkapuk[0..*]");
    	
    	
		
	}
}
