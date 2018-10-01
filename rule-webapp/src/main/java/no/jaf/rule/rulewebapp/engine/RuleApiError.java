package no.jaf.rule.rulewebapp.engine;

import org.springframework.http.HttpStatus;

public class RuleApiError {

    private HttpStatus status;
    private String message;

    public RuleApiError(HttpStatus status, String message) {
        super();
        this.status = status;
        this.message = message;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }
}
