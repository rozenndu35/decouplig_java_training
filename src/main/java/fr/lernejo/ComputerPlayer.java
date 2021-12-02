package fr.lernejo;

import fr.lernejo.guessgame.Player;
import fr.lernejo.logger.Logger;

public class ComputerPlayer implements Player {

    private final Logger logger = LoggerFactory.getLogger("player");
    long max = 100;
    long min = 0;
    long oldAge;

    @Override
    public long askNextGuess() {
        logger.log("saisie de l'age : ");
        if (this.max == this.min){
            this.oldAge = max;
        }else{
            long choisPossible = this.max - this.min;
            long choix = choisPossible / 2;
            this.oldAge = this.min + choix;
        }
        logger.log("Age saisie : " + age);
        return this.oldAge;
    }

    @Override
    public void respond(boolean lowerOrGreater) {
        if (lowerOrGreater) {
            logger.log("Age saisie est trop grand ");
            this.max = this.oldAge;
        }else{
            logger.log("Age saisie est trop petit ");
            this.min = this.oldAge;
        }
    }
}
