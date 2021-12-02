package fr.lernejo.logger;

import fr.lernejo.logger.Logger;

public class CompositeLogger implements Logger{

	private Logger firstLogger;
	private Logger autherLogger;
	
	public CompositeLogger(Logger p_firstLogger, Logger p_autherLogger) {
    	this.firstLogger = p_firstLogger;
    	this.autherLogger = p_autherLogger;
    }
	@Override
	public void log(String message) {
		this.firstLogger.log( message);
    	this.autherLogger.log( message);
		
	}
}
