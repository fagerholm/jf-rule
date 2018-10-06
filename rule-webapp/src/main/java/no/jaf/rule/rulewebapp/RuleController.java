package no.jaf.rule.rulewebapp;

import io.swagger.annotations.*;
import no.jaf.rule.core.dto.configuration.Configuration;
import no.jaf.rule.core.dto.rule.RuleInput;
import no.jaf.rule.core.dto.rule.RuleOutput;
import no.jaf.rule.core.RuleMissingInputException;
import no.jaf.rule.core.RuleApiError;
import no.jaf.rule.core.service.RuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Api(value = "/rules")
@RestController
@RequestMapping("/rules")
public class RuleController {

    private final RuleService ruleService;

    @Autowired
    public RuleController(RuleService ruleService) {
        this.ruleService = ruleService;
    }

    @ApiOperation(value = "Executes set(s) of rules, based on received input", httpMethod = "POST")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "input", value = "The data the rules are executed based on", dataType = "RuleInput", paramType = "body", required = true)})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "A list of remarks calculated by the executed rules", response = RuleOutput.class),
            @ApiResponse(code = 400, message = "Rule execution failed due to missing input. The response body explains expected and missing data", response = RuleApiError.class)})
    @PostMapping(value = "/rules", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> executeRules(@RequestBody() RuleInput input) {

        try {
            return ResponseEntity.ok(ruleService.executeRules(input));

        } catch (RuleMissingInputException mrie) {
            RuleApiError apiError = new RuleApiError(HttpStatus.BAD_REQUEST, mrie.getMessage());
            return new ResponseEntity<>(apiError, new HttpHeaders(), apiError.getStatus());
        }
    }

    @ApiOperation(value = "Returns all rulesets with given rules")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "A list of active rulesets with the belonging rules", response = Configuration.class)})
    @GetMapping(value = "/config", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Configuration>> getAllRuleSets() {

        System.out.println("Tester");
        List<Configuration> configurations = ruleService.getRuleSets();
        System.out.println("Configurations: " + configurations);
        return configurations != null ? ResponseEntity.ok(configurations) : ResponseEntity.noContent().build();
    }
}
