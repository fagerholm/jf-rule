package no.jaf.rule.core.service;


import no.jaf.rule.core.BusinessRule;
import no.jaf.rule.core.dto.configuration.Configuration;
import no.jaf.rule.core.dto.configuration.RuleConfiguration;
import no.jaf.rule.core.dto.rule.RuleInput;
import no.jaf.rule.core.dto.rule.RuleOutput;
import no.jaf.rule.core.dto.rule.RuleRemark;
import no.jaf.rule.core.dto.rule.RuleSet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class RuleService {

    private static final Logger COMMUNICATION_LOG = LoggerFactory.getLogger(RuleService.class);

    private final RuleActivationService ruleActivationService;

    @Autowired
    public RuleService(RuleActivationService ruleActivationService) {
        this.ruleActivationService = ruleActivationService;
    }

    public RuleOutput executeRules(RuleInput input) {

        COMMUNICATION_LOG.debug(input.toString());

        Set<BusinessRule> activatedRules = ruleActivationService.findRulesForExecution(input.getRuleset());

        List<RuleRemark> ruleSetRemarks = new ArrayList<>();
        int passedRules = 0;
        int failedRules = 0;
        for (BusinessRule rule : activatedRules) {
            List<RuleRemark> ruleRemarks = rule.execute(input);
            ruleSetRemarks.addAll(ruleRemarks);
            if (ruleRemarks.size() > 0) {
                failedRules++;
            } else {
                passedRules++;
            }
        }

        RuleOutput output = new RuleOutput();
        output.setRuleSet(input.getRuleset());
        output.setRulesIdentified(activatedRules.size());
        output.setRulesPassed(passedRules);
        output.setRulesWithRemarks(failedRules);
        output.setRuleRemarks(ruleSetRemarks);

        COMMUNICATION_LOG.debug(output.toString());
        return output;
    }

    public List<Configuration> getRuleSets(){

        List<Configuration> configurations = new ArrayList<>();

        Map<RuleSet, Set<BusinessRule>> activations = ruleActivationService.findAllRulesets();
        Set<RuleSet> ruleSetKeys = activations.keySet();

        for(RuleSet ruleSet : ruleSetKeys){
            configurations.add(new Configuration(ruleSet, getRuleConfigurations(activations.get(ruleSet))));
        }

        return configurations;
    }

    private List<RuleConfiguration> getRuleConfigurations(Set<BusinessRule> rules){

        List<RuleConfiguration> ruleConfigurations = new ArrayList<>();
        for(BusinessRule rule : rules){
            ruleConfigurations.add(new RuleConfiguration(rule.getClass().getSimpleName(), rule.getRequiredInput()));
        }

        return ruleConfigurations;
    }

    /*
    private List<String> findRuleNames(Set<BusinessRule> rules){

        List<String> ruleNames = new ArrayList<>();
        for(BusinessRule rule : rules){
            ruleNames.add(rule.getClass().getSimpleName());
        }

        return ruleNames;
    }*/

}