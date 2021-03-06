package no.acntech.rule.core;

import no.acntech.rule.core.dto.rule.RemarkCode;
import no.acntech.rule.core.dto.rule.RuleRemark;

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
