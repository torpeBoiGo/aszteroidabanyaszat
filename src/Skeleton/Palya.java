package Skeleton;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class Palya {

	//TODO ezzel mi legyen? muszáj a static....
    static List<Aszteroida> aszteroidak = new ArrayList<>();
    static List<Leptetheto> aiVezerli = new ArrayList<>();
    static List<Leptetheto> jatekosVezerli = new ArrayList<>();
    static List<Teleportkapu> teleportKapuk = new ArrayList<>(); //Ez tenyleg letezik?

    static void Napvihar() {

    }

    static void Napvihar(Aszteroida a) {
    	a.Napvihar();
    }

    static void Kor() {
    	
    }
    
    static void KorVege() {
    	for (Leptetheto leptetheto : jatekosVezerli) {
			leptetheto.Lepes();
		}
    	for (Leptetheto leptetheto : aiVezerli) {
			leptetheto.Lepes();
		}
    	for (Leptetheto leptetheto : aszteroidak) {
			leptetheto.Lepes();
		}
    	for (Leptetheto leptetheto : teleportKapuk) {
    		leptetheto.Lepes();
    	}
    }

    static void AddTeleportkapu(Teleportkapu t) {
    	teleportKapuk.add(t);
    }
    
    static void RemoveTeleportkapu(Teleportkapu t) {
    	teleportKapuk.remove(t);
    }
    static void AddAszteroida(Aszteroida a) {
    	aszteroidak.add(a);
    }
    
    static void RemoveAszteroida(Aszteroida a) {
        aszteroidak.remove(a);
    }

    static void RemoveJatekosVezerli(Leptetheto l) {
        jatekosVezerli.remove(l);
    }

    static void AddAiVezerli(Leptetheto l) {
        aiVezerli.add(l);
    }

    //TODO class diagramm?
	static void removeAIVezerli(Leptetheto l) {
    	aiVezerli.remove(l);
	}

	boolean MegnyerhetoE() {
        return false;
    }

    boolean GyozelemE() {
        return false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        StringJoiner lineJoiner = new StringJoiner(",");
        sb.append("JatekosVezerelt: \n");
        for (Leptetheto obj : jatekosVezerli) {
            lineJoiner.add(Jatek.getKeyByValue(Jatek.NamesMap, obj) + ": " + obj.getClass().getSimpleName());
        }
        sb.append(lineJoiner).append(": JatekosVezerelt[0..*]\n");

        sb.append("AiVezerelt: \n");
        for (Leptetheto obj : aiVezerli) {
            lineJoiner.add(Jatek.getKeyByValue(Jatek.NamesMap, obj) + ": " + obj.getClass().getSimpleName());
        }
        sb.append(lineJoiner).append(": AiVezerelt[0..*]\n");

        sb.append("Aszteroidak: \n");
        for (Aszteroida obj : aszteroidak) {
            lineJoiner.add(Jatek.getKeyByValue(Jatek.NamesMap, obj) + ": " + obj.getClass().getSimpleName());
        }
        sb.append(lineJoiner).append(": Aszteroidak[0..*]\n");

        sb.append("Teleportkapuk: \n");
        for (Teleportkapu obj : teleportKapuk) {
            lineJoiner.add(Jatek.getKeyByValue(Jatek.NamesMap, obj) + ": " + obj.getClass().getSimpleName());
        }
        sb.append(lineJoiner).append(": Teleportkapuk[0..*]\n");


        return sb.toString();
    }
}
