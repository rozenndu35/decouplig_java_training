package fr.lernejo;

import fr.lernejo.guessgame.Player;
import fr.lernejo.logger.Logger;

import java.security.SecureRandom;

public class Launcher {
    private final Logger logger = LoggerFactory.getLogger("launcher");
    private static long MAX_VALUE = 10;
    private static Logger logger = LoggerFactory.getLogger("launcher");

    public static void main(String args[]){
        logger.log("Bienvenu");
        if ( args.length > 0 && args[0].equals("-interactive")){
            logger.log("choix d'un humain");
            SecureRandom random = new SecureRandom();
            long nombreAleatoire = random.nextInt(100);
            Player humain = new HumanPlayer();
            Simulation simul = new Simulation(humain, MAX_VALUE);
            simul.initialize(nombreAleatoire);
            logger.log("le jeu est initialiser");
            simul.loopUntilPlayerSucceed();
        }else if (args.length > 0 && args[0].equals("-auto")){
            try{                
                long nombreAleatoire = Long.parseLong(args[1]);
                logger.log("choix d'un ordinateur");
                Player ordinateur = new ComputerPlayer();
                Simulation simul = new Simulation(ordinateur, 100);
                simul.initialize(nombreAleatoire);
                logger.log("le jeu est initialiser");
                simul.loopUntilPlayerSucceed();
            }catch ( Exception e){
            	logger.log(e.getClass().getName() + " - " + e.getMessage());
                help();
            }

        }else{
            help();
        }
    }

    public static void help(){
        logger.log("erreur affichage de l'aide");
        System.out.println("Pour lancer en mode player : -interactive");
        System.out.println("Pour lancer en mode ordinateur : -auto long");

    }
}
