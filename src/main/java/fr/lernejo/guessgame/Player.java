package fr.lernejo.guessgame;

public interface Player {

    long askNextGuess();

    /**
     * Called by {@link Simulation} to inform that the previous guess was lower or greater that the number to find.
     * @param lowerOrGreater : true if is lower false if is grater
     */
    void respond(boolean lowerOrGreater);
}
