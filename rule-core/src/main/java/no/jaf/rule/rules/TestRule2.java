package no.jaf.rule.rules;

import no.jaf.rule.core.dto.rule.*;
import no.jaf.rule.core.AbstractBusinessRule;
import no.jaf.rule.core.Rule;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Rule(ruleSets = {RuleSet.SET1})
public class TestRule2 extends AbstractBusinessRule {

    public TestRule2(){
        super(Arrays.asList("text", "number", "test"));
    }

    @Override
    public List<RuleRemark> executeInternal(RuleInput input) {

        boolean test = Boolean.valueOf(input.getInputData().get("test"));
        String text = input.getInputData().get("text");

        List<RuleRemark> remarks = new ArrayList<>();

        if(!test && text.equals("Halloisen")){
            remarks.add(RuleRemark.createRuleRemark(this.getClass().getSimpleName(), RemarkCode.TESTRULE2_FAILED, RemarkSeverity.WARNING ));
        }

        return remarks;
    }
}