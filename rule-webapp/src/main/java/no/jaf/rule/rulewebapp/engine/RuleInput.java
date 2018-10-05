package no.jaf.rule.rulewebapp.engine;

import java.util.HashMap;

public class RuleInput {

    RuleSet ruleset;
    HashMap<String, String> inputData;

    public RuleSet getRuleset() {
        return ruleset;
    }

    public void setRuleset(RuleSet ruleset) {
        this.ruleset = ruleset;
    }

    public HashMap<String, String> getInputData() {
        return inputData;
    }

    public void setInputData(HashMap<String, String> inputData) {
        this.inputData = inputData;
    }

    @Override
    public String toString() {
        return "RuleInput{" +
                "ruleset=" + ruleset +
                ", inputData=" + inputData +
                '}';
    }
}
