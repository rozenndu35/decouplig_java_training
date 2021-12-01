package fr.lernejo;

import fr.lernejo.guessgame.Player;
import fr.lernejo.logger.Logger;

import java.time.Instant;
import java.time.ZoneOffset;
import java.util.concurrent.TimeUnit;

public class Simulation {

    private final Logger logger = LoggerFactory.getLogger("simulation");
    private final Player player;
    private long numberToGuess;
    private long nombre_iteration_max;

    public Simulation(Player player, long p_nombre_iteration_max ) {
        this.player = player;
        this.nombre_iteration_max = p_nombre_iteration_max;
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
        int itération = 0;
        long lStartTime = System.currentTimeMillis();
        while (!trouver && itération < nombre_iteration_max){
            trouver = nextRound();
            itération ++;
        }
        long lEndTime = System.currentTimeMillis();
        long execution = lEndTime - lStartTime;
        String msS = String.format("%02d:%02d:%02d", TimeUnit.MILLISECONDS.toMinutes(execution),
        		TimeUnit.MILLISECONDS.toSeconds(execution) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(execution)),
                TimeUnit.MILLISECONDS.toMillis(execution) - TimeUnit.SECONDS.toSeconds(TimeUnit.MILLISECONDS.toSeconds(execution)));

        logger.log("Simulation: Nombre d'iteration : " + itération + " reussi : " + trouver);
        logger.log("Simulation: temps d'execution : " + msS);

    }
}
