package Skeleton;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
    	Scanner sc  = new Scanner(System.in);
		
		while(true) {
			String line=sc.nextLine();
			String cmd[]=line.split(" ");
			System.out.println(cmd[0] + " parancs, " + cmd.length + " szo a bemenet");
			if(cmd[0] == "exit") break;
			
			if ("palya".equals(cmd[0])) {
				if ("load".equals(cmd[1])) {
					//palya load <fajl>
					//cmd[2] -ben kell a fajlnev legyen
				}else if ("do".equals(cmd[1])) {
					if ("napvihar".equals(cmd[2])) {
						if (cmd.length < 4) {
							//palya do napvihar
							//mindre
						}else {
							//palya do napvihar <nev>
							//konkretra, cmd[3]-ban a neve
						}
					}else if ("kor".equals(cmd[2])) {
						//palya do kor
						
					} 
				} 
			}else if ("aszteroida".equals(cmd[0])) {
				if ("create".equals(cmd[1])) {
					//aszteroida create
				}else if ("set".equals(cmd[1])) {
					if ("kulsoRetegek".equals(cmd[2])) {
						//aszteroida set kulsoRetegek
						//cmd[3] nev , cmd[4] retegszam
					}else if ("napkozelben".equals(cmd[2])) {
						//aszteroida set napkozelben
						//cmd[3] nev , cmd[4] 0 vagy 1
					} 
				}else if ("add".equals(cmd[1])) {
					if ("mag".equals(cmd[2])) {
						//aszteroida set kulsoRetegek
						//cmd[3] nev , cmd[4] nyersanyagnev
					}else if ("hajo".equals(cmd[2])) {
						//aszteroida set kulsoRetegek
						//cmd[3] nev , cmd[4] hajonev
					}
				}else if ("connect".equals(cmd[1])) {
					//aszteroida set kulsoRetegek
					//cmd[2] szomsz1 , cmd[3] szomsz2
				} 
			}else if ("hajo".equals(cmd[0])) {
				 if ("mozog".equals(cmd[1])) {
					//aszteroida set kulsoRetegek
					//cmd[2] nev , cmd[3] hajonev
				}else  if ("tetlen".equals(cmd[1])) {
					//aszteroida set kulsoRetegek
					//cmd[2] nev 
				} 
			}else if ("robot".equals(cmd[0])) {
				 if ("fur".equals(cmd[1])) {
						//robot fur
						//cmd[2] nev 
				 } 
			}else if ("telepes".equals(cmd[0])) {
				 if ("create".equals(cmd[1])) {
						
				 }else if ("addToRakter".equals(cmd[1])) {
						
				 }else if ("robotEpit".equals(cmd[1])) {
						
				 }else if ("teleportEpit".equals(cmd[1])) {
						
				 }else if ("anyagVisszatesz".equals(cmd[1])) {
						
				 }else if ("fur".equals(cmd[1])) {
						
				 }else if ("banyasz".equals(cmd[1])) {
						
				 }else if ("kapuLerak".equals(cmd[1])) {
						
				 }else if ("addToRakter".equals(cmd[1])) {
						
				 }
			}else if ("teleportkapu".equals(cmd[0])) {
				if ("create".equals(cmd[1])) {
					
				}else if ("connect".equals(cmd[1])) {
						
				}else if ("set".equals(cmd[1])) {
					if ("sajatAszteroida".equals(cmd[2])) {
						
					}
				}
			}else if ("nyersanyag".equals(cmd[0])) {
				if ("create".equals(cmd[1])) {
					
				}
			}else if ("show".equals(cmd[0])) {
				
			}else if ("run".equals(cmd[0])) {
				
			}else if ("save".equals(cmd[1])) {
				if ("output".equals(cmd[1])) {
					
				}
			}			
		}
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
}
