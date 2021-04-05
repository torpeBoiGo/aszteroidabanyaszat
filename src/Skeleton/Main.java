package Skeleton;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import java.util.Objects;
import java.util.Scanner;
import java.util.Set;


public class Main {
	static HashMap<String, Object> NamesMap = new HashMap<String, Object>();
    public static void main(String[] args) {
    	Scanner sc  = new Scanner(System.in);
    	
    	
		while(true) {
			String line=sc.nextLine();
			String cmd[]=line.split(" ");
			//System.out.println(cmd[0] + " parancs, " + cmd.length + " szo a bemenet");
			if(cmd[0] == "exit") break;
			
			if ("palya".equals(cmd[0])) {
				if ("load".equals(cmd[1])) {					
					//palya load <fajl>
					//cmd[2] -ben kell a fajlnev legyen
				}else if ("do".equals(cmd[1])) {
					if ("napvihar".equals(cmd[2])) {
						if (cmd.length < 4) {
							Palya.Napvihar();
						}else {
							Palya.Napvihar((Aszteroida)NamesMap.get(cmd[3]));
						}
					}else if ("kor".equals(cmd[2])) {
						Palya.Kor();
					} 
				} 
			}else if ("aszteroida".equals(cmd[0])) {
				Aszteroida aszteroida = (Aszteroida)(NamesMap.get(cmd[2]));
				if ("create".equals(cmd[1])) {
					Aszteroida aszteroidaNew = new Aszteroida();
					NamesMap.put(cmd[2], aszteroidaNew);
				}else if ("set".equals(cmd[1])) {
					if ("kulsoRetegek".equals(cmd[2])) {
						
						aszteroida.kulsoRetegek = Integer.parseInt(cmd[3]);
					}else if ("napkozelben".equals(cmd[2])) {
						if(Integer.parseInt(cmd[3]) == 1)
							aszteroida.napkozelben = true;
						else aszteroida.napkozelben = false;
					} 
				}else if ("add".equals(cmd[1])) {
					if ("mag".equals(cmd[2])) {
						Nyersanyag ny = (Nyersanyag)NamesMap.get(cmd[3]);
						aszteroida.AddMag(ny);
					}else if ("hajo".equals(cmd[2])) {
						Hajo h = (Hajo)NamesMap.get(cmd[3]);
						aszteroida.HajoErkezik(h);
					}
				}else if ("connect".equals(cmd[1])) {
					Aszteroida aszteroida2 = (Aszteroida)NamesMap.get(cmd[3]);
					aszteroida.AddSzomszed(aszteroida2);
					aszteroida2.AddSzomszed(aszteroida);
				} 
			}else if ("hajo".equals(cmd[0])) {
				 Hajo hajo = (Hajo)NamesMap.get(cmd[2]);
				 if ("mozog".equals(cmd[1])) {
					Mezo mezo = (Mezo)NamesMap.get(cmd[3]);
					hajo.Mozog(mezo);
				}else  if ("tetlen".equals(cmd[1])) {
					hajo.Tetlen();
				} 
			}else if ("robot".equals(cmd[0])) {
				 if ("fur".equals(cmd[1])) {
					Robot robot = (Robot)NamesMap.get(cmd[2]);
					robot.Fur();
				 } 
			}else if ("telepes".equals(cmd[0])) {
				Telepes telepes = (Telepes)NamesMap.get(cmd[2]);
				 if ("create".equals(cmd[1])) {
					 Telepes telepesNew = new Telepes((Aszteroida)NamesMap.get(cmd[3]));
					 NamesMap.put(cmd[2], telepesNew);
				 }else if ("addToRakter".equals(cmd[1])) {
						telepes.AddRakter((Szallithato)NamesMap.get(cmd[3]));
				 }else if ("robotEpit".equals(cmd[1])) {
						telepes.RobotEpit(new RobotEpito());
				 }else if ("teleportEpit".equals(cmd[1])) {
						telepes.TeleportEpit(new TeleportEpito());
				 }else if ("anyagVisszatesz".equals(cmd[1])) {
					 	Nyersanyag nyersanyag = (Nyersanyag)NamesMap.get(cmd[3]);
						telepes.AnyagVisszatesz(nyersanyag);
				 }else if ("fur".equals(cmd[1])) {
						telepes.Fur();
				 }else if ("banyasz".equals(cmd[1])) {
						telepes.Banyasz();
				 }else if ("kapuLerak".equals(cmd[1])) {
						telepes.KapuLerak((Teleportkapu)NamesMap.get(cmd[3]));
				 }else if ("addToRakter".equals(cmd[1])) {
						telepes.AddRakter((Szallithato)NamesMap.get(cmd[3]));
				 }
			}else if ("teleportkapu".equals(cmd[0])) {
				if ("create".equals(cmd[1])) {
					Teleportkapu teleportkapuNew = new Teleportkapu();
					NamesMap.put(cmd[2], teleportkapuNew);
				}else if ("connect".equals(cmd[1])) {
						Teleportkapu teleportkapu = (Teleportkapu)NamesMap.get(cmd[2]);
						Teleportkapu tp2 = (Teleportkapu)NamesMap.get(cmd[3]);
						teleportkapu.SetPar(tp2);
						tp2.SetPar(teleportkapu);
				}else if ("set".equals(cmd[1])) {
					if ("sajatAszteroida".equals(cmd[2])) {
						Teleportkapu teleportkapu = (Teleportkapu)NamesMap.get(cmd[3]);
						Aszteroida aszteroida = (Aszteroida)NamesMap.get(cmd[2]);
						teleportkapu.SetSajatAszteroida(aszteroida);
					}
				}
			}else if ("nyersanyag".equals(cmd[0])) {
				if ("create".equals(cmd[1])) {
					Nyersanyag a = null;
					if("vas".equals(cmd[3])) {
						a = new Vas();
					}else if("vizjeg".equals(cmd[3])) {
						a = new Vizjeg();
					}else if("szen".equals(cmd[3])) {
						a = new Szen();
					}else if("uran".equals(cmd[3])) {
						a = new Uran();
					}
					NamesMap.put(cmd[2], a);
				}
			}else if ("show".equals(cmd[0])) {
				Showable showable = (Showable)NamesMap.get(cmd[1]);
		    	System.out.println(cmd[1]+ ": " + showable.getClass().getSimpleName());
				showable.Show();
				System.out.println();
			}else if ("run".equals(cmd[0])) {
				
			}else if ("save".equals(cmd[0])) {
				if ("output".equals(cmd[1])) {
					
				}
			}else System.out.println("Helytelen bemenet!");
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
            	if(!e.getMessage().equals("Kilepes")) {
            		System.out.println(e.getMessage());
	                //Igy latjuk ha error jon
	                System.out.println(e.toString());
            	}
            		
                
            }
            SkeletonController.NamesMap.clear();
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
}
