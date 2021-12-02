package fr.lernejo.logger;

import java.util.function.Predicate;

import fr.lernejo.logger.Logger;

public class FilteredLogger implements Logger{

	private Logger delegate;
	private Predicate<String> condition;
	private String name;
	
	public FilteredLogger(Logger delegate, Predicate<String> condition, String name) {
		  this.condition = condition;
		  this.delegate = delegate;
		  this.name = name;
		}
	
	@Override
	public void log(String message) {
		if (this.condition.test(this.name)) {
			this.delegate.log(message);
		}
		
	}

}
