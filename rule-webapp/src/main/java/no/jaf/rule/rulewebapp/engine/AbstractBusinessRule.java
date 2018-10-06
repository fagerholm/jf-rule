package no.jaf.rule.rulewebapp.engine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public abstract class AbstractBusinessRule implements BusinessRule {

    protected List<String> requiredInputFields;

    protected abstract List<RuleRemark> executeInternal(RuleInput input);

    public AbstractBusinessRule(List<String> requiredInputFields) {
        this.requiredInputFields = requiredInputFields;
    }

    public List<RuleRemark> execute(RuleInput input){

        validateInput(input.getInputData());
        return executeInternal(input);
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

    public List<String> getRequiredInput(){
        return requiredInputFields;
    }
}
