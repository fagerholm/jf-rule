package no.acntech.rule.core;

public class RuleEngineException extends RuntimeException{

    public RuleEngineException(String message) {
        super(message);
    }

    public RuleEngineException(String message, Throwable cause) {
        super(message, cause);
    }

}
