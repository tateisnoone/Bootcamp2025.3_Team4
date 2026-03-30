package ge.tbc.testautomation.models.apiResponse;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record SectionComponent(
        String type,
        Inputs inputs
) {}
