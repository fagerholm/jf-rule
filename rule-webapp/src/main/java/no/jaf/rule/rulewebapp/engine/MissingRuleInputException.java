package no.jaf.rule.rulewebapp.engine;

import java.util.List;

public class MissingRuleInputException extends RuntimeException{

    private final List<String> requiredInput;
    private final List<String> missingInput;
    private final String ruleName;


    public MissingRuleInputException(String ruleName, List<String> requiredInput, List<String> missingInput) {


        super(String.format("Rule [%s] is missing required data for execution. Missing data: %s. Required data: %s", ruleName, missingInput, requiredInput));
        this.requiredInput = requiredInput;
        this.missingInput = requiredInput;
        this.ruleName= ruleName;
    }

    public List<String> getRequiredInput() {
        return requiredInput;
    }

    public List<String> getMissingInput() {
        return missingInput;
    }


}
