package Skeleton;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.StringJoiner;


public class Palya {

	/**
     * Tarolja a palyan levo aszteroidakat.
     */
    static List<Aszteroida> aszteroidak = new ArrayList<>();
    
    /**
     * Tarolja a palyan levo ai vezerelt elemeket(ufo, robot).
     */
    static List<Leptetheto> aiVezerli = new ArrayList<>();
    
    /**
     * Tarolja a palyan levo jatekos vezerelt elemeket(telepes).
     */
    static List<Leptetheto> jatekosVezerli = new ArrayList<>();
    
    /**
     * Tarolja a palyan levo teleportkapukat.
     */
    static List<Teleportkapu> teleportKapuk = new ArrayList<>();

    
    /**
     * Veletlenszeru aszteroidat napvihar er
     */
    static void Napvihar() {
        Random random = new Random();
        aszteroidak.get(random.nextInt(aszteroidak.size())).Napvihar(true);

    }

    /**
     * Megadott aszteroidat napvihar er
     * @param a - Az aszterida amire a napvihart hivjuk
     */
    static void Napvihar(Aszteroida a) {
        a.Napvihar(true);
    }

    /**
     * : 1 kort valosit meg, eloszor a jatekosok lepnek, majd frissiti a valtozasokat a KorVege() fuggveny meghivasaval, majd Napvihar()-t hiv, legvegul jatek veget viszgalja
     * @return a kor utan folytatodik-e a jatek
     */
    static boolean Kor() {
        if (!MegnyerhetoE() || jatekosVezerli.size()<1) {
            System.out.println("Jatek vege - vereseg");
            return false;
        }

        for (Leptetheto leptetheto : jatekosVezerli) {
            leptetheto.Lepes();
        }

        KorVege();

        Napvihar();
        if (GyozelemE()) {
            System.out.println("Jatek vege - gyozelem");
            return false;
        }
        return true;
    }

    /**
     * Sorban lepteti az aiVezerli, aszteroidak �s teleportKapuk elemeit.
     */
    static void KorVege() {

        for (Leptetheto leptetheto : aiVezerli) {
          leptetheto.Lepes();
        }
        
        List<Aszteroida> tempAszteroidak = new ArrayList<>(aszteroidak);
        for (Leptetheto leptetheto : tempAszteroidak) {

            leptetheto.Lepes();
        }
        
        for (Leptetheto leptetheto : teleportKapuk) {
            leptetheto.Lepes();
        }
    }

    
    /**
     * Hozzaad a teleportkapu-listahoz
     */
    static void AddTeleportkapu(Teleportkapu t) {
        teleportKapuk.add(t);
    }

    /**
     * Torol a teleportkapu-listabol
     */
    static void RemoveTeleportkapu(Teleportkapu t) {
        teleportKapuk.remove(t);
    }

    /**
     * Hozzaad az aszteroida-listahoz
     */
    static void AddAszteroida(Aszteroida a) {
        aszteroidak.add(a);
    }

    /**
     * Torol a teleportkapu-listabol
     */
    static void RemoveAszteroida(Aszteroida a) {
        aszteroidak.remove(a);
    }

    /**
     * Hozzaad a jatekosok altal vezerelt listahoz
     */
    static void AddJatekosVezerli(Leptetheto l) {
        jatekosVezerli.add(l);
    }

    /**
     * Torol a jatekosok altal vezerelt listabol
     */
    static void RemoveJatekosVezerli(Leptetheto l) {
        jatekosVezerli.remove(l);
    }

    /**
     * Hozzaad az ai altal vezerelt listahoz
     */
    static void AddAiVezerli(Leptetheto l) {
        aiVezerli.add(l);
    }

    /**
     * Torol az ai altal vezerelt listabol
     */
    static void removeAIVezerli(Leptetheto l) {
        aiVezerli.remove(l);
    }

    
    /**
     * Megvizsgalja, hogy a jatek megnyerheto-e meg, azaz a 
     * palyan levo osszes nyersanyagbol (hajok raktere, aszteroidak magja) epitheto-e
     * nyerheto objektum.
     * @return a jatekot meg lehet-e nyerni
     */
    static boolean MegnyerhetoE() {
        Nyerheto nyerhetoseg = new Nyerheto();//
        for (Aszteroida a : aszteroidak) {
            for (Hajo h : a.hajok) {
                h.NyerEllenoriz(nyerhetoseg);
            }
            nyerhetoseg.KellE(a.getMag());
        }

        return nyerhetoseg.EpithetoE() && (jatekosVezerli.size() > 0);
    }

    /**
     * Megvizsg�lja, az �sszes aszteroid�n, hogy van-e gy�zelem, azaz 
     * �p�thet�-e gy�zelem objektum.
     * @return a jatekosok gyoztek-e
     */
    static boolean GyozelemE() {

        for (Aszteroida a : aszteroidak) {
            Gyozelem gyozelemTortenik = new Gyozelem();
            for (Hajo h : a.hajok) {
                h.NyerEllenoriz(gyozelemTortenik);
            }
            if (gyozelemTortenik.EpithetoE()) return true;
            gyozelemTortenik.Reset();
        }
        return false;
    }

    /**
     * Torli a palyan tarolt �sszes objektumot.
     */
    public void Reset() {
        jatekosVezerli.clear();
        aiVezerli.clear();
        aszteroidak.clear();
        teleportKapuk.clear();

    }

    /**
     * Kiirja a palyan talalhato objektumok tulajdonsagait.
     */
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
