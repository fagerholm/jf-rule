package no.jaf.rule.rulewebapp.engine;

public class RuleEngineException extends RuntimeException{

    public RuleEngineException(String message) {
        super(message);
    }

    public RuleEngineException(String message, Throwable cause) {
        super(message, cause);
    }

}
