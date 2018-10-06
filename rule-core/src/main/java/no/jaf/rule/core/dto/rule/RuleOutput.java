package no.jaf.rule.core.dto.rule;



import java.util.List;

public class RuleOutput {

    private RuleSet ruleSet;
    private long rulesIdentified;
    private long rulesPassed;
    private long rulesWithRemarks;
    private List<RuleRemark> ruleRemarks;

    public long getRulesIdentified() {
        return rulesIdentified;
    }

    public void setRulesIdentified(long rulesIdentified) {
        this.rulesIdentified = rulesIdentified;
    }

    public long getRulesPassed() {
        return rulesPassed;
    }

    public void setRulesPassed(long rulesPassed) {
        this.rulesPassed = rulesPassed;
    }

    public long getRulesWithRemarks() {
        return rulesWithRemarks;
    }

    public void setRulesWithRemarks(long rulesWithRemarks) {
        this.rulesWithRemarks = rulesWithRemarks;
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

    @Override
    public String toString() {
        return "RuleOutput{" +
                "ruleSet=" + ruleSet +
                ", rulesIdentified=" + rulesIdentified +
                ", rulesPassed=" + rulesPassed +
                ", rulesWithRemarks=" + rulesWithRemarks +
                ", ruleRemarks=" + ruleRemarks +
                '}';
    }
}
