package fr.lernejo.logger;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ContextualLogger implements Logger{
	
	private String nom;
	private Logger autherLogger;

    public ContextualLogger(String p_nom, Logger p_autherLogger) {
    	this.nom = p_nom;
    	this.autherLogger = p_autherLogger;
    }
    @Override
    public void log(String message) {
    	
    	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd_HHmm");

    	this.autherLogger.log(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS")) + " " + this.nom + " " + message);
    }
}
