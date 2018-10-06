package no.jaf.rule.rulewebapp.rules;

import no.jaf.rule.rulewebapp.engine.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static no.jaf.rule.rulewebapp.engine.RuleSet.SET1;
import static no.jaf.rule.rulewebapp.engine.RuleSet.SET2;


@Rule(ruleSets = {SET1, SET2})
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