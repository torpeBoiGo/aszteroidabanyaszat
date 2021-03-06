package Proto;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.Map.Entry;


public class Jatek {

    /**
     * A letrejott objektumok neveit tarolo map
     */
    static HashMap<String, Object> NamesMap = new HashMap<>();
    static Scanner sc = new Scanner(System.in);
    /**
     * A palya amin a jatek jatszodik
     */
    Palya palya = new Palya();

    public static <T, E> T getKeyByValue(Map<T, E> map, E value) {
        for (Entry<T, E> entry : map.entrySet()) {
            if (Objects.equals(value, entry.getValue())) {
                return entry.getKey();
            }
        }
        return null;
    }

    public void Indit() {

        while (true) {

            String line = sc.nextLine();
            String[] cmd = line.split(" ");
            if ("exit".equals(cmd[0])) {
                sc.close();
                break;
            }


            DoCommand(cmd);
        }
    }

    /**
     * Egy parancs feldolgozasa
     *
     * @param cmd - a parancs amit feldolgozunk
     */
    private void DoCommand(String[] cmd) {

        if ("palya".equals(cmd[0])) {
            if ("load".equals(cmd[1])) {
                loadPalyaFromFile(cmd[2]);

            } else if ("do".equals(cmd[1])) {
                if ("napvihar".equals(cmd[2])) {
                    if (cmd.length < 4) {
                        Palya.Napvihar();
                    } else {
                        Palya.Napvihar((Aszteroida) NamesMap.get(cmd[3]));
                    }
                } else if ("kor".equals(cmd[2])) {
                    Palya.Kor();
                } else if ("korvege".equals(cmd[2])) {
                    Palya.KorVege();

                }
            } else if ("startGame".equals(cmd[1])) {
                gameCycle();
            }
        } else if ("aszteroida".equals(cmd[0])) {
            Aszteroida aszteroida = (Aszteroida) (NamesMap.get(cmd[2]));
            if ("create".equals(cmd[1])) {
                Aszteroida aszteroidaNew = new Aszteroida();
                NamesMap.put(cmd[2], aszteroidaNew);
            } else if ("set".equals(cmd[1])) {
                if ("kulsoRetegek".equals(cmd[2])) {
                    aszteroida = (Aszteroida) (NamesMap.get(cmd[3]));
                    aszteroida.kulsoRetegek = Integer.parseInt(cmd[4]);
                } else if ("napkozelben".equals(cmd[2])) {
                    aszteroida = (Aszteroida) (NamesMap.get(cmd[3]));
                    aszteroida.napkozelben = Integer.parseInt(cmd[4]) == 1;
                }
            } else if ("add".equals(cmd[1])) {
                if ("mag".equals(cmd[2])) {
                    Nyersanyag ny = (Nyersanyag) NamesMap.get(cmd[3]);
                    aszteroida.AddMag(ny);
                } else if ("hajo".equals(cmd[2])) {
                    Hajo h = (Hajo) NamesMap.get(cmd[3]);
                    aszteroida.HajoErkezik(h);
                }
            } else if ("connect".equals(cmd[1])) {
                Aszteroida aszteroida2 = (Aszteroida) NamesMap.get(cmd[3]);
                aszteroida.AddSzomszed(aszteroida2);
                aszteroida2.AddSzomszed(aszteroida);
            }
        } else if ("hajo".equals(cmd[0])) {
            Hajo hajo = (Hajo) NamesMap.get(cmd[2]);
            if ("mozog".equals(cmd[1])) {
                Mezo mezo = (Mezo) NamesMap.get(cmd[3]);
                hajo.Mozog(mezo);
            } else if ("tetlen".equals(cmd[1])) {
                hajo.Tetlen();
            } else if ("meghal".equals(cmd[1])) {
                hajo.Meghal();
                NamesMap.remove(cmd[2]);
            }
        } else if ("robot".equals(cmd[0])) {
            if ("fur".equals(cmd[1])) {
                Robot robot = (Robot) NamesMap.get(cmd[2]);
                robot.Fur();
            }
        } else if ("ufo".equals(cmd[0])) {
            if ("banyasz".equals(cmd[1])) {
                Ufo ufo = (Ufo) NamesMap.get(cmd[2]);
                ufo.Banyasz();
            }
        } else if ("telepes".equals(cmd[0])) {
            Telepes telepes = (Telepes) NamesMap.get(cmd[2]);
            if ("create".equals(cmd[1])) {
                Telepes telepesNew = new Telepes();
                NamesMap.put(cmd[2], telepesNew);
            } else if ("addToRakter".equals(cmd[1])) {
                telepes.addNyersanyagRakter((Szallithato) NamesMap.get(cmd[3]));
            } else if ("robotEpit".equals(cmd[1])) {
                telepes.RobotEpit(new RobotEpito());
            } else if ("teleportEpit".equals(cmd[1])) {
                telepes.TeleportEpit(new TeleportEpito());
            } else if ("anyagVisszatesz".equals(cmd[1])) {
                Nyersanyag nyersanyag = (Nyersanyag) NamesMap.get(cmd[3]);
                telepes.AnyagVisszatesz(nyersanyag);
            } else if ("fur".equals(cmd[1])) {
                telepes.Fur();
            } else if ("banyasz".equals(cmd[1])) {
                telepes.Banyasz();
            } else if ("kapuLerak".equals(cmd[1])) {
                telepes.KapuLerak((Teleportkapu) NamesMap.get(cmd[3]));
            }
        } else if ("teleportkapu".equals(cmd[0])) {
            if ("create".equals(cmd[1])) {
                Teleportkapu teleportkapuNew = new Teleportkapu();
                NamesMap.put(cmd[2], teleportkapuNew);
            } else if ("connect".equals(cmd[1])) {
                Teleportkapu teleportkapu = (Teleportkapu) NamesMap.get(cmd[2]);
                Teleportkapu tp2 = (Teleportkapu) NamesMap.get(cmd[3]);
                teleportkapu.SetPar(tp2);
                tp2.SetPar(teleportkapu);
            } else if ("set".equals(cmd[1])) {
                if ("sajatAszteroida".equals(cmd[2])) {
                    Teleportkapu teleportkapu = (Teleportkapu) NamesMap.get(cmd[3]);
                    Aszteroida aszteroida = (Aszteroida) NamesMap.get(cmd[2]);
                    teleportkapu.SetSajatAszteroida(aszteroida);
                }
            }
        } else if ("nyersanyag".equals(cmd[0])) {
            if ("create".equals(cmd[1])) {
                Nyersanyag a = null;
                if ("vas".equals(cmd[2])) {
                    a = new Vas();
                } else if ("vizjeg".equals(cmd[2])) {
                    a = new Vizjeg();
                } else if ("szen".equals(cmd[2])) {
                    a = new Szen();
                } else if ("uran".equals(cmd[2])) {
                    a = new Uran();
                }
                NamesMap.put(cmd[3], a);
            }
        } else if ("show".equals(cmd[0])) {
            if ("all".equals(cmd[1])) {
                List<String> abcsorrendben = new ArrayList<>();
                List<String> abcsorrendbenkeys = new ArrayList<>();
                for (String key : NamesMap.keySet()) {
                    abcsorrendben.add(NamesMap.get(key).getClass().getSimpleName());
                }
                for (String key : NamesMap.keySet()) {
                    abcsorrendbenkeys.add(key);
                }
                for (int i = 0; i < abcsorrendben.size(); i++) {
                    for (int j = i; j < abcsorrendben.size(); j++) {
                        if (abcsorrendben.get(i).compareTo(abcsorrendben.get(j)) > 0) {
                            String temp = abcsorrendben.get(i);
                            abcsorrendben.set(i, abcsorrendben.get(j));
                            abcsorrendben.set(j, temp);
                            String temp2 = abcsorrendbenkeys.get(i);
                            abcsorrendbenkeys.set(i, abcsorrendbenkeys.get(j));
                            abcsorrendbenkeys.set(j, temp2);
                        }
                    }
                }
                for (String key : abcsorrendbenkeys) {
                    System.out.println(key + ": " + NamesMap.get(key).getClass().getSimpleName());
                    System.out.println(NamesMap.get(key));
                }
            } else {

                if (NamesMap.get(cmd[1]) != null)
                    System.out.println(cmd[1] + ": " + NamesMap.get(cmd[1]).getClass().getSimpleName());
                System.out.println(NamesMap.get(cmd[1]));
            }

        } else if(cmd[0].equals("semmi")){
        	
        }else System.out.println("Helytelen bemenet!");

    }

