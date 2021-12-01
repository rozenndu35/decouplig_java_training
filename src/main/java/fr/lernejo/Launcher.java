package fr.lernejo;

import fr.lernejo.guessgame.Player;

import java.security.SecureRandom;

public class Launcher {
    private final Logger logger = LoggerFactory.getLogger("launcher");

    public static void main(String args[]){
        logger.log("launcher : Bienvenu");
        Player humain = new HumanPlayer();
        Simulation simul = new Simulation(humain);
        SecureRandom random = new SecureRandom();
        long nombreAleatoire = random.nextInt(100);

        simul.initialize(nombreAleatoire);
        logger.log("launcher : le jeu est initialiser");
        simul.loopUntilPlayerSucceed();
    }
}
