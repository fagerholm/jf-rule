package no.jaf.rule.rulewebapp.engine;

import java.util.ArrayList;
import java.util.List;

public class RuleOutput {

    private RuleSet ruleSet;
    private long identifiedRules;
    private long passedRules;
    private long failedRules;
    private List<RuleRemark> ruleRemarks;

    public long getIdentifiedRules() {
        return identifiedRules;
    }

    public void setIdentifiedRules(long identifiedRules) {
        this.identifiedRules = identifiedRules;
    }

    public long getPassedRules() {
        return passedRules;
    }

    public void setPassedRules(long passedRules) {
        this.passedRules = passedRules;
    }

    public long getFailedRules() {
        return failedRules;
    }

    public void setFailedRules(long failedRules) {
        this.failedRules = failedRules;
    }

    public List<RuleRemark> getRuleRemarks() {
        return ruleRemarks;
    }

    public void setRuleRemarks(List<RuleRemark> ruleRemarks) {
        this.ruleRemarks = ruleRemarks;
    }

    public RuleSet getRuleSet() {
        return ruleSet;
    }

    public void setRuleSet(RuleSet ruleSet) {
        this.ruleSet = ruleSet;
    }
}
