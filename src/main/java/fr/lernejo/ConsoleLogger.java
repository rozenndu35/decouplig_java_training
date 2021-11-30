package fr.lernejo;

import fr.lernejo.logger.Logger;

public class ConsoleLogger implements Logger {
    @Override
    public void log(String message) {
        System.out.println(message);
    }
}
