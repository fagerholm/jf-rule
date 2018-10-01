package no.jaf.rule.rulewebapp.rules;

import no.jaf.rule.rulewebapp.engine.BusinessRule;
import no.jaf.rule.rulewebapp.engine.RuleInput;
import no.jaf.rule.rulewebapp.engine.RuleOutput;
import no.jaf.rule.rulewebapp.engine.RuleRemark;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Component
public class RuleService {

    private final RuleActivationService ruleActivationService;

    @Autowired
    public RuleService(RuleActivationService ruleActivationService) {
        this.ruleActivationService = ruleActivationService;
    }

    public RuleOutput executeRules(RuleInput input) {

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
        output.setIdentifiedRules(activatedRules.size());
        output.setPassedRules(passedRules);
        output.setFailedRules(failedRules);
        output.setRuleRemarks(ruleSetRemarks);

        return output;
    }
}