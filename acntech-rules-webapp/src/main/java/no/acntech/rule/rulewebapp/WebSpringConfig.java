package no.acntech.rule.rulewebapp;

import no.acntech.rule.core.RuleServiceSpringConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(RuleServiceSpringConfig.class)
public class WebSpringConfig {
}
