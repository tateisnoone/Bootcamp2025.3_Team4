package ge.tbc.testautomation.models.apiResponse;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record PageResponse(List<SectionComponent> sectionComponents){}
