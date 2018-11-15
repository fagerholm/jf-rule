package no.acntech.rule.core.dto.configuration;

import java.util.*;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import no.acntech.rule.core.dto.rule.RuleSet;


public class Configuration {

    private RuleSet ruleSet;
    private List<RuleConfiguration> rules;

    @JsonCreator
    public Configuration(@JsonProperty("ruleSet") RuleSet ruleSet, @JsonProperty("rules") List<RuleConfiguration> rules ) {
        this.ruleSet = ruleSet;
        this.rules = rules;
    }

    public RuleSet getRuleSet() {
        return ruleSet;
    }

    public void setRuleSet(RuleSet ruleSet) {
        this.ruleSet = ruleSet;
    }

    public List<RuleConfiguration> getRules() {
        return rules;
    }

    public void setRules(List<RuleConfiguration> rules) {
        this.rules = rules;
    }

    @Override
    public String toString() {
        return "Configuration{" +
                "ruleSet=" + ruleSet +
                ", rules=" + rules +
                '}';
    }
}
