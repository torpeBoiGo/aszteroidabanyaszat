package Skeleton;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class Palya{
	
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

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		StringJoiner lineJoiner = new StringJoiner(",");
		sb.append("JatekosVezerelt: \n");
    	for (Leptetheto obj : jatekosVezerli) {
    		lineJoiner.add(Main.getKeyByValue(Main.NamesMap, obj)+": " + obj.getClass().getSimpleName());
		}
    	sb.append(lineJoiner).append(": JatekosVezerelt[0..*]\n");
    	
    	sb.append("AiVezerelt: \n");
    	for (Leptetheto obj : aiVezerli) {
    		lineJoiner.add(Main.getKeyByValue(Main.NamesMap, obj)+": " + obj.getClass().getSimpleName());
		}
    	sb.append(lineJoiner).append(": AiVezerelt[0..*]\n");

		sb.append("Aszteroidak: \n");
    	for (Aszteroida obj : aszteroidak) {
    		lineJoiner.add(Main.getKeyByValue(Main.NamesMap, obj)+": " + obj.getClass().getSimpleName());
		}
		sb.append(lineJoiner).append(": Aszteroidak[0..*]\n");
    	
    	sb.append("Teleportkapuk: \n");
    	for (Teleportkapu obj : teleportKapuk) {
    		lineJoiner.add(Main.getKeyByValue(Main.NamesMap, obj)+": " + obj.getClass().getSimpleName());
		}
    	sb.append(lineJoiner).append(": Teleportkapuk[0..*]\n");


		return sb.toString();
	}
}
