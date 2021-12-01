package fr.lernejo;

import fr.lernejo.guessgame.Player;

import java.security.SecureRandom;

public class Launcher {
    private final Logger logger = LoggerFactory.getLogger("launcher");
    private static long MAX_VALUE = 10;

    public static void main(String args[]){
        logger.log("launcher : Bienvenu");
        if ( args.length > 0 && args[0].equals("-interactive")){
            logger.log("launcher : choix d'un humain");
            SecureRandom random = new SecureRandom();
            long nombreAleatoire = random.nextInt(100);
            Player humain = new HumanPlayer();
            Simulation simul = new Simulation(humain, MAX_VALUE);
            simul.initialize(nombreAleatoire);
            logger.log("launcher : le jeu est initialiser");
            simul.loopUntilPlayerSucceed();
        }else if (args.length > 0 && args[0].equals("-auto")){
            try{                
                long nombreAleatoire = Long.parseLong(args[1]);
                logger.log("launcher : choix d'un ordinateur");
                Player ordinateur = new ComputerPlayer();
                Simulation simul = new Simulation(ordinateur, 100);
                simul.initialize(nombreAleatoire);
                logger.log("launcher : le jeu est initialiser");
                simul.loopUntilPlayerSucceed();
            }catch ( Exception e){
                help();
            }

        }else{
            help();
        }
    }

    public static void help(){
        logger.log("launcher : erreur affichage de l'aide");
        System.out.println("Pour lancer en mode player : -interactive");
        System.out.println("Pour lancer en mode ordinateur : -auto long");

    }
}
