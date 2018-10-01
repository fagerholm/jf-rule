package no.jaf.rule.rulewebapp.rules;

import no.jaf.rule.rulewebapp.engine.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static no.jaf.rule.rulewebapp.engine.RuleSet.SET1;
import static no.jaf.rule.rulewebapp.engine.RuleSet.SET2;


@Rule(ruleSets = {SET1, SET2})
public class TestRule1 implements BusinessRule {

    private static final List<String> requiredInputFields = Arrays.asList("number");

    @Override
    public List<RuleRemark> execute(RuleInput input) {

        boolean test = Boolean.valueOf(input.getInputData().get("test"));
        String text = input.getInputData().get("text");
        int number = Integer.parseInt(input.getInputData().get("number"));
        System.out.println("Test: " + test);
        System.out.println("Text: " + text);
        System.out.println("Number: " + number);

        validateInput(input.getInputData());

        List<RuleRemark> remarks = new ArrayList<>();

        if(!test){
            remarks.add(RuleRemark.createRuleRemark(this.getClass().getSimpleName(), RemarkCode.TESTRULE1_FAILED ));
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