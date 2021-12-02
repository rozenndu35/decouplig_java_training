package fr.lernejo;

import fr.lernejo.guessgame.Player;
import fr.lernejo.logger.Logger;
import fr.lernejo.logger.LoggerFactory;

import java.util.Scanner;

public class HumanPlayer implements Player {
    private final Logger logger = LoggerFactory.getLogger("player");
    private Scanner scan = new Scanner(System.in);

    @Override
    public long askNextGuess() {
        logger.log("saisie de l'age : ");
        System.out.println("Saisir un age du capitaine");
        long age = scan.nextLong();
        logger.log("Age saisie : " + age);
        return age;
    }

    @Override
    public void respond(boolean lowerOrGreater) {
        if (lowerOrGreater) {
            logger.log("Age saisie est trop grand ");
            System.out.println("Plus petit");
        }else{
            logger.log("Age saisie est trop petit ");
            System.out.println("Plus grand");
        }
    }
}
