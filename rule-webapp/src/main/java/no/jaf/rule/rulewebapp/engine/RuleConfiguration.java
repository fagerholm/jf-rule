package no.jaf.rule.rulewebapp.engine;

import java.util.List;

public class RuleConfiguration {

    private String name;
    private List<String> requiredFields;

    public RuleConfiguration(String name, List<String> requiredFields){

        this.name = name;
        this.requiredFields = requiredFields;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getRequiredFields() {
        return requiredFields;
    }

    public void setRequiredFields(List<String> requiredFields) {
        this.requiredFields = requiredFields;
    }
}
