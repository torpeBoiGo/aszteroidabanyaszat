package Skeleton;

import javax.naming.Name;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;


public class Main {
    static HashMap<String, Object> NamesMap = new HashMap<String, Object>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        while (true) {
            String line = sc.nextLine();
            String cmd[] = line.split(" ");
            //System.out.println(cmd[0] + " parancs, " + cmd.length + " szo a bemenet");
            if (cmd[0] == "exit") break;

            if ("palya".equals(cmd[0])) {
                if ("load".equals(cmd[1])) {
                    //palya load <fajl>
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
                    }
                }
            } else if ("aszteroida".equals(cmd[0])) {
                Aszteroida aszteroida = (Aszteroida) (NamesMap.get(cmd[2]));
                if ("create".equals(cmd[1])) {
                    Aszteroida aszteroidaNew = new Aszteroida();
                    NamesMap.put(cmd[3], aszteroidaNew);
                } else if ("set".equals(cmd[1])) {
                    if ("kulsoRetegek".equals(cmd[2])) {

                        aszteroida.kulsoRetegek = Integer.parseInt(cmd[3]);
                    } else if ("napkozelben".equals(cmd[2])) {
                        if (Integer.parseInt(cmd[3]) == 1)
                            aszteroida.napkozelben = true;
                        else aszteroida.napkozelben = false;
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
                }
            } else if ("robot".equals(cmd[0])) {
                if ("fur".equals(cmd[1])) {
                    Robot robot = (Robot) NamesMap.get(cmd[2]);
                    robot.Fur();
                }
            } else if ("telepes".equals(cmd[0])) {
                Telepes telepes = (Telepes) NamesMap.get(cmd[2]);
                if ("create".equals(cmd[1])) {
                    Telepes telepesNew = new Telepes();
                    NamesMap.put(cmd[2], telepesNew);
                } else if ("addToRakter".equals(cmd[1])) {
                    telepes.AddRakter((Szallithato) NamesMap.get(cmd[3]));
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
                } else if ("addToRakter".equals(cmd[1])) {
                    telepes.AddRakter((Szallithato) NamesMap.get(cmd[3]));
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

            } else if ("run".equals(cmd[0])) {

            } else if ("save".equals(cmd[0])) {
                if ("output".equals(cmd[1])) {

                }
            } else System.out.println("Helytelen bemenet!");
        }
        sc.close();
    }


    void Skeleton() {
        int chosen = -1;
        ArrayList<MenuItem> menuItems = new ArrayList<MenuItem>();
        menuItems.add(new MenuItem("Kilepes", SkeletonController::Kilepes));
        menuItems.add(new MenuItem("Telepes tetlen", SkeletonController::TelepesTetlen));
        menuItems.add(new MenuItem("Telepes mozog teleporton keresztul", SkeletonController::TelepesMozogTeleport));
        menuItems.add(new MenuItem("Robot mozog teleporton keresztul", SkeletonController::RobotMozogTeleport));
        menuItems.add(new MenuItem("Telepes mozog szomszedos aszteroidara", SkeletonController::TelepesMozogSzomszedosAszteroidara));
        menuItems.add(new MenuItem("Robot mozog szomszedos aszteroidara", SkeletonController::RobotMozogSzomszedosAszteroidara));
        menuItems.add(new MenuItem("Telepes lerak teleportkaput", SkeletonController::TelepesTeleport));
        menuItems.add(new MenuItem("Telepes robotot epit", SkeletonController::TelepesRobototEpit));
        menuItems.add(new MenuItem("Telepes teleportkaput epit", SkeletonController::TelepesTeleportkaputEpit));
        menuItems.add(new MenuItem("Telepes banyaszik szenet", SkeletonController::TelepesBanyaszikSzenet));
        menuItems.add(new MenuItem("Telepes banyaszik vasat", SkeletonController::TelepesBanyaszikVasat));
        menuItems.add(new MenuItem("Telepes banyaszik urant", SkeletonController::TelepesBanyaszikUrant));
        menuItems.add(new MenuItem("Telepes banyaszik vizjeget", SkeletonController::TelepesBanyaszikVizjeget));
        menuItems.add(new MenuItem("Telepes lerak szenet", SkeletonController::TelepesLerakSzenet));
        menuItems.add(new MenuItem("Telepes lerak vasat", SkeletonController::TelepesLerakVasat));
        menuItems.add(new MenuItem("Telepes lerak vizjeges", SkeletonController::TelepesLerakVizjeget));
        menuItems.add(new MenuItem("Telepes lerak urant", SkeletonController::TelepesLerakUrant));

        menuItems.add(new MenuItem("Telepes furja a vasat tartalmazo aszteroidat", SkeletonController::TelepesFurVasat));
        menuItems.add(new MenuItem("Telepes furja a szenet tartalmazo aszteroidat", SkeletonController::TelepesFurSzenet));
        menuItems.add(new MenuItem("Telepes furja a vizjeget tartalmazo aszteroidat", SkeletonController::TelepesFurVizjeget));
        menuItems.add(new MenuItem("Telepes furja az urant tartalmazo aszteroidat", SkeletonController::TelepesFurUrant));
        menuItems.add(new MenuItem("Robot furja a vasat tartalmazo aszteroidat", SkeletonController::RobotFurVasat));
        menuItems.add(new MenuItem("Robot furja a szenet tartalmazo aszteroidat", SkeletonController::RobotFurSzenet));
        menuItems.add(new MenuItem("Robot furja a vizjeget tartalmazo aszteroidat", SkeletonController::RobotFurVizjeget));
        menuItems.add(new MenuItem("Robot furja az urant tartalmazo aszteroidat", SkeletonController::RobotFurUrant));

        menuItems.add(new MenuItem("Telepes meghal - tarolojaban a teleportkapu par egyik fele van csak ", SkeletonController::TelepesMeghalKapuKulon));
        menuItems.add(new MenuItem("Telepes meghal - tarolojaban van a teleportkapu par mindket fele", SkeletonController::TelepesMeghalKapupar));

        menuItems.add(new MenuItem("Napvihar olyan aszteroidat er, amin telepes van", SkeletonController::NapviharAszteroidaraTelepesre));
        menuItems.add(new MenuItem("Napvihar olyan aszteroidat er, amin robot van", SkeletonController::NapviharAszteroidaraRobotra));

        /* *
         *Beolvas egy szamot es lefuttatja a hozza tartozo fuggvenyt
         *
         */
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (chosen != 0) {
            System.out.println("Kerlek valassz egy opciot!\n");
            for (int i = 0; i < menuItems.size(); i++)
                System.out.println(i + ". " + menuItems.get(i).name);
            System.out.print("Valasztas: ");
            try {
                String line = reader.readLine();
                chosen = Integer.parseInt(String.valueOf(line));
            } catch (Exception e) {
                System.out.println(e.getMessage());
                chosen = 0;
            }

            try {
                menuItems.get(chosen).toCall.run();
            } catch (Exception e) {
                if (!e.getMessage().equals("Kilepes")) {
                    System.out.println(e.getMessage());
                    //Igy latjuk ha error jon
                    System.out.println(e.toString());
                }


            }
            SkeletonController.NamesMap.clear();
        }
    }


