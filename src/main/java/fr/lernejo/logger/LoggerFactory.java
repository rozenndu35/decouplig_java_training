package fr.lernejo;

import fr.lernejo.logger.ContextualLogger;
import fr.lernejo.logger.Logger;

public class LoggerFactory {
    public static Logger getLogger(String name){
        return new CompositeLogger(new ContextualLogger(name , new FileLogger("../LoggerApp.txt")), new ContextualLogger(name , new ConsoleLogger())) ;
    }
}
