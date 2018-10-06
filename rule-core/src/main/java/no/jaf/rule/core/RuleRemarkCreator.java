package no.jaf.rule.core;

import no.jaf.rule.core.dto.rule.RemarkCode;
import no.jaf.rule.core.dto.rule.RuleRemark;

import java.util.Collections;
import java.util.List;

public class RuleRemarkCreator {

    private RuleRemarkCreator() {
        // NOSONAR
    }

    static List<RuleRemark> createRuleRemark(String ruleName, RemarkCode code) {
        return Collections.singletonList(RuleRemark.createRuleRemark(ruleName, code));
    }

    static List<RuleRemark> noRemarks() {
        return Collections.emptyList();
    }
}
