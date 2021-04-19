package Skeleton;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.Map.Entry;


public class Jatek {
    static HashMap<String, Object> NamesMap = new HashMap<>();
    //Store names so we can check if sg is null.
    //TODO nem biztos hogy kell!!!
    static ArrayList<String> ObjectNames = new ArrayList<>();
    Palya palya = new Palya();

    static Scanner sc = new Scanner(System.in);


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





    private void DoCommand(String[] cmd) {
        //System.out.println(cmd[0] + " parancs, " + cmd.length + " szo a bemenet");

        if ("palya".equals(cmd[0])) {
            if ("load".equals(cmd[1])) {
                loadPalyaFromFile(cmd[2]);
                //cmd[2] -ben kell a fajlnev legyen
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
                    aszteroida = (Aszteroida) (NamesMap.get(cmd[3]));    // azert kell, mert mas a parancs hossza, a 3. szo az aszterioda neve
                    aszteroida.kulsoRetegek = Integer.parseInt(cmd[4]);
                } else if ("napkozelben".equals(cmd[2])) {
                    aszteroida = (Aszteroida) (NamesMap.get(cmd[3]));    // azert kell, mert mas a parancs hossza, a 3. szo az aszterioda neve
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
                ufo.Banyasz();;
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
                for (String key : NamesMap.keySet()) {
                    System.out.println(key + ": " + NamesMap.get(key).getClass().getSimpleName());
                    System.out.println(NamesMap.get(key));
                }
            } else {
                //ToString magic
                if (NamesMap.get(cmd[1]) != null)
                    System.out.println(cmd[1] + ": " + NamesMap.get(cmd[1]).getClass().getSimpleName());
                System.out.println(NamesMap.get(cmd[1]));
            }

        } else if ("run".equals(cmd[0])) {

        } else if ("save".equals(cmd[0])) {
            if ("output".equals(cmd[1])) {

            }
        } else System.out.println("Helytelen bemenet!");

    }

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
                throw new RuntimeException("Bad file format");
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            e.printStackTrace();
        }

    }

    void readNyersanyagok(Scanner reader) { //Uran expozicio szamat kell meg lekezelni
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
                    //temp[2]
                    break;
            }
            line = reader.nextLine();
        }

    }

    void readAszteroidak(Scanner reader) { //itt egy aszteroidákbl álló arraylistet kéne visszaadni
        String line = reader.nextLine();
        while (!line.equals("TELEPORTKAPUK")) {
            String[] temp = line.split(" ");


            Aszteroida a = new Aszteroida(Integer.parseInt(temp[1]), ("napkozelben".equals(temp[3])));


            a.SetMag((Nyersanyag) NamesMap.get(temp[2]));
            NamesMap.put(temp[0], a);

            line = reader.nextLine();
        }

    }

    void readTeleportkapuk(Scanner reader) {
        ArrayList<Teleportkapu> teleportkapuk = new ArrayList<>();
        String line = reader.nextLine();
        while (!line.equals("SZOMSZEDOK")) {
            String[] temp = line.split(" ");
            //0 aszteroida hibakezeles
            Aszteroida a1, a2;
            Teleportkapu k1, k2;
            if (temp[1].equals("0")) {
                k1 = new Teleportkapu(Boolean.parseBoolean(temp[2]));
            } else {
                a1 = (Aszteroida) NamesMap.get(temp[1]);
                if ("megkergult".equals(temp[2]))
                    k1 = new Teleportkapu(a1, true);
                else k1 = new Teleportkapu(a1, false); // akarmire ami nem megkergul, azt mondja hogy nem kergul meg
            }
            if (temp[4].equals("0")) {
                k2 = new Teleportkapu(Boolean.parseBoolean(temp[4]));
            } else {
                a2 = (Aszteroida) NamesMap.get(temp[4]);

                if ("megkergult".equals(temp[5]))
                    k2 = new Teleportkapu(a2, true);
                else k2 = new Teleportkapu(a2, false); // akarmire ami nem megkergul, azt mondja hogy nem kergul meg
                //k2 = new Teleportkapu(a2, Boolean.parseBoolean(temp[5]));
            }

            k1.SetPar(k2);
            k2.SetPar(k1);

            NamesMap.put(temp[0], k1);
            NamesMap.put(temp[3], k2);

            line = reader.nextLine();

        }

    }

    //TODO
    void readSzomszedok(Scanner reader) {
        String line = reader.nextLine();
        while (!line.equals("TELEPESEK")) {
            String[] temp = line.split(" ");
            ((Aszteroida) NamesMap.get(temp[0])).AddSzomszed((Mezo) NamesMap.get(temp[1]));
            ((Aszteroida) NamesMap.get(temp[1])).AddSzomszed((Mezo) NamesMap.get(temp[0])); //ez rossz a masodik nem biztos h aszteroida tc

            line = reader.nextLine();
        }

    }

    void readTelepesek(Scanner reader) {
        String line = reader.nextLine();
        while (!line.equals("ROBOTOK")) {
            String[] temp = line.split(" ");
            Telepes t = new Telepes((Aszteroida) NamesMap.get(temp[1]));
            NamesMap.put(temp[0], t);
            line = reader.nextLine();
        }

    }

    void readRobotok(Scanner reader) {
        String line = reader.nextLine();
        while (!line.equals("UFOK")) {
            String[] temp = line.split(" ");
            Robot r = new Robot((Aszteroida) NamesMap.get(temp[1]));
            NamesMap.put(temp[0], r);
            line = reader.nextLine();
        }

    }

    void readUfok(Scanner reader) {
        String line = reader.nextLine();
        while (!line.equals("RAKTER")) {
            String[] temp = line.split(" ");
            Ufo u = new Ufo((Aszteroida) NamesMap.get(temp[1]));
            NamesMap.put(temp[0], u);
            line = reader.nextLine();
        }

    }

    //TODO
    void readRakter(Scanner reader) { //problemas lehet itt

        while (reader.hasNextLine()) {
            String line = reader.nextLine();
            String[] temp = line.split(" ");

            //TODO ez igy eleg megkerdojelezheto....
            if (NamesMap.get(temp[1]).getClass().getSimpleName().equals("Teleportkapu"))
                ((Telepes) NamesMap.get(temp[0])).SetTeleportkapuRakter((Teleportkapu) NamesMap.get(temp[1]));
            else ((Telepes) NamesMap.get(temp[0])).SetNyersanyagRakter((Nyersanyag) NamesMap.get(temp[1]));
            //TODO ^ ez elszáll exceptionnel Teszteset42-ben
        }

    }


    public static <T, E> T getKeyByValue(Map<T, E> map, E value) {
        for (Entry<T, E> entry : map.entrySet()) {
            if (Objects.equals(value, entry.getValue())) {
                return entry.getKey();
            }
        }
        return null;
    }


    void gameCycle() {  //TODO ez lehet hogy nem fog tetszeni egyeseknek, mélységes elnézést, hogy számra vettem bool nevét
        int korokSzama = 1;
        System.out.println(korokSzama + ". Kor");
        boolean fut = Palya.Kor();

        while (fut) {

            System.out.println("Szeretne valamit tenni a korben? (show)");//TODO ez teljesen most dokumentálatlan

            String line = sc.nextLine();
            String[] cmd = line.split(" ");

            DoCommand(cmd);

            System.out.println(++korokSzama + ". Kor");
            fut = Palya.Kor();

        }

    }


}
