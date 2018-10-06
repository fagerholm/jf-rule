package no.jaf.rule.rulewebapp.rules;

import no.jaf.rule.rulewebapp.engine.BusinessRule;
import no.jaf.rule.rulewebapp.engine.Rule;
import no.jaf.rule.rulewebapp.engine.RuleEngineException;
import no.jaf.rule.rulewebapp.engine.RuleSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.lang.reflect.InvocationTargetException;
import java.util.*;

@Service
public class RuleActivationService {

    private final List<BusinessRule> rules;

    private final Map<RuleSet, Set<BusinessRule>> rulesForRuleSet = new EnumMap<>(RuleSet.class);

    @Autowired
    public RuleActivationService(List<BusinessRule> rules) {
        this.rules = rules;
    }

    public Set<BusinessRule> findRulesForExecution(RuleSet ruleSet) {
        return rulesForRuleSet.getOrDefault(ruleSet, Collections.emptySet());
    }

    public List<String> findRuleNamesForRuleset(RuleSet ruleSet) {

        List<String> ruleNames = new ArrayList<>();

        for(BusinessRule rule : rulesForRuleSet.getOrDefault(ruleSet, Collections.emptySet())){
            ruleNames.add(rule.toString());
        }
        return ruleNames;
    }

    public Map<RuleSet, Set<BusinessRule>> findAllRulesets(){
        return rulesForRuleSet;
    }


    @PostConstruct
    void init() {
        assembleRuleList();
    }


    private void assembleRuleList() {
        for (BusinessRule rule : rules) {
            if (rule.getClass().isAnnotationPresent(Rule.class)) {
                validateRuleSetup(rule);
            } else {
                throw new RuleEngineException("RuleEngine not able to start due to business rule not annotated wit @Rule");
            }
        }
    }

    private void validateRuleSetup(BusinessRule rule) {
        final Rule annotation = rule.getClass().getAnnotation(Rule.class);

        RuleSet[] rulesetsForRule;
        try {
            rulesetsForRule = (RuleSet[]) annotation.annotationType().getMethod("ruleSets").invoke(annotation);
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            throw new RuleEngineException("RuleEngine could not start because of misconfiguration of rule: " + rule.getClass().getName(), e);
        }

        for (RuleSet set : rulesetsForRule) {
            if (rulesForRuleSet.containsKey(set)) {
                rulesForRuleSet.get(set).add(rule);
            } else {
                rulesForRuleSet.put(set, new HashSet<>(Collections.singletonList(rule)));
            }
        }
    }

}
