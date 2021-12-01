package fr.lernejo;

import fr.lernejo.guessgame.Player;
import fr.lernejo.logger.Logger;

public class Simulation {

    private final Logger logger = LoggerFactory.getLogger("simulation");
    private final Player player;
    private long numberToGuess;

    public Simulation(Player player) {
        this.player = player;
    }

    public void initialize(long numberToGuess) {
    	logger.log("Simulation: l'age du capitaine a trouver est " + numberToGuess);
        this.numberToGuess = numberToGuess;
    }

    /**
     * @return true if the player have guessed the right number
     */
    private boolean nextRound() {
        long ageTest = this.player.askNextGuess();
        logger.log("Simulation : age saisie par l'utilisateur: " + ageTest);
        if (ageTest == this.numberToGuess){
            logger.log("Simulation : l'age du capitaine est : " + ageTest);
            return true;
        }else if (ageTest > this.numberToGuess){
            logger.log("Simulation: l'age du capitaine est plus petit");
            this.player.respond(true);
        }else{
            logger.log("Simulation: l'age du capitaine est plus grand");
            this.player.respond(false);
        }
        return false;
    }

    public void loopUntilPlayerSucceed() {
        boolean trouver = false;
        while (!trouver){
            trouver = nextRound();
        }
    }
}
