package fr.lernejo.logger;

import java.util.function.Predicate;

import fr.lernejo.logger.Logger;

public class FilteredLogger implements Logger{

	private Logger delegate;
	private Predicate<String> condition;
	
	public FilteredLogger(Logger delegate, Predicate<String> condition) {
		  this.condition = condition;
		  this.delegate = delegate;
		}
	
	@Override
	public void log(String message) {
		if (this.condition.test(message)) {
			this.delegate.log(message);
		}
		
	}

}
