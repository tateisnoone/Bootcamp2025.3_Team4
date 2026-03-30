package ge.tbc.testautomation.models.apiResponse;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Inputs(
        String title,
        List<Button> buttons,
        List<Slide> slides,
        List<Card> cards,
        List<ListItem> list
) {}
