package no.jaf.rule.core;

import no.jaf.rule.core.dto.rule.RuleInput;
import no.jaf.rule.core.dto.rule.RuleRemark;

import java.util.List;

public interface BusinessRule {

    List<RuleRemark> execute(RuleInput grunnlag);

    default List<RuleRemark> ingenMerknader() {
        return RuleRemarkCreator.noRemarks();
    }

    List<String> getRequiredInput();
}