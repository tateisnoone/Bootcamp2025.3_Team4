package ge.tbc.testautomation.models.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record SectionComponent(
        String type,
        Inputs inputs
) {
}
