package fr.lernejo.logger;

import java.util.function.Predicate;

import fr.lernejo.ConsoleLogger;
import fr.lernejo.FileLogger;
import fr.lernejo.logger.ContextualLogger;
import fr.lernejo.logger.Logger;

public class LoggerFactory {
    public static Logger getLogger(String name){
        Predicate<String> condition = message -> message.contains("simulation");
        ContextualLogger logerContextFile = new ContextualLogger(name , new FileLogger("../LoggerApp.txt"));
        ContextualLogger logerContextConsol = new ContextualLogger(name , new ConsoleLogger());
        
        return new CompositeLogger(new FilteredLogger(logerContextFile, condition, name), logerContextConsol) ;
    }
}
