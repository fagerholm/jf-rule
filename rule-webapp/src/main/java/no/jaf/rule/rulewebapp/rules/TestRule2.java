package no.jaf.rule.rulewebapp.rules;

import no.jaf.rule.rulewebapp.engine.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static no.jaf.rule.rulewebapp.engine.RuleSet.SET1;

@Rule(ruleSets = {SET1})
public class TestRule2 implements BusinessRule {

    private static final List<String> requiredInputFields = Arrays.asList("text", "number");

    @Override
    public List<RuleRemark> execute(RuleInput input) {

        boolean test = Boolean.valueOf(input.getInputData().get("test"));
        String text = input.getInputData().get("text");

        validateInput(input.getInputData());
        List<RuleRemark> remarks = new ArrayList<>();

        if(!test && text.equals("Halloisen")){
            remarks.add(RuleRemark.createRuleRemark(this.getClass().getSimpleName(), RemarkCode.TESTRULE2_FAILED, RemarkSeverity.WARNING ));
        }

        return remarks;
    }

    private void validateInput(HashMap<String, String> inputData){

        List<String> missingInputFields = new ArrayList<>();
        for(String field : requiredInputFields){
            if(!inputData.containsKey(field)){

                missingInputFields.add(field);
            }
        }

        if(!missingInputFields.isEmpty()){
            throw new MissingRuleInputException(this.getClass().getSimpleName(), requiredInputFields, missingInputFields);
        }
    }
}