    /**
     * A palya beolvasasa "input" mappaban levo fajlbol
     *
     * @param fileName - a futas helyen levo "input" mappaban levo fajl amibol a program olvas
     */
    void loadPalyaFromFile(String fileName) {
        palya.Reset();
        try {
            File myFile = new File("inputs" + File.separator + fileName);
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
     */
    void readNyersanyagok(Scanner reader) {
        String line = reader.nextLine();
        while (!line.equals("ASZTEROIDAK")) {
            String[] temp = line.split(" ");
            switch (temp[0]) {
                case "vas":
                    Vas v = new Vas();
                    NamesMap.put(temp[1], v);
                    break;
                case "szen":
                    Szen s = new Szen();
                    NamesMap.put(temp[1], s);

                    break;
                case "vizjeg":
                    Vizjeg vj = new Vizjeg();
                    NamesMap.put(temp[1], vj);

                    break;
                case "uran":
                    Uran u = new Uran(Integer.parseInt(temp[2]));
                    NamesMap.put(temp[1], u);
                    break;
            }
            line = reader.nextLine();
        }

    }

    /**
     * Az aszteroidak beolvasasa
     */
    void readAszteroidak(Scanner reader) {
        String line = reader.nextLine();
        while (!line.equals("TELEPORTKAPUK")) {
            String[] temp = line.split(" ");

            Aszteroida a = new Aszteroida(Integer.parseInt(temp[1]), ("napkozelben".equals(temp[3])));

            a.SetMag((Nyersanyag) NamesMap.get(temp[2]));
            NamesMap.put(temp[0], a);

            line = reader.nextLine();
        }

    }

    /**
     * A teleportkapuk beolvasasa
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
                a1 = (Aszteroida) NamesMap.get(temp[1]);
                if ("megkergult".equals(temp[2]))
                    k1 = new Teleportkapu(a1, true);
                else k1 = new Teleportkapu(a1, false);

            }
            if (temp[4].equals("0")) {
                k2 = new Teleportkapu(Boolean.parseBoolean(temp[4]));
            } else {
                a2 = (Aszteroida) NamesMap.get(temp[4]);

                if ("megkergult".equals(temp[5]))
                    k2 = new Teleportkapu(a2, true);

                else k2 = new Teleportkapu(a2, false);

            }

            k1.SetPar(k2);
            k2.SetPar(k1);

            NamesMap.put(temp[0], k1);
            NamesMap.put(temp[3], k2);

            line = reader.nextLine();

        }

    }

    /**
     * A szomszedok beolvasasa
     */
    void readSzomszedok(Scanner reader) {
        String line = reader.nextLine();
        while (!line.equals("TELEPESEK")) {
            String[] temp = line.split(" ");
            ((Aszteroida) NamesMap.get(temp[0])).AddSzomszed((Mezo) NamesMap.get(temp[1]));
            ((Aszteroida) NamesMap.get(temp[1])).AddSzomszed((Mezo) NamesMap.get(temp[0]));

            line = reader.nextLine();
        }

    }

    /**
     * A telepesek beolvasasa
     */
    void readTelepesek(Scanner reader) {
        String line = reader.nextLine();
        while (!line.equals("ROBOTOK")) {
            String[] temp = line.split(" ");
            Telepes t = new Telepes((Aszteroida) NamesMap.get(temp[1]));
            NamesMap.put(temp[0], t);
            line = reader.nextLine();
        }

    }

    /**
     * A robotok beolvasasa
     */
    void readRobotok(Scanner reader) {
        String line = reader.nextLine();
        while (!line.equals("UFOK")) {
            String[] temp = line.split(" ");
            Robot r = new Robot((Aszteroida) NamesMap.get(temp[1]));
            NamesMap.put(temp[0], r);
            line = reader.nextLine();
        }

    }

    /**
     * Az UFO-k beolvasasa
     */
    void readUfok(Scanner reader) {
        String line = reader.nextLine();
        while (!line.equals("RAKTER")) {
            String[] temp = line.split(" ");
            Ufo u = new Ufo((Aszteroida) NamesMap.get(temp[1]));
            NamesMap.put(temp[0], u);
            line = reader.nextLine();
        }

    }

    /**
     * A rakterek beolvasasa
     */
    void readRakter(Scanner reader) {
        while (reader.hasNextLine()) {
            String line = reader.nextLine();
            String[] temp = line.split(" ");


            if ("Telepes".equals(NamesMap.get(temp[0]).getClass().getSimpleName())) {
                if (NamesMap.get(temp[1]).getClass().getSimpleName().equals("Teleportkapu"))
                    ((Telepes) NamesMap.get(temp[0])).SetTeleportkapuRakter((Teleportkapu) NamesMap.get(temp[1]));
                else ((Telepes) NamesMap.get(temp[0])).SetNyersanyagRakter((Nyersanyag) NamesMap.get(temp[1]));
            } else {
                ((Ufo) NamesMap.get(temp[0])).AddNyersanyagRakter((Nyersanyag) NamesMap.get(temp[1]));
            }

        }

    }

    /**
     * A jatek ciklusa, a korok mukodeset kezeli
     */
    void gameCycle() {
        int korokSzama = 1;
        System.out.println(korokSzama + ". Kor");

        boolean fut = Palya.Kor();


        while (fut) {

            System.out.println("Szeretne valamit tenni a korben? (show)");


            String line = sc.nextLine();
            
            String[] cmd = line.split(" ");

            DoCommand(cmd);

            System.out.println(++korokSzama + ". Kor");
            fut = Palya.Kor();

        }

    }


}
