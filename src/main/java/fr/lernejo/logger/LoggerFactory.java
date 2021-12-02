package fr.lernejo.logger;

import java.util.function.Predicate;

import fr.lernejo.ConsoleLogger;
import fr.lernejo.FileLogger;
import fr.lernejo.logger.ContextualLogger;
import fr.lernejo.logger.Logger;

public class LoggerFactory {
    public static Logger getLogger(String name){
        Predicate<String> condition = message -> message.contains("simulation");
        Logger fileLogger = new ContextualLogger(name, new FileLogger("../LoggerApp.txt"));
        Logger consoleLogger = new ContextualLogger(name , new FilteredLogger(new ConsoleLogger(), condition));
        
        return new CompositeLogger(fileLogger, consoleLogger) ;
    }
}
