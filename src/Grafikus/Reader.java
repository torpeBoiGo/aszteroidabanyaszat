package Grafikus;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Scanner;

/**
 * Beolvassa az adott mappaban levo fajl tartalmat a bemeneti nyelvnek megfeleloen.
 */
public class Reader {
    /**
     * A palya beolvasasa "input" mappaban levo fajlbol
     *
     * @param fileName - a futas helyen levo "input" mappaban levo fajl amibol a program olvas
     */
    public void loadPalyaFromFile(String fileName) {
        try {
            File myFile = new File(fileName);
            Scanner myReader = new Scanner(myFile);
            String line = myReader.nextLine();
            if (line.equals("NYERSANYAGOK")) {
                readNyersanyagok(myReader);
                readAszteroidak(myReader);
                readTeleportkapuk(myReader);
                readSzomszedok(myReader);
                readTelepesek(myReader);
                readRobotok(myReader);
                readUfok(myReader);
                readRakter(myReader);
            } else {
                myReader.close();
                throw new RuntimeException("Bad file format");
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            e.printStackTrace();
        }
    }

    /**
     * A nyersanyagok beolvasasa
     *
     * @param reader - a scanner, amirol olvas
     */
    void readNyersanyagok(Scanner reader) {
        String line = reader.nextLine();
        while (!line.equals("ASZTEROIDAK")) {
            String[] temp = line.split(" ");
            switch (temp[0]) {
                case "vas":
                    Vas v = new Vas();
                    MainGUI.NamesMap.put(temp[1], v);
                    break;
                case "szen":
                    Szen s = new Szen();
                    MainGUI.NamesMap.put(temp[1], s);

                    break;
                case "vizjeg":
                    Vizjeg vj = new Vizjeg();
                    MainGUI.NamesMap.put(temp[1], vj);

                    break;
                case "uran":
                    Uran u = new Uran(Integer.parseInt(temp[2]));
                    MainGUI.NamesMap.put(temp[1], u);
                    break;
            }
            line = reader.nextLine();
        }
    }

    /**
     * Az aszteroidak beolvasasa
     *
     * @param reader - a scanner, amirol olvas
     */
    void readAszteroidak(Scanner reader) {
        String line = reader.nextLine();
        while (!line.equals("TELEPORTKAPUK")) {
            String[] temp = line.split(" ");

            Aszteroida a = new Aszteroida(Integer.parseInt(temp[1]), ("napkozelben".equals(temp[3])));

            a.SetMag((Nyersanyag) MainGUI.NamesMap.get(temp[2]));
            MainGUI.NamesMap.put(temp[0], a);

            line = reader.nextLine();
        }
    }

    /**
     * A teleportkapuk beolvasasa
     *
     * @param reader - a scanner, amirol olvas
     */
    void readTeleportkapuk(Scanner reader) {
        String line = reader.nextLine();
        while (!line.equals("SZOMSZEDOK")) {
            String[] temp = line.split(" ");
            Aszteroida a1, a2;
            Teleportkapu k1, k2;
            if (temp[1].equals("0")) {
                k1 = new Teleportkapu(Boolean.parseBoolean(temp[2]));
            } else {
                a1 = (Aszteroida) MainGUI.NamesMap.get(temp[1]);
                if ("megkergult".equals(temp[2]))
                    k1 = new Teleportkapu(a1, true);
                else k1 = new Teleportkapu(a1, false);
            }
            if (temp[4].equals("0")) {
                k2 = new Teleportkapu(Boolean.parseBoolean(temp[4]));
            } else {
                a2 = (Aszteroida) MainGUI.NamesMap.get(temp[4]);

                if ("megkergult".equals(temp[5]))
                    k2 = new Teleportkapu(a2, true);
                else k2 = new Teleportkapu(a2, false);
            }
            k1.SetPar(k2);
            k2.SetPar(k1);

            MainGUI.NamesMap.put(temp[0], k1);
            MainGUI.NamesMap.put(temp[3], k2);

            line = reader.nextLine();
        }
    }

    /**
     * A szomszedok beolvasasa
     *
     * @param reader - a scanner, amirol olvas
     */
    void readSzomszedok(Scanner reader) {
        String line = reader.nextLine();
        while (!line.equals("TELEPESEK")) {
            String[] temp = line.split(" ");
            ((Aszteroida) MainGUI.NamesMap.get(temp[0])).AddSzomszed((Mezo) MainGUI.NamesMap.get(temp[1]));
            ((Aszteroida) MainGUI.NamesMap.get(temp[1])).AddSzomszed((Mezo) MainGUI.NamesMap.get(temp[0]));

            line = reader.nextLine();
        }

    }

    /**
     * A telepesek beolvasasa
     *
     * @param reader - a scanner, amirol olvas
     */
    void readTelepesek(Scanner reader) {
        String line = reader.nextLine();
        while (!line.equals("ROBOTOK")) {
            String[] temp = line.split(" ");
            Telepes t = new Telepes((Aszteroida) MainGUI.NamesMap.get(temp[1]));
            MainGUI.NamesMap.put(temp[0], t);
            line = reader.nextLine();
        }

    }

    /**
     * A robotok beolvasasa
     *
     * @param reader - a scanner, amirol olvas
     */
    void readRobotok(Scanner reader) {
        String line = reader.nextLine();
        while (!line.equals("UFOK")) {
            String[] temp = line.split(" ");
            Robot r = new Robot((Aszteroida) MainGUI.NamesMap.get(temp[1]));
            MainGUI.NamesMap.put(temp[0], r);
            line = reader.nextLine();
        }

    }

    /**
     * Az UFO-k beolvasasa
     *
     * @param reader - a scanner, amirol olvas
     */
    void readUfok(Scanner reader) {
        String line = reader.nextLine();
        while (!line.equals("RAKTER")) {
            String[] temp = line.split(" ");
            Ufo u = new Ufo((Aszteroida) MainGUI.NamesMap.get(temp[1]));
            MainGUI.NamesMap.put(temp[0], u);
            line = reader.nextLine();
        }

    }

    /**
     * A rakterek beolvasasa
     *
     * @param reader - a scanner, amirol olvas
     */
    void readRakter(Scanner reader) {
        while (reader.hasNextLine()) {
            String line = reader.nextLine();
            String[] temp = line.split(" ");

            if ("Telepes".equals(MainGUI.NamesMap.get(temp[0]).getClass().getSimpleName())) {
                if (MainGUI.NamesMap.get(temp[1]).getClass().getSimpleName().equals("Teleportkapu"))
                    ((Telepes) MainGUI.NamesMap.get(temp[0])).SetTeleportkapuRakter((Teleportkapu) MainGUI.NamesMap.get(temp[1]));
                else
                    ((Telepes) MainGUI.NamesMap.get(temp[0])).SetNyersanyagRakter((Nyersanyag) MainGUI.NamesMap.get(temp[1]));
            } else {
                ((Ufo) MainGUI.NamesMap.get(temp[0])).AddNyersanyagRakter((Nyersanyag) MainGUI.NamesMap.get(temp[1]));
            }

        }

    }
}
