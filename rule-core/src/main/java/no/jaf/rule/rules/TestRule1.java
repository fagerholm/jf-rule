package no.jaf.rule.rules;

import no.jaf.rule.core.dto.rule.RemarkCode;
import no.jaf.rule.core.dto.rule.RuleInput;
import no.jaf.rule.core.dto.rule.RuleRemark;
import no.jaf.rule.core.dto.rule.RuleSet;
import no.jaf.rule.core.AbstractBusinessRule;
import no.jaf.rule.core.Rule;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Rule(ruleSets = {RuleSet.SET1, RuleSet.SET2})
public class TestRule1 extends AbstractBusinessRule {

    public TestRule1(){
        super(Arrays.asList("number"));
    }

    @Override
    public List<RuleRemark> executeInternal(RuleInput input) {

        boolean test = Boolean.valueOf(input.getInputData().get("test"));

        List<RuleRemark> remarks = new ArrayList<>();

        if(!test){
            remarks.add(RuleRemark.createRuleRemark(this.getClass().getSimpleName(), RemarkCode.TESTRULE1_FAILED ));
        }

        return remarks;
    }

}