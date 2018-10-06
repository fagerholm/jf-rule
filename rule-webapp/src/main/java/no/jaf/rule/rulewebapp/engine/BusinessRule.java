package no.jaf.rule.rulewebapp.engine;

import java.util.List;

public interface BusinessRule {

    List<RuleRemark> execute(RuleInput grunnlag);

    default List<RuleRemark> ingenMerknader() {
        return RuleRemarkCreator.noRemarks();
    }

    List<String> getRequiredInput();
}