    void IOstream(String fileName) {
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
                    Uran u = new Uran();
                    NamesMap.put(temp[1], u);
                    //temp[2]
                    break;
            }
            line = reader.nextLine();
        }

    }

    void readAszteroidak(Scanner reader) { //itt egy aszteroidákbl álló arraylistet kéne visszaadni
        ArrayList<Aszteroida> aszteroidak = new ArrayList<Aszteroida>(); //HASHMAP
        String line = reader.nextLine();
        while (!line.equals("TELEPORTKAPUK")) {
            String[] temp = line.split(" ");
            Aszteroida a = new Aszteroida(Integer.parseInt(temp[1]), Boolean.parseBoolean(temp[3]));
            a.SetMag((Nyersanyag) NamesMap.get(temp[2]));
            NamesMap.put(temp[0], a);

            line = reader.nextLine();
        }

    }

    void readTeleportkapuk(Scanner reader) {
        ArrayList<Teleportkapu> teleportkapuk = new ArrayList<Teleportkapu>();
        String line = reader.nextLine();
        while (!line.equals("SZOMSZEDOK")) {
            String[] temp = line.split(" ");
            //0 aszteroida hibakezeles
            Aszteroida a1, a2;
            if (temp[1].equals("0")) {
                a1 = null;
            } else {
                a1 = (Aszteroida) NamesMap.get(temp[1]);
            }
            if (temp[4].equals("0")) {
                a2 = null;
            } else {
                a2 = (Aszteroida) NamesMap.get(temp[4]);
            }
            Teleportkapu k1 = new Teleportkapu(a1, Boolean.parseBoolean(temp[2]));
            Teleportkapu k2 = new Teleportkapu(a2, Boolean.parseBoolean(temp[5]));

            k1.SetPar(k2);
            k2.SetPar(k1);

            NamesMap.put(temp[0], k1);
            NamesMap.put(temp[3], k2);

            line = reader.nextLine();

        }

    }

    void readSzomszedok(Scanner reader) {
        String line = reader.nextLine();
        while (!line.equals("TELEPESEK")) {
			String[] temp = line.split(" ");
			((Aszteroida) NamesMap.get(temp[0])).addSzomszed((Mezo)NamesMap.get(temp[1]));
			((Aszteroida) NamesMap.get(temp[1])).addSzomszed((Mezo)NamesMap.get(temp[0])); //ez rossz a masodik nem biztos h aszteroida tc

            line = reader.nextLine();
        }

    }

    void readTelepesek(Scanner reader) {
        String line = reader.nextLine();
        while (!line.equals("ROBOTOK")) {
			String[] temp = line.split(" ");
			Telepes t = new Telepes((Aszteroida)NamesMap.get(temp[1]));
			NamesMap.put(temp[0], t);
            line = reader.nextLine();
        }

    }

    void readRobotok(Scanner reader) {
		String line = reader.nextLine();
		while (!line.equals("UFOK")) {
			String[] temp = line.split(" ");
			Robot r = new Robot((Aszteroida)NamesMap.get(temp[1]));
			NamesMap.put(temp[0], r);
			line = reader.nextLine();
		}

    }

    void readUfok(Scanner reader) {
		String line = reader.nextLine();
		while (!line.equals("RAKTER")) {
			String[] temp = line.split(" ");
			//Ufo u = new Ufo((Aszteroida)NamesMap.get(temp[1]));
			//NamesMap.put(temp[0], u);
			line = reader.nextLine();
		}

    }

    void readRakter(Scanner reader) { //problemas lehet itt

        while (reader.hasNextLine()) {
			String line = reader.nextLine();
			String[] temp = line.split(" ");
			((Telepes)NamesMap.get(temp[0])).AddRakter((Szallithato)NamesMap.get(temp[1]));
        }

    }


}
