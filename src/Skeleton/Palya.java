package Skeleton;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.StringJoiner;


public class Palya {

    //TODO ezzel mi legyen? muszáj a static....
    static List<Aszteroida> aszteroidak = new ArrayList<>();
    static List<Leptetheto> aiVezerli = new ArrayList<>();
    static List<Leptetheto> jatekosVezerli = new ArrayList<>();
    static List<Teleportkapu> teleportKapuk = new ArrayList<>(); //Ez tenyleg letezik?

    static void Napvihar() {
        Random random = new Random();
        aszteroidak.get(random.nextInt(aszteroidak.size())).Napvihar();

    }

    static void Napvihar(Aszteroida a) {
        a.Napvihar();
    }

    static void Kor() {
        for (Leptetheto leptetheto : jatekosVezerli) {
            leptetheto.Lepes();
        }

        KorVege();

        Napvihar();
        //gyozelenm
        //nyerheto
    }

    static void KorVege() {
        for (Leptetheto leptetheto : jatekosVezerli) {
            leptetheto.Lepes();
        }
        
        List<Aszteroida> tempAszteroidak = new ArrayList<>(aszteroidak);
        for (Leptetheto leptetheto : tempAszteroidak) {
            leptetheto.Lepes();
        }
        for (Leptetheto leptetheto : aiVezerli) {
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

    //TODO dokumentalni
    static void AddJatekosVezerli(Leptetheto l) {
        jatekosVezerli.add(l);
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

    //TODO ez még nincs tesztelve
    boolean MegnyerhetoE() {
        Nyerheto nyerhetoseg = new Nyerheto();
        for (Aszteroida a : aszteroidak) {
            for (Hajo h : a.hajok) {
                h.NyerEllenoriz(nyerhetoseg);
            }
            nyerhetoseg.KellE(a.getMag());
        }

        return nyerhetoseg.EpithetoE() && (jatekosVezerli.size() > 0);
    }

    //TODO ez még nincs tesztelve
    //TODO doksiban update it
    boolean GyozelemE() {
        Gyozelem gyozelemTortenik = new Gyozelem();
        for (Aszteroida a : aszteroidak) {
            for (Hajo h : a.hajok) {
                h.NyerEllenoriz(gyozelemTortenik);
            }
            if (gyozelemTortenik.EpithetoE()) return true;

            //TODO ez kell?
            gyozelemTortenik.Reset();
        }
        return false;
    }

    //TODO dokumentalni
    public void Reset() {
        jatekosVezerli.clear();
        aiVezerli.clear();
        aszteroidak.clear();
        teleportKapuk.clear();

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
