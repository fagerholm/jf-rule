package no.acntech.rule.core.dto.rule;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.Objects;

public class RuleRemark implements Serializable {

    private final String ruleName;
    private final RemarkCode code;
    private final RemarkSeverity severity;

    @JsonCreator
    private RuleRemark(@JsonProperty("ruleName") String ruleName, @JsonProperty("remarkCode") RemarkCode code, @JsonProperty("remarkSeverity") RemarkSeverity severity) {
        this.ruleName = Objects.requireNonNull(ruleName);
        this.code = Objects.requireNonNull(code);
        this.severity = Objects.requireNonNull(severity);
    }

    public static RuleRemark createRuleRemark(String ruleName, RemarkCode code, RemarkSeverity severity) {
        return new RuleRemark(ruleName, code, severity);
    }

    public static RuleRemark createRuleRemark(String ruleName, RemarkCode code) {
        return new RuleRemark(ruleName, code, RemarkSeverity.ERROR);
    }

    public String getRuleName() {
        return ruleName;
    }

    public RemarkCode getCode() {
        return code;
    }

    public RemarkSeverity getSeverity() {
        return severity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RuleRemark that = (RuleRemark) o;
        return Objects.equals(ruleName, that.ruleName) &&
                code == that.code &&
                severity == that.severity;
    }

    @Override
    public int hashCode() {
        return Objects.hash(ruleName, code, severity);
    }

    @Override
    public String toString() {
        return "RuleRemark{" +
                "ruleName='" + ruleName + '\'' +
                ", code=" + code +
                ", severity=" + severity +
                '}';
    }
}
