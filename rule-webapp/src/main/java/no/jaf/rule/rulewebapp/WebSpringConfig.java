package no.jaf.rule.rulewebapp;

import no.jaf.rule.core.RuleServiceSpringConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(RuleServiceSpringConfig.class)
public class WebSpringConfig {
}
