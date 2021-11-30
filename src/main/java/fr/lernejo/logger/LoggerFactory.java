package fr.lernejo;

import fr.lernejo.logger.Logger;

public class LoggerFactory {
    public static Logger getLogger(String name){
        return new ConsoleLogger();
    }
